package com.englishtutor.controller;


import com.englishtutor.common.ResponseObject;
import com.englishtutor.controller.interfaces.IMediaController;
import com.englishtutor.dtos.request.storage.DownloadFileRequest;
import com.englishtutor.dtos.request.storage.UploadFileRequest;
import com.englishtutor.dtos.response.storage.UploadFileReponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MediaController implements IMediaController {
    @Override
    public ResponseEntity<ResponseObject<UploadFileReponse>> upload(UploadFileRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject<byte[]>> download(DownloadFileRequest request) {
        return null;
    }
}
