package com.thoa.englishTutor.service;

import com.thoa.englishTutor.enums.UserRole;
import com.thoa.englishTutor.model.User;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;

import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Arrays;

@Service
@Slf4j
public class KeycloakService {
    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.auth-server-url}")
    private String severUrl;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;


    public String createUserInKeyCloak(User user, String password){
        Keycloak keycloak = KeycloakBuilder.builder() //
                .serverUrl(severUrl) //
                .realm(realm) //
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS) //
                .clientId(clientId) //
                .clientSecret(clientSecret)
                .build();

        UserRepresentation keycloakUser = new UserRepresentation();
        keycloakUser.setUsername(user.getEmail());
        keycloakUser.setEmail(user.getEmail());
        keycloakUser.setEnabled(true);

        // Get realm
        RealmResource realmResource = keycloak.realm(realm);
        UsersResource usersResource = realmResource.users();

        // Create Keycloak user
        Response result = null;
        try {
            result = usersResource.create(keycloakUser);
            log.info("{},{}",result.getStatusInfo(), usersResource.list().get(0).getUsername());
        } catch(Exception e) {
            log.error("Keycloak can not create the new user");
            throw new RuntimeException("Keycloak can not create the new user");
        }

        if (result==null || result.getStatus() != 201) {
            log.error("Keycloak result return null");
            throw new RuntimeException("Keycloak result return null");
        }

        String userId = CreatedResponseUtil.getCreatedId(result);

        UserResource userResource = usersResource.get(userId);
        try {
            // Define password credential
            CredentialRepresentation passwordCred = new CredentialRepresentation();
            passwordCred.setTemporary(false);
            passwordCred.setType(CredentialRepresentation.PASSWORD);
            passwordCred.setValue(password);

            // Set password credential
            userResource.resetPassword(passwordCred);
        }catch (Exception e){
            userResource.remove();
            log.error("Keycloak assigns password get error");
        }


        try {
            // Get client
            ClientRepresentation app1Client = realmResource.clients() //
                    .findByClientId(clientId).get(0);

            // Get client level role (requires view-clients role)
            String role = user.getRole().equals(UserRole.ROLE_STUDENT) ? "Student" : "Tutor";
            RoleRepresentation userClientRole = realmResource.clients().get(app1Client.getId()) //
                    .roles().get(role).toRepresentation();


            // Assign client level role to user
            userResource.roles() //
                    .clientLevel(app1Client.getId()).add(Arrays.asList(userClientRole));
        }catch (Exception e){
            userResource.remove();
            log.error("Keycloak assigns role get error");
        }
        return userId;
    }

    @SneakyThrows
    public void removeUserOnKeycloak(String userId){
        Keycloak keycloak = KeycloakBuilder.builder() //
                .serverUrl(severUrl) //
                .realm(realm) //
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS) //
                .clientId(clientId) //
                .clientSecret(clientSecret)
                .build();

        // Get realm
        RealmResource realmResource = keycloak.realm(realm);
        UsersResource usersResource = realmResource.users();

        UserResource userResource = usersResource.get(userId);
        userResource.remove();
    }

}
