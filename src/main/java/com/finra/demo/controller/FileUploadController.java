package com.finra.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.finra.demo.Entity.FileUpload;
import com.finra.demo.dao.IFileUploadDao;

@Controller
public class FileUploadController implements ErrorController{
	
	@Autowired
    private IFileUploadDao fileUploadDao;
 
    @GetMapping(value = "/")
    public String showUploadForm() {
        return "upload";
    }
     
    @RequestMapping(value = "/upload")
    public String handleFileUpload(@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
          
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){
              FileUpload file = new FileUpload();
               file.setFile_name(aFile.getOriginalFilename());
               file.setFile_data(aFile.getBytes());
                fileUploadDao.save(file);               
            }
        }
  
        return "Success";
    }  
    
    @RequestMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
    
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

    public String getErrorPath() {
        return PATH;
    }

}
