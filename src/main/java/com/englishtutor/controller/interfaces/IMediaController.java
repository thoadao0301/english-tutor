package com.englishtutor.controller.interfaces;

import com.englishtutor.common.ResponseObject;
import com.englishtutor.dtos.request.storage.DownloadFileRequest;
import com.englishtutor.dtos.request.storage.UploadFileRequest;
import com.englishtutor.dtos.response.storage.UploadFileReponse;
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
    ResponseEntity<ResponseObject<UploadFileReponse>> upload(UploadFileRequest request);

    @Operation(
            summary = "download file",
            description = "- download file",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @GetMapping("/download")
    ResponseEntity<ResponseObject<byte[]>> download(DownloadFileRequest request);
}
