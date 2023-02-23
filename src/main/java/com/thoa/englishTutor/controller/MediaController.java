package com.thoa.englishTutor.controller;


import com.thoa.englishTutor.common.ResponseObject;
import com.thoa.englishTutor.controller.interfaces.IMediaController;
import com.thoa.englishTutor.dtos.request.storage.DownloadFileRequest;
import com.thoa.englishTutor.dtos.request.storage.UploadFileRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MediaController implements IMediaController {
    @Override
    public ResponseEntity<ResponseObject> upload(UploadFileRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> download(DownloadFileRequest request) {
        return null;
    }
}
