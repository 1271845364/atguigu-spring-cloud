package com.yejinhui.springboot.controller;

import com.yejinhui.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.HashMap;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/9/26 14:23
 */
@ControllerAdvice
public class MyExceptionHandler {

    //浏览器和客户端返回的都是json数据，没有自适应效果，不能自适应是浏览器还是客户端
    //一旦出现异常，springmvc自动会调用这个方法，如果是UserNotExistException就会执行该方法
//    @ExceptionHandler(UserNotExistException.class)
//    @ResponseBody
//    public Map<String,Object> handlerException(Exception e) {
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(value = UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        //传入我们自己的错误状态码 4xx 5xx，否则就不会进入定制错误页面的解析流程
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message","用户出错了");
        request.setAttribute("ext",map);
        //转发到/error
        return "forward:/error";
    }


}