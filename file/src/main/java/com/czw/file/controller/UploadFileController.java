package com.czw.file.controller;

import com.czw.file.response.UploadFileResponse;
import com.czw.file.services.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class UploadFileController {
    private static final Logger LOG = LoggerFactory.getLogger(UploadFileController.class);
    @Autowired
    private UploadFileService uploadFileService;

    @PostMapping("/uploadFile2OSS")
    public UploadFileResponse uploadFile(@RequestParam(value = "file") MultipartFile file,@RequestParam(value = "src") String src) throws IOException {
        LOG.info("开始上传");
        return uploadFileService.UpLoadFile2OSS(file,src);
    }
}
