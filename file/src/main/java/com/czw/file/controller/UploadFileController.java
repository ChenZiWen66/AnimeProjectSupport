package com.czw.file.controller;

import com.czw.file.response.UploadFileResponse;
import com.czw.file.services.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UploadFileController {
    private static final Logger LOG = LoggerFactory.getLogger(UploadFileController.class);
    @Autowired
    private UploadFileService uploadFileService;

    /**
     * 上传文件到OSS上面
     * @param file:分片文件
     * @param currentIndex:当前文件的分片索引
     * @param totalIndex:文件分片索引的总数
     * @param filename:文件名
     * @param oss_src:oss存储路径
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile2OSS(@RequestParam(value = "file") MultipartFile file,
                                             @RequestParam(value = "currentIndex") String currentIndex,
                                             @RequestParam(value = "totalIndex") String totalIndex,
                                             @RequestParam(value = "fileName") String filename,
                                             @RequestParam(value = "oss_src") String oss_src) throws IOException {
        LOG.info("开始上传文件到OSS上面");
        return uploadFileService.UpLoadFile(file, currentIndex, totalIndex, filename,oss_src);
    }
}
