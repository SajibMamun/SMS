package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText phonenumberid,textmessageid;
    String phone,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phonenumberid=findViewById(R.id.edittextcallid);
        textmessageid=findViewById(R.id.smseditid);
    }

    public void sendbuttoonid(View view) {
        phone=phonenumberid.getText().toString().trim();
        message=textmessageid.getText().toString().trim();

        if(phone.isEmpty()||phone.length()>11)
        {
            phonenumberid.setError("Enter a phone number");
        }
        else if(message.isEmpty())
        {
            textmessageid.setError("Type a Text Message");
        }
        else
        {
            //SmsManager smsManager=SmsManager.getDefault();
           // smsManager.sendTextMessage(phone,null,message,null,null);

            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:"+phone));
           intent.putExtra("sms_body",""+message);
            startActivity(intent);

        }
    }
}