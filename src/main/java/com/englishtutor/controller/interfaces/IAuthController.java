package com.englishtutor.controller.interfaces;

import com.englishtutor.common.ResponseObject;
import com.englishtutor.dtos.request.auth.ChangePasswordRequest;
import com.englishtutor.dtos.request.auth.LoginRequest;
import com.englishtutor.dtos.request.auth.LogoutRequest;
import com.englishtutor.dtos.response.auth.ChangePasswordResponse;
import com.englishtutor.dtos.response.auth.LoginResponse;
import com.englishtutor.dtos.response.auth.LogoutResponse;
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
    ResponseEntity<ResponseObject<LoginResponse>> login(LoginRequest request);


    @Operation(
            summary = "Đăng xuất",
            description = "- Đăng xuất",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @PostMapping("/logout")
    ResponseEntity<ResponseObject<LogoutResponse>> logout(LogoutRequest request);

    @Operation(
            summary = "Thay đổi mật khẩu",
            description = "- Thay đồi mật khẩu",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @PostMapping("/changePassword")
    ResponseEntity<ResponseObject<ChangePasswordResponse>> changePassword(ChangePasswordRequest request);
}
