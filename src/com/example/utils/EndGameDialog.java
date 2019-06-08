package com.example.utils;

import com.example.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGameDialog extends Dialog implements android.view.View.OnClickListener{
	 
    private Button yes;//ȷ����ť
    private Button no;//ȡ����ť
    private TextView titleTv;//��Ϣ�����ı�
    private TextView messageTv;//��Ϣ��ʾ�ı�
    private String titleStr;//��������õ�title�ı�
    private String messageStr;//��������õ���Ϣ�ı�
    //ȷ���ı���ȡ���ı�����ʾ����
    private String yesStr, noStr;
 
    private EndGameListener mSListener; 
 
    public void setEndGameListener(EndGameListener mSListener) {
        this.mSListener = mSListener;
    }
 
    public EndGameDialog(Context context) {
        super(context, R.style.EndGameDialog);
    }
    
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
        case R.id.yes:
        	mSListener.onEndDialog(true);
        	dismiss();
            break;
        case R.id.no:
        	mSListener.onEndDialog(false);
        	dismiss();
            break;
 
        default:
            break;
        }
    }
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame_layout);
        //���հ״�����ȡ������
        setCanceledOnTouchOutside(false);
 
        //��ʼ������ؼ�
        initView();
        //��ʼ����������
        initData();
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
    }
 
   
 
    /**
     * ��ʼ������ؼ�����ʾ����
     */
    private void initData() {
        //����û��Զ���title��message
        if (titleStr != null) {
            titleTv.setText(titleStr);
        }
        if (messageStr != null) {
            messageTv.setText(messageStr);
        }
        yes.setText("ȷ��");
        no.setText("ȡ��");
    }
 
    /**
     * ��ʼ������ؼ�
     */
    private void initView() {
        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);
        titleTv = (TextView) findViewById(R.id.title);
        messageTv = (TextView) findViewById(R.id.message);
    }
 
    /**
     * �����ActivityΪDialog���ñ���
     *
     * @param title
     */
    public void setTitle(String title) {
        titleStr = title;
    }
 
    /**
     * �����ActivityΪDialog����dialog��message
     *
     * @param message
     */
    public void setMessage(String message) {
        messageStr = message;
    }
}