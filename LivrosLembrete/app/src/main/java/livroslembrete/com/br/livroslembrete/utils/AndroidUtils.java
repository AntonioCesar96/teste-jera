package livroslembrete.com.br.livroslembrete.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class AndroidUtils {

    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity == null) {
                return false;
            } else {
                NetworkInfo[] info = connectivity.getAllNetworkInfo();
                if (info != null) {
                    for (int i = 0; i < info.length; i++) {
                        if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
                }
            }
        } catch (SecurityException e) {
            alertDialog(context, e.getClass().getSimpleName(), e.getMessage());
        }
        return false;
    }

    public static void alertDialog(final Context context, final int title, final int mensagem) {
        try {
            AlertDialog dialog = new AlertDialog.Builder(context).setTitle(title).setMessage(mensagem).create();
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();
        } catch (Exception e) {
            Log.e("TAG", e.getMessage(), e);
        }
    }

    public static void alertDialog(final Context context, final String title, final String mensagem) {
        try {
            AlertDialog dialog = new AlertDialog.Builder(context).setTitle(
                    title).setMessage(mensagem)
                    .create();
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();
        } catch (Exception e) {
            Log.e("TAG", e.getMessage(), e);
        }
    }
}
