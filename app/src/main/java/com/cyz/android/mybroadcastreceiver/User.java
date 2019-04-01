package com.cyz.android.mybroadcastreceiver;

/**
 * Created by 陈志 on 2018/11/27.
 */

public class User {
    private String u_loginName;
    private String u_passWord;
    private String u_trueName;
    private String u_email;
    private int u_state;
    private  int r_id;

    public String getU_loginName() {
        return u_loginName;
    }

    public void setU_loginName(String u_loginName) {
        this.u_loginName = u_loginName;
    }

    public String getU_passWord() {
        return u_passWord;
    }

    public void setU_passWord(String u_passWord) {
        this.u_passWord = u_passWord;
    }

    public String getU_trueName() {
        return u_trueName;
    }

    public void setU_trueName(String u_trueName) {
        this.u_trueName = u_trueName;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public int getU_state() {
        return u_state;
    }

    public void setU_state(int u_state) {
        this.u_state = u_state;
    }

    public int getR_id() {

        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }
}
