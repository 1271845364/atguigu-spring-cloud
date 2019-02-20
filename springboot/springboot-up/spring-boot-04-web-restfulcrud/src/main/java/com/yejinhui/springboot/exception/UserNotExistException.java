package com.yejinhui.springboot.exception;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/9/26 13:52
 */
public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
        super("用户不存在");
    }

}
