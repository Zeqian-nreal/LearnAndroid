package com.aze.space.android.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;


public class HandlerActivity extends Activity {
    private static final String TAG = "HandlerActivity";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        m_HandlerThread = new HandlerThread("HandlerActivityThread");
        m_HandlerThread.start();

        m_HandlerThreadHandler = new Handler(m_HandlerThread.getLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.i(TAG, "HandlerThread handleMessage: " + Thread.currentThread().getId());
                    ;
                    Message uimsg = new Message();
                    uimsg.what = 1;
                    m_Handler.sendMessage(uimsg);
                }
                return false;
            }
        });

        {
            Message uimsg = new Message();
            uimsg.what = 1;
            m_Handler.sendMessage(uimsg);
        }
    }

    private HandlerThread m_HandlerThread;
    private Handler m_HandlerThreadHandler;

    private Handler m_Handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                Log.i(TAG, "UIThread handleMessage: " + Thread.currentThread().getId());

                Message newmsg = new Message();
                newmsg.what = 2;
                m_HandlerThreadHandler.sendMessage(newmsg);
            }
        }
    };
}
