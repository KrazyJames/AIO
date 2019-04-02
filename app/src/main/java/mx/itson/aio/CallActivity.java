package mx.itson.aio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        Button btnLlamar = (findViewById(R.id.btnLlamar));
        findViewById(R.id.btnBackspace).setOnClickListener(this);
        btnLlamar.setOnClickListener(this);
        for (int i = 0; i < 10; i++) {
            String numero = "btn"+i;
            Button btn = (findViewById(getResources().getIdentifier(numero,"id",this.getPackageName())));
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        String numero = ((TextView) findViewById(R.id.txtNumero)).getText().toString();
        switch (v.getId()){
            case R.id.btnLlamar:
                if (!numero.isEmpty() && numero.length() == 10) {
                    Intent dial = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", numero, null));
                    startActivity(dial);
                    ((TextView) findViewById(R.id.txtNumero)).setText("");
                } else {
                    Toast.makeText(this, "Inserte un numero de 10 digitos", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn0:
                numero += 0;
                ((TextView) findViewById(R.id.txtNumero)).setText(numero);
                break;
            case R.id.btn1:
                numero += 1;
                ((TextView) findViewById(R.id.txtNumero)).setText(numero);
                break;
            case R.id.btn2:
                numero += 2;
                ((TextView) findViewById(R.id.txtNumero)).setText(numero);
                break;
            case R.id.btn3:
                numero += 3;
                ((TextView) findViewById(R.id.txtNumero)).setText(numero);
                break;
            case R.id.btn4:
                numero += 4;
                ((TextView) findViewById(R.id.txtNumero)).setText(numero);
                break;
            case R.id.btn5:
                numero += 5;
                ((TextView) findViewById(R.id.txtNumero)).setText(numero);
                break;
            case R.id.btn6:
                numero += 6;
                ((TextView) findViewById(R.id.txtNumero)).setText(numero);
                break;
            case R.id.btn7:
                numero += 7;
                ((TextView) findViewById(R.id.txtNumero)).setText(numero);
                break;
            case R.id.btn8:
                numero += 8;
                ((TextView) findViewById(R.id.txtNumero)).setText(numero);
                break;
            case R.id.btn9:
                numero += 9;
                ((TextView) findViewById(R.id.txtNumero)).setText(numero);
                break;
            case R.id.btnBackspace:
                if(!numero.isEmpty()){
                    numero = numero.substring(0,numero.length()-1);
                    ((TextView) findViewById(R.id.txtNumero)).setText(numero);
                }
                break;
            default:
                Toast.makeText(this,"Algo salió mal :(",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}


