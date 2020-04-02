package com.zking.controller;

import com.zking.Service.FilePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FileUploadController {
    @Autowired
    private FilePathService filePathService;
    // 传入的参数file是我们指定的文件
   @GetMapping("/upload")
    public ModelAndView upload() {
        ModelAndView mv = new ModelAndView("upload");
        return mv;
    }
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
                         HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        if (code != null && code.equals("uploadvideo")) {
            try {
                request.getRequestDispatcher("upload.html").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filePathService.Upload(file);
    }
}