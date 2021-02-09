package com.czw.file.controller;

import com.czw.file.response.UploadFileResponse;
import com.czw.file.services.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@Api(value = "文件传输接口",tags = "文件传输接口")
public class UploadFileController {
    private static final Logger LOG = LoggerFactory.getLogger(UploadFileController.class);
    @Autowired
    private UploadFileService uploadFileService;

    @PostMapping("/uploadFile2OSS")
    @ApiOperation(value = "上传文件至OSS", notes = "上传文件至OSS中")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", paramType = "MultipartFile", dataType = "MultipartFile", required = true),
            @ApiImplicitParam(name = "src", value = "OSS中的文件路径", paramType = "String", dataType = "String", required = true)
    })
    public UploadFileResponse uploadFile(@RequestParam(value = "file") MultipartFile file,@RequestParam(value = "src") String src) throws IOException {
        LOG.info("开始上传");
        return uploadFileService.UpLoadFile2OSS(file,src);
    }

    @ApiOperation(value = "删除OSS文件", notes = "删除目标路径的OSS文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "src", value = "目标文件在OSS中的路径", paramType = "String", dataType = "String", required = true)
    })
    @PostMapping("/deleteOSSFile")
    public String deleteOSSFile(@RequestParam(value = "src") String src){
        return "删除成功";
    }


}
