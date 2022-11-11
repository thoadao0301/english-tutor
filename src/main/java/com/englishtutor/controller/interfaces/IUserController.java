package com.englishtutor.controller.interfaces;

import com.englishtutor.common.ResponseObject;
import com.englishtutor.dtos.request.user.*;
import com.englishtutor.dtos.response.user.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "User controller", description = "Thao tác với user ")
@RequestMapping(value = "/api/v1/user")
// role mặc định user
public interface IUserController {
    @Operation(
            summary = "Kiểm tra email đã tồn tại",
            description = "- Kiểm tra email đã tồn tại",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @GetMapping("/checkEmailIfExist")
    ResponseEntity<ResponseObject<CheckEmailIfExistResponse>> checkEmailIfExist(CheckEmailIfExistRequest request);

    @Operation(
            summary = "Đăng ký mới user",
            description = "- Đăng ký mới user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @PostMapping("/register")
    ResponseEntity<ResponseObject<RegisterUserResponse>> register(@RequestBody @Valid RegisterUserRequest request);

    // TODO verify account API through email - research

    // role user
    @Operation(
            summary = "Thay đổi thông tin",
            description = "- Thay đổi thông tin",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @PutMapping("/update")
    ResponseEntity<ResponseObject<UpdateUserResponse>> update(@RequestBody @Valid UpdateUserRequest request);

    // role user
    @Operation(
            summary = "Thay đổi ảnh đại diện",
            description = "- Thay đổi ảnh đại diện",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @PutMapping("/updateAvatar")
    ResponseEntity<ResponseObject<UpdateAvatarResponse>> updateAvatar(@RequestBody @Valid UpdateAvatarRequest request);

    // role user
    @Operation(
            summary = "Xem thông tin account",
            description = "- Xem thông tin account",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @GetMapping("/getInfo")
    ResponseEntity<ResponseObject<GetUserInfoResponse>> getInfo(GetUserInfoRequest request);

    // role admin - staff
    @Operation(
            summary = "Xem danh sách user account",
            description = "- Xem danh sách user account",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @GetMapping("/getUserList")
    ResponseEntity<ResponseObject<GetUserListResponse>> getUserList(GetUserListRequest request);
}
