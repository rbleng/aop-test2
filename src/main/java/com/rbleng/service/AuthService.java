package com.rbleng.service;

import com.rbleng.security.CurrentUserHolder;
import org.springframework.stereotype.Component;

// 权限校验
@Component
public class AuthService {

    public void checkAccess(){
        String user = CurrentUserHolder.get();
        if(!"admin".equals(user)){
            throw new RuntimeException("operation not allow");
        }
    }
}