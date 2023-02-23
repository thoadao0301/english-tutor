package com.thoa.englishTutor.controller.interfaces;

import com.thoa.englishTutor.common.ResponseObject;
import com.thoa.englishTutor.dtos.request.auth.ChangePasswordRequest;
import com.thoa.englishTutor.dtos.request.auth.LoginRequest;
import com.thoa.englishTutor.dtos.request.auth.LogoutRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Auth controller", description = "Thao tác với authentication ")
@RequestMapping(value = "/api/v1/auth")
public interface IAuthController {
    @Operation(
            summary = "Đăng nhập",
            description = "- Đăng nhập",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @PostMapping("/login")
    ResponseEntity<ResponseObject> login(LoginRequest request);


    @Operation(
            summary = "Đăng xuất",
            description = "- Đăng xuất",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @PostMapping("/logout")
    ResponseEntity<ResponseObject> logout(LogoutRequest request);

    @Operation(
            summary = "Thay đổi mật khẩu",
            description = "- Thay đồi mật khẩu",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @PostMapping("/changePassword")
    ResponseEntity<ResponseObject> changePassword(ChangePasswordRequest request);
}
