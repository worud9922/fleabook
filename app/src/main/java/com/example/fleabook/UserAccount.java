package com.example.fleabook;

//사용자 계정 모델 class

public class UserAccount {

//    private String idToken;
    private String email;       //id
    private String pw;
    private String nickName;
    private String phoneNum;
    private String birth;
//    private String male;
//    private String female;
    //지역 대학교 계열 성별

    public UserAccount(String email,String pw,String nickName, String phoneNum , String birth ) {
        this.email=email;
        this.pw=pw;
        this.nickName=nickName;
        this.phoneNum=phoneNum;
        this.birth=birth;
    }


//    public String getIdToken() {
//        return idToken;
//    }
//
//    public void setIdToken(String idToken) {
//        this.idToken = idToken;
//    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return this.pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getNickname() {
        return this.nickName;
    }

    public void setNickname(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getBirth() {
        return this.birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

//    public String getMale() {
//        return male;
//    }
//
//    public void setMale(String male) {
//        this.male = male;
//    }
//
//    public String getFemale() {
//        return female;
//    }
//
//    public void setFemale(String female) {
//        this.female = female;
//    }
}
