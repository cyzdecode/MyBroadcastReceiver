package com.cyz.android.mybroadcastreceiver;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 陈志 on 2018/5/8.
 */

public class Login extends BaseActivity{
    private Button loginbt;
    private EditText etusername,etpassword;
    private CheckBox chk;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etusername=(EditText)findViewById(R.id.user);
        etpassword=(EditText)findViewById(R.id.pwd);
        chk=(CheckBox)findViewById(R.id.cksave);
        pref=getSharedPreferences("userInfo",MODE_PRIVATE);
        editor=pref.edit();
        String username=pref.getString("name","");
        if(username==""){
            chk.setChecked(false);
        }else {
            etusername.setText(username);
            chk.setChecked(true);
        }
        loginbt=(Button)findViewById(R.id.login);
        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etusername.getText().toString().trim();
                String pass=etpassword.getText().toString().trim();
                if("admin".equals(name)&&"123456".equals(pass)){
                    if(chk.isChecked()){
                        editor.putString("name",name);
                        editor.commit();
                    }else {
                        editor.remove("name");
                        editor.commit();
                    }
                    //跳转页面
                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(Login.this,"登陆成功",Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    //提示登录失败
                    etpassword.setText("");
                    Toast.makeText(Login.this,"登陆失败",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
