package com.example.storagedemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {


    private EditText accEdt,pwdEdt;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiry_share);

        accEdt = findViewById(R.id.acc_edt);
        pwdEdt = findViewById(R.id.pwd_edt);

        findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框数据
                String account = accEdt.getText().toString();
                String pwd = pwdEdt.getText().toString();
                //验证身份
                if(account.equals("admin") && pwd.equals("123")){

                    SharedPreferences sharedPreferences = getSharedPreferences("myshare",MODE_PRIVATE);
                    SharedPreferences.Editor edt =  sharedPreferences.edit();

                    edt.putString("account",account);
                    edt.putString("pwd",pwd);
                    edt.commit();

                    Toast.makeText(ShareActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ShareActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
