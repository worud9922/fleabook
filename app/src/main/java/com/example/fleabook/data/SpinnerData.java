package com.example.fleabook.data;

import android.widget.Spinner;

public class SpinnerData {

    private String idToken;
    private Spinner s1, s2, s3;

    public SpinnerData (){
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public Spinner getS1() {
        return s1;
    }

    public void setS1(Spinner s1) {
        this.s1 = s1;
    }

    public Spinner getS2() {
        return s2;
    }

    public void setS2(Spinner s2) {
        this.s2 = s2;
    }

    public Spinner getS3() {
        return s3;
    }

    public void setS3(Spinner s3) {
        this.s3 = s3;
    }
}
