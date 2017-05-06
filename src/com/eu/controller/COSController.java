package com.eu.controller;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by lip on 17/5/6.
 */
@Controller
@RequestMapping("/cos")
public class COSController {

    // COS  ID
    private long appId = 1251935523;
    private String secretId = "AKIDjL3gKZan1wFvzjwB59RwAxwoxsx5Lh7s";
    private String secretKey = "3ytCHOcU9Iq5tQ6IzhvquXl7yl3zXY2O";
    // 设置要操作的bucket
    private String bucketName = "eu";

    @RequestMapping("/activity")
    @ResponseBody
    public String uploadActivityLogoToCos(@RequestParam("file") CommonsMultipartFile file){
        String filePath = "/activity/av" + Long.toString(System.currentTimeMillis()) + ".jpg";
        return uploadToCOS(file,filePath);
    }

    @RequestMapping("/user")
    @ResponseBody
    public String uploadUserLogoToCos(@RequestParam("file") CommonsMultipartFile file){
        String filePath = "/user/user" + Long.toString(System.currentTimeMillis()) + ".jpg";
        return uploadToCOS(file,filePath);
    }

    @RequestMapping("/community/logo")
    @ResponseBody
    public String uploadCommunityLogo(@RequestParam("file") CommonsMultipartFile file){
        String filePath = "/community/logo/cmlogo" + Long.toString(System.currentTimeMillis()) + ".png";
        return uploadToCOS(file,filePath);
    }

    @RequestMapping("/community/background")
    @ResponseBody
    public String uploadCommunityBackground(@RequestParam("file") CommonsMultipartFile file){
        String filePath = "/community/background/cmbg" + Long.toString(System.currentTimeMillis()) + ".jpg";
        return uploadToCOS(file,filePath);
    }

    @RequestMapping("/verify")
    @ResponseBody
    public String uploadVerifyPhoto(@RequestParam("file") CommonsMultipartFile file){

        String filename = file.getOriginalFilename();
        String filePath = "/verify/" + filename;
        return uploadToCOS(file,filePath);
    }

    private String uploadToCOS(CommonsMultipartFile file,String filePath){
        // 初始化秘钥信息
        Credentials cred = new Credentials(appId, secretId, secretKey);

        // 初始化客户端配置
        ClientConfig clientConfig = new ClientConfig();
        // 设置bucket所在的区域，比如华南园区：gz； 华北园区：tj；华东园区：sh
        clientConfig.setRegion("sh");

        // 获取 byte[]
        byte[] localFileByte = file.getBytes();

        // 初始化cosClient
        COSClient cosClient = new COSClient(clientConfig, cred);

        // 构造上传请求
        UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName,filePath,localFileByte);
        String uploadResult = cosClient.uploadFile(uploadFileRequest);
        return uploadResult;
    }

}
