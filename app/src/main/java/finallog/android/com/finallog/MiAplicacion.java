package finallog.android.com.finallog;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Josue on 05/07/2016.
 */
public class MiAplicacion extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        mostrarHashKey(); //10
    }

    //7
    public void mostrarHashKey(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "finallog.android.com.finallog",     /*8*/
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
    /*9*/       Log.d("MiHashKey", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
}
