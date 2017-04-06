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
    public RequestResult uploadActivityLogo(@RequestParam("file") CommonsMultipartFile file){

        //文件名
        String filename = Long.toString(System.currentTimeMillis()) + ".png";
        String path = "D:\\picture\\activity";
        System.out.println(filename);


        try {
            InputStream is = file.getInputStream();
            OutputStream os = new FileOutputStream(new File(path,filename));
            int len=0;
            byte[] buffer = new byte[400];
            while ((len=is.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            os.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new RequestResult(500,"faild",e.getMessage());

        }

        return new RequestResult(200,"OK",filename);

    }

}
