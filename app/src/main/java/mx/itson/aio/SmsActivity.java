package mx.itson.aio;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SmsActivity  extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        (findViewById(R.id.btnSendSMS)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSendSMS) {
            String phonenumber = ((TextView)findViewById(R.id.txtNumber)).getText().toString();
            if(!phonenumber.isEmpty()&&phonenumber.length()==10){
                String message = ((TextView)findViewById(R.id.txtMessage)).getText().toString();
                if(!message.isEmpty()){
                    Uri uri = Uri.parse("smsto:"+phonenumber);
                    Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                    intent.putExtra("sms_body", message);
                    startActivity(intent);
                    ((TextView) findViewById(R.id.txtMessage)).setText("");
                    ((TextView) findViewById(R.id.txtNumber)).setText("");
                }else{
                    Toast.makeText(this,"Inserte un mensaje",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this,"Inserte un numero valido",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
