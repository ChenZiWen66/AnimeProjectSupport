package com.czw.file.services;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.czw.file.response.UploadFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Service
@PropertySource("classpath:/application.properties")
public class UploadFileService {
    private static final Logger LOG = LoggerFactory.getLogger(UploadFileService.class);
    @Value("${endpoint}")
    private String endpoint;
    @Value("${endpointWithoutHttp}")
    private String endpointWithoutHttp;
    @Value("${accessKeyId}")
    private String accessKeyId;
    @Value("${accessKeySecret}")
    private String accessKeySecret;
    @Value("${bucketName}")
    private String bucketName;

    public UploadFileResponse UpLoadFile2OSS(MultipartFile file, String src) throws IOException {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        InputStream inputStream = file.getInputStream();
        ossClient.putObject(bucketName, src, inputStream);
        ossClient.shutdown();
        UploadFileResponse uploadFileResponse = new UploadFileResponse();
        uploadFileResponse.setFileUrl_OSS("https://"+bucketName+"."+endpointWithoutHttp+"/"+src);
        return uploadFileResponse;
    }
}
