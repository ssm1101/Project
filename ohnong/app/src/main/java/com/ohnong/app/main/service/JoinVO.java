package com.ohnong.app.main.service;

import java.util.Date;

import lombok.Data;

@Data
public class JoinVO {
    
    private String userId;
    private String userPw;
    private String userName;
    private String birth;
    private String userEmail;
    private String userAddr;
    private String userTel;
   
    private String checkPw;
    
    public boolean isPwEqualToCheckPw() {
        return userPw.equals(checkPw);
    }
}
