package com.dsvc.util;

import java.net.MalformedURLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * @author xh.d
 * @date 2017/11/22 13:34
 */
@Service
public class ContextUtil {
    @Autowired
    private ServletContext servletContext;
    
    private ServletContext getCurrentContext(){
        return servletContext;
    }
    public String getContextPath(){
        return getCurrentContext().getContextPath();
    }
    public String getRealPath(String path){
        return getCurrentContext().getRealPath(path);
    }
    public HttpServletRequest getCurrentHttpServletRequest() {
        ServletRequestAttributes ras = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ras.getRequest();
        return request;
    }
}
