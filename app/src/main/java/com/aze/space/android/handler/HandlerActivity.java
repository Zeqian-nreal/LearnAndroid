package com.aze.space.android.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.aze.learnandroid.R;

import java.lang.ref.WeakReference;


public class HandlerActivity extends Activity {
    private static final String TAG = "HandlerActivity";
    public Button sendMsgBtn;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate......");
        setContentView(R.layout.handler_activity);

        sendMsgBtn = (Button) findViewById(R.id.delayMsg);
        textView = (TextView) findViewById(R.id.handlerMsg);

//        final WeakRefHandler handler = new WeakRefHandler(this);
        sendMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Thread(new Runnable() {
//                      public void run() {
//                        Message msg = Message.obtain();
//                        msg.what = 100;
//                        m_MsgHandler.sendMessageDelayed(msg, 3000);
//                    }
//                }).start();
                Message msg = Message.obtain();
                msg.what = 100;
                m_MsgHandler.sendMessageDelayed(msg, 3000);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart.....");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause......");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop......");
    }

    private HandlerThread m_HandlerThread;
    private Handler m_HandlerThreadHandler;

    private void Init() {
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

    private Handler m_MsgHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                Log.i(TAG, "UIThread handleMessage: " + Thread.currentThread().getId() + " msgid:" + msg.what);
                Log.i(TAG, "handleMessage: Activity is null?" + (this == null));
                textView.setText("HelloWorld");
            }
        }
    };

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

    private static class WeakRefHandler extends Handler {
        final WeakReference<HandlerActivity> mWeadkReference;

        private WeakRefHandler(HandlerActivity mWeadkReference) {
            this.mWeadkReference = new WeakReference<>(mWeadkReference);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                Log.i(TAG, "UIThread handleMessage: " + Thread.currentThread().getId() + " msgid:" + msg.what);
                Log.i(TAG, "handleMessage: Activity is null?" + (this == null));
                this.mWeadkReference.get().textView.setText("HelloWorld");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy.......");
    }
}
