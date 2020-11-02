package com.czw.file.services;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.czw.file.response.UploadFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Service
public class UploadFileService {
    private static final Logger LOG = LoggerFactory.getLogger(UploadFileService.class);
    //    字典:<'文件名':<'分片序号','分片路径'>>
    private Map<String, Map<String, String>> file_slicePath_dictionary = new TreeMap<>();
    String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
    String endpointWithoutHttp = "oss-cn-shanghai.aliyuncs.com";
    String accessKeyId = "ID";
    String accessKeySecret = "Secret";
    String bucketName = "bucketName";

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
