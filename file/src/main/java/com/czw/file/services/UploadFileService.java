package com.czw.file.services;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
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
        //如果之前这个路径有文件则删除它
        deleteOSSFile(src);
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        InputStream inputStream = file.getInputStream();
        ossClient.putObject(bucketName, src, inputStream);
        ossClient.shutdown();
        UploadFileResponse uploadFileResponse = new UploadFileResponse();
        uploadFileResponse.setFileUrl_OSS("https://" + bucketName + "." + endpointWithoutHttp + "/" + src);
        return uploadFileResponse;
    }

    /**
     * 删除oss文件,如果删除文件则需要写它的完整名称，如果要删除文件夹及它里面所有文件则写文件夹的路径
     *
     * @param src
     * @return
     */
    public void deleteOSSFile(String src) {
        List<OSSObjectSummary> sums;
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ObjectListing objectListing = ossClient.listObjects(bucketName, src);
        sums = objectListing.getObjectSummaries();
        LOG.info("查询得到的结果" + sums.toString());
        for (OSSObjectSummary sum : sums) {
            LOG.info("将要删除:" + sum.getKey());
            ossClient.deleteObject(bucketName, sum.getKey());
        }
        ossClient.shutdown();
    }
}
