package com.zking.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*
* @ConreollerAdvice监控上传文件大小是否受限，出现异常时前端给出提示
* */
@ControllerAdvice
public class GlobalEexceptionHandler {
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message",e.getCause().getMessage());
        return "redirect:/upload";
    }
}
