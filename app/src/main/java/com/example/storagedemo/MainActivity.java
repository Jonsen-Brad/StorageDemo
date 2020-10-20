package com.example.storagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        findViewById(R.id.share_btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,ShareActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        findViewById(R.id.external_btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,ExternalActivity.class);
//                startActivity(intent);
//            }
//        });


    }
    Intent intent;
    public void switchActivity(View view){
        switch (view.getId()){
            case R.id.share_btn:
                intent = new Intent(MainActivity.this,ShareActivity.class);
                startActivity(intent);
                break;

            case R.id.external_btn:
                intent = new Intent(MainActivity.this,ExternalActivity.class);
                startActivity(intent);
                break;
            case R.id.internal_btn:
//                intent = new Intent(MainActivity.this,ExternalActivity.class);
//                startActivity(intent);
                break;
            case R.id.listView_btn:
                intent = new Intent(MainActivity.this,AppListActivity.class);
                startActivity(intent);
        }
    }


}
