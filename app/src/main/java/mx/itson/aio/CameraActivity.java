package mx.itson.aio;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        (findViewById(R.id.btnCamara)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCamara) {
            Intent camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            try {
                //Obtienes el package manager de la activity actual
                PackageManager packageManager = this.getPackageManager();
                //Para ejecutar la camara dentro del activity actual
                final ResolveInfo resolveInfo = packageManager.resolveActivity(camera, 0);
                //Creas el intent
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                //El intent tendra un action main
                intent.setAction(Intent.ACTION_MAIN);
                //Lo pones como un launcher para ejecutarlo dentro de la activity actual
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(intent);
            } catch (Exception e) {

            }
        }
    }
}
