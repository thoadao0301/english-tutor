package com.thoa.englishTutor.controller.interfaces;

import com.thoa.englishTutor.common.ResponseObject;
import com.thoa.englishTutor.dtos.request.storage.DownloadFileRequest;
import com.thoa.englishTutor.dtos.request.storage.UploadFileRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Storage controller", description = "Thao tác với file ")
@RequestMapping(value = "/api/v1/storage")
public interface IMediaController {
    @Operation(
            summary = "Upload file",
            description = "- Upload file",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @PostMapping("/upload")
    ResponseEntity<ResponseObject> upload(UploadFileRequest request);

    @Operation(
            summary = "download file",
            description = "- download file",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @GetMapping("/download")
    ResponseEntity<ResponseObject> download(DownloadFileRequest request);
}
