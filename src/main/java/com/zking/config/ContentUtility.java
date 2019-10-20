package com.zking.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ContentUtility {
    public static int getCurrentUserId(HttpServletRequest request){
        HttpSession session=request.getSession();
        if(session.getAttribute(StaticConfigParam.LOGIN_IN_USER_ID)!=null){
            return (Integer)session.getAttribute(StaticConfigParam.LOGIN_IN_USER_ID);
        }else{
            return -1;
        }
    }
}
