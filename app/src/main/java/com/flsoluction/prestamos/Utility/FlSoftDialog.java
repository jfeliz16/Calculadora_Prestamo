package com.flsoluction.prestamos.Utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Eridenia Lora on 3/10/2018.
 */

public class FlSoftDialog {

    public static void showOk(Context context, String mensaje){
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle("Mensaje")
                .setMessage(mensaje)
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .create();
        alertDialog.show();
    }
}
