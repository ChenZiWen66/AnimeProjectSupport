package com.czw.file.services;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.czw.file.response.UploadFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Service
public class UploadFileService {
    private static final Logger LOG = LoggerFactory.getLogger(UploadFileService.class);
    //    字典:<'文件名':<'分片序号','分片路径'>>
    private Map<String, Map<String, String>> file_slicePath_dictionary = new TreeMap<>();
    String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
    String endpointWithoutHttp = "oss-cn-shanghai.aliyuncs.com";
    String accessKeyId = "阿里云ID";
    String accessKeySecret = "阿里云密码";

    public UploadFileResponse UpLoadFile(MultipartFile file, String currentIndex, String totalIndex, String filename, String oss_src) throws IOException {
        LOG.info("开始接收文件[" + filename + "]分片");
        String sliceName = file.getOriginalFilename();
        String fullPath = "C:\\Users\\adm\\Desktop\\" + UUID.randomUUID() + sliceName;
        File dest = new File(fullPath);
        file.transferTo(dest);
//        分片的字典
        Map<String, String> slicePath_dictionary = new TreeMap<>();
//        如果已经有字典就获取它
        if (file_slicePath_dictionary.containsKey(filename)) {
            slicePath_dictionary = file_slicePath_dictionary.get(filename);
        }
        slicePath_dictionary.put(currentIndex, fullPath);
        file_slicePath_dictionary.put(filename, slicePath_dictionary);
        UploadFileResponse uploadFileResponse = new UploadFileResponse();
        //如果接收了所有的分片,则返回文件路径
        if (slicePath_dictionary.size() == Integer.parseInt(totalIndex)) {
            LOG.info("文件[" + filename + "]所有分片接收成功");
            //合并文件，并上传至OSS中
            String fileURL_OSS = combine(filename, oss_src);
            uploadFileResponse.setFileUrl_OSS(fileURL_OSS);
            LOG.info("成功上传文件[" + filename + "]至OSS");
        } else {
            //如果还有后续则返回1111111
            uploadFileResponse.setFileUrl_OSS("11111111111111");
        }
        return uploadFileResponse;
    }

    /**
     * 上传到阿里云OSS
     *
     * @param filename:文件名
     * @param oss_src:oss_存储路径 如 陈子文的一天/第一集/video.mp4
     * @return 返回阿里云OSS的URL
     * @throws IOException
     */
    public String combine(String filename, String oss_src) throws IOException {
        LOG.info("开始合并[" + filename + "]文件分片");
        UUID uuid = UUID.randomUUID();
        File file = new File("C:\\Users\\adm\\Desktop\\" + uuid.toString() + filename);
        FileOutputStream outputStream = new FileOutputStream(file, true);
        byte[] bytes = new byte[3 * 1024 * 1024];
        int len;
        Map<String, String> slicePath_dictionary = file_slicePath_dictionary.get(filename);
        for (int i = 0; i < slicePath_dictionary.size(); i++) {
            File objFile = new File(slicePath_dictionary.get(String.valueOf(i)));
            FileInputStream inputStream = new FileInputStream(objFile);
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            inputStream.close();
            //删除分片
            if (objFile.exists()) {
                objFile.delete();
            }
        }
        outputStream.close();
        file_slicePath_dictionary.remove(filename);

        LOG.info("开始上传文件[" + filename + "]至OSS");
        //上传至阿里云OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //上传路径应该为“动漫名UUID/章节名UUID/video.mp4”或者"动漫名UUID/章节名UUID/cover.jpg",动漫封面路径为“动漫名UUID/cover.jpg”
        PutObjectRequest putObjectRequest = new PutObjectRequest("anime-czw", oss_src, new FileInputStream(file));
        ossClient.putObject(putObjectRequest);
        ossClient.shutdown();
        //删除本地文件
        if (file.exists()) {
            file.delete();
        }
        LOG.info("上传文件到成功:{}", "https://anime-czw." + endpointWithoutHttp + "//" + oss_src);
        return "https://anime-czw." + endpointWithoutHttp + "//" + oss_src;
    }
}
