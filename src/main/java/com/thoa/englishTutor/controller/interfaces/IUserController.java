package com.thoa.englishTutor.controller.interfaces;

import com.thoa.englishTutor.common.ResponseObject;
import com.thoa.englishTutor.dtos.request.user.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Tag(name = "User controller", description = "Thao tác với user ")
@RequestMapping(value = "/api/v1/user")
// role mặc định user
public interface IUserController {
    @Operation(
            summary = "Check email if existed",
            description = "- Check email if existed",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @GetMapping("/checkEmailIfExist")
    ResponseEntity<ResponseObject> checkEmailIfExist(@Parameter String email);

    @Operation(
            summary = "Student register",
            description = "- Student register",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @PostMapping("/studentRegister")
    ResponseEntity<ResponseObject> studentRegister(@RequestBody @Valid RegisterUserRequest request);

    @Operation(
            summary = "Tutor register",
            description = "- Tutor register",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @PostMapping("/tutorRegister")
    ResponseEntity<ResponseObject> tutorRegister(@RequestBody @Valid RegisterUserRequest request);

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
    ResponseEntity<ResponseObject> update(Principal principal, @RequestBody @Valid UpdateUserRequest request);

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
    ResponseEntity<ResponseObject> updateAvatar(@RequestBody @Valid UpdateAvatarRequest request);

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
    ResponseEntity<ResponseObject> getInfo(Principal principal);

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
    ResponseEntity<ResponseObject> getUserList(Principal principal);
}
