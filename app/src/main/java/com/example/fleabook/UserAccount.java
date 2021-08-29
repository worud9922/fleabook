package com.example.fleabook;

public class UserAccount {

    private String idToken;
    private String email;       //id
    private String pw;
    private String pwCheck;
    private String nickName;
    private String phoneNum;
    private String birth;
    //지역 대학교 계열 성별

    public UserAccount(){ }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPwCheck() {
        return pwCheck;
    }

    public void setPwCheck(String pwCheck) {
        this.pwCheck = pwCheck;
    }

    public String getNickname() {
        return nickName;
    }

    public void setNickname(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
