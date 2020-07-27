package com.aze.space.android.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aze.learnandroid.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskActivity extends Activity {
    private static final Object FILE_NAME = "download.app";
    private  static  final  String APP_URL = "http://download.sj.qq.com/upload/connAssitantDownload/upload/MobileAssistant_1.apk";
    private Button m_DownloadBtn;
    private ProgressBar m_ProgressBar;
    private TextView m_ResultViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        m_DownloadBtn = (Button)this.findViewById(R.id.btn_download);
        m_ProgressBar = (ProgressBar)this.findViewById(R.id.progressBar);
        m_ResultViewText = (TextView)this.findViewById(R.id.progressTips);

        m_DownloadBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DownLoadAsyncTask task = new DownLoadAsyncTask();
                task.execute(APP_URL);
            }
        });
    }

    public class DownLoadAsyncTask extends AsyncTask<String,Integer,Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
//            if (params != null && params.length > 0){
//                String apkurl = params[0];
//                URL url = null;
//                try {
//                    url = new URL(apkurl);
//                    URLConnection urlConnection =   url.openConnection();
//                    InputStream inputStream = urlConnection.getInputStream();
//
//                    int contentlenght = urlConnection.getContentLength();
//                    String mfilePath = Environment.getExternalStorageDirectory() + File.separator + FILE_NAME;
//
//                    File apkFile = new File(mfilePath);
//                    if (apkFile.exists()){
//                        boolean result = apkFile.delete();
//                        if (!result){
//                            return  false;
//                        }
//                    }
//
//                    int downloadSize = 0;
//                    byte[] bytes = new byte[1024];
//                    int lenght;
//
//                    OutputStream outputStream = new FileOutputStream(mfilePath);
//                    while ((lenght = inputStream.read(bytes)) != -1){
//                        outputStream.write(bytes,0,lenght);
//
//                        downloadSize += lenght;
//                        publishProgress(downloadSize * 100/contentlenght);
//                    }
//                    inputStream.close();
//                    outputStream.close();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            int i = 0;
            while (i<101){
                i++;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i);
            }

            return true;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            m_DownloadBtn.setText("download");
            m_ResultViewText.setText("downloading...");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            if (values != null && values.length > 0){
                m_ProgressBar.setProgress(values[0]);
                m_ResultViewText.setText(values[0] + "%");
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            m_DownloadBtn.setText("download success!");
            m_ResultViewText.setText(result.booleanValue()?"download success!":"download failed!!!");
        }
    }
}