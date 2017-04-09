package com.eu.controller;

import com.eu.pojo.RequestResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

/**
 * Created by lip on 17/4/5.
 */

@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/activity")
    @ResponseBody
    public RequestResult uploadActivityLogo(@RequestParam("file") CommonsMultipartFile file){

        //文件名
        String filename = Long.toString(System.currentTimeMillis()) + ".jpg";
        String path = "D:\\picture\\activity";

        try {
            uploadFile(filename,path,file);
        } catch (Exception e) {
            return new RequestResult(500,"faild",e.getMessage());

        }

        return new RequestResult(200,"OK",filename);

    }

    @RequestMapping("/user")
    @ResponseBody
    public RequestResult uploadUserLogo(@RequestParam("file") CommonsMultipartFile file){

        //文件名
        String filename = Long.toString(System.currentTimeMillis()) + ".jpg";
        String path = "D:\\picture\\user";
        try {
            uploadFile(filename,path,file);
        }catch (Exception e) {
            return new RequestResult(500, e.getMessage(), null);
        }
        return new RequestResult(200,"OK",filename);

    }

    @RequestMapping("/community/logo")
    @ResponseBody
    public RequestResult uploadCommunityLogo(@RequestParam("file") CommonsMultipartFile file){

        //文件名
        String filename = Long.toString(System.currentTimeMillis()) + ".jpg";
        String path = "D:\\picture\\community\\logo";
        try {
            uploadFile(filename,path,file);
        }catch (Exception e) {
            return new RequestResult(500, e.getMessage(), null);
        }
        return new RequestResult(200,"OK",filename);

    }

    @RequestMapping("/community/background")
    @ResponseBody
    public RequestResult uploadCommunityBackground(@RequestParam("file") CommonsMultipartFile file){

        //文件名
        String filename = Long.toString(System.currentTimeMillis()) + ".jpg";
        String path = "D:\\picture\\community\\background";
        try {
            uploadFile(filename,path,file);
        }catch (Exception e) {
            return new RequestResult(500, e.getMessage(), null);
        }
        return new RequestResult(200,"OK",filename);

    }

    void uploadFile(String filename,String path,CommonsMultipartFile file) throws Exception{

        InputStream is = file.getInputStream();
        OutputStream os = new FileOutputStream(new File(path,filename));
        int len=0;
        byte[] buffer = new byte[400];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        os.close();
        is.close();
    }

}

