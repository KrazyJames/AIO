package mx.itson.aio;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        (findViewById(R.id.btnLlamada)).setOnClickListener(this);
        (findViewById(R.id.btnCamara)).setOnClickListener(this);
        (findViewById(R.id.btnMensaje)).setOnClickListener(this);

    }

    @Override
    public void onClick(final View v) {
        if (v.getId() == R.id.btnLlamada) {
            Intent llamada = new Intent(getApplicationContext(), CallActivity.class);
            startActivity(llamada);
        }
        if (v.getId() == R.id.btnMensaje) {
            Intent sms = new Intent(getApplicationContext(), SmsActivity.class);
            startActivity(sms);
        }
        if (v.getId() == R.id.btnCamara) {
            Intent camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            try {
                PackageManager packageManager = this.getPackageManager();
                final ResolveInfo resolveInfo = packageManager.resolveActivity(camera, 0);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(this,"Algo salió mal al lanzar la camara :(", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

