package com.example.storagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.EmptyStackException;

public class ExternalActivity extends AppCompatActivity {

    EditText infoEdt;
    TextView txt_view;
    private  final String mFileName = "test.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);

        infoEdt = findViewById(R.id.info_edt);
        txt_view = findViewById(R.id.text_view);
    }

    public void operate(View v){
        //String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/text.txt";


        //Log.e("TAG",path);
        //if(Environment.getExternalStorageState().equals("mounted"))
        switch (v.getId()){
            case R.id.save_btn:
                /*File f = new File(path);
                try{
                    if(!f.exists()){
                        f.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(path,true);
                    String str = infoEdt.getText().toString();
                    fos.write(str.getBytes());
                }catch (IOException e){
                    e.printStackTrace();
                }*/

                save(infoEdt.getText().toString());
                break;
            case R.id.display_btn:
                txt_view.setText(read());
                break;
        }
    }

    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try {
            //fileOutputStream = openFileOutput(mFileName,MODE_PRIVATE);
            File dir = new File(Environment.getExternalStorageDirectory(),"skypan");
            if(!dir.exists()){
                dir.mkdir();
            }
            File file = new File(dir,mFileName);
            if(!file.exists()){
                file.createNewFile();
            }
            Log.e("TAG",file.toString());
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();

                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }

    private String read()  {
        FileInputStream fileInputStream = null;
        try {
            //fileInputStream = openFileInput(mFileName);
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"skypan",mFileName);
            //此问题报错已解决，
            //应该将getExternalStorageState()改成getExternalStorageDirectory()

            fileInputStream = new FileInputStream(file);
            byte[] buff = new byte[1024];
            StringBuffer sb = new StringBuffer("");
            int len = 0;
            while ((len = fileInputStream.read(buff)) > 0){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


}
