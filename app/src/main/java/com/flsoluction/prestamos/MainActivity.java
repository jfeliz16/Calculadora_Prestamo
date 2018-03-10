package com.flsoluction.prestamos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Binder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.flsoluction.prestamos.BSN.Calculo.CalculoPrestamo;
import com.flsoluction.prestamos.BSN.Calculo.FormaCalculoDias;
import com.flsoluction.prestamos.Entidades.Cuota;
import com.flsoluction.prestamos.Entidades.Prestamo;
import com.flsoluction.prestamos.Entidades.TablaAmortizacion;
import com.flsoluction.prestamos.Entidades.TipoPlazo;
import com.flsoluction.prestamos.FlSoftSolution.BankException;
import com.flsoluction.prestamos.FlSoftSolution.DateUtility;
import com.flsoluction.prestamos.Utility.FlSoftDialog;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener,TextWatcher {

    EditText mFechainicial;
    EditText mEditTextInteres;

    public final static String CUOTAS="CUOTAS";
    public final static String PRESTAMO="PRESTAMO";
    public final static String MONTO_CUOTA="MONTO_CUOTA";
    public final static String FECHA_ULT_PAGO="FECHA_ULT_PAGO";
    public final static String TOTAL_INTERES="TOTAL_INTERES";
    public final static String TOTAL_A_PAGAR="TOTAL_A_PAGAR";
    private Date mCurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mCurrentDate = DateUtility.getCurrentDate();

            mFechaIni = mCurrentDate;

            findViewById(R.id.buttonCalcular).setOnClickListener(this);

            mFechainicial =findViewById(R.id.editTextFechaInicial);
            mFechainicial.setOnClickListener(this);

            mFechainicial.setText(DateUtility.format(mCurrentDate,"dd MMM yyyy"));

            mEditTextInteres =  findViewById(R.id.editTextTasaInteres);

            mEditTextInteres.addTextChangedListener(this);


        }catch (Exception ex){
            FlSoftDialog.showOk(this,ex.getMessage());
        }
    }

    @Override
    public void onClick(View view) {
       try{
           switch (view.getId()){

               case R.id.buttonCalcular:
                   calcular();
                   break;
               case R.id.editTextFechaInicial:
                   Calendar c = Calendar.getInstance();
                   c.setTime(mCurrentDate);

                   DatePickerDialog datePickerDialog =
                           new DatePickerDialog(
                                   this,
                                   this,
                                   c.get(Calendar.YEAR),
                                   c.get(Calendar.MONTH),
                                   c.get(Calendar.DAY_OF_MONTH));
                   datePickerDialog.show();

                   break;
           }
       }catch (Exception ex){
           FlSoftDialog.showOk(this,ex.getMessage());
       }
    }

    private  void calcular() throws Exception {
        Prestamo pre = new Prestamo();
        CalculoPrestamo calculoPrestamo = new CalculoPrestamo();
        TablaAmortizacion tablaAmort;

        EditText editText =  findViewById(R.id.editTextMontoAprobado);

        if (editText.getText().toString().isEmpty() || Double.parseDouble(editText.getText().toString()) ==0 ){
            FlSoftDialog.showOk(this,"Monto Préstamo debe ser mayor que 0");

            //getResources().getIdentifier("msg_2",
            //        "bankMsgs", getPackageName());
            return;
        }
        pre.setMonto((Float.parseFloat(editText.getText().toString())));

        editText =  findViewById(R.id.editTextPlazo);

        if (editText.getText().toString().isEmpty() || Double.parseDouble(editText.getText().toString()) ==0){
            FlSoftDialog.showOk(this,"Plazo debe ser mayor que 0");
            return;
        }
        pre.setPlazo((Short.parseShort(editText.getText().toString())));

        if (!mEditTextInteres.getText().toString().isEmpty()){
            pre.setTasaInteres((Float.parseFloat(mEditTextInteres.getText().toString())));
        }

        pre.setFecha(mFechaIni);
        pre.setBaseCalculoDias((short)360);
        pre.setTipoPlazo(TipoPlazo.MENSUAL);
        pre.setFrecuencia((short)1);

        tablaAmort = calculoPrestamo.generarTablaAmortizacion(pre);

        Intent intent = new Intent(this,ConsultaPrestamoActivity.class);

        intent.putExtra(CUOTAS,(Serializable) tablaAmort.cuotas);
        intent.putExtra(PRESTAMO,pre);
        intent.putExtra(TOTAL_INTERES, tablaAmort.totalInteres);
        intent.putExtra(TOTAL_A_PAGAR, tablaAmort.totalAPagar);
        intent.putExtra(FECHA_ULT_PAGO, tablaAmort.fechaUltimoPago);
        intent.putExtra(MONTO_CUOTA, tablaAmort.montoCuota);

        startActivity(intent);

    }

    private Date mFechaIni;
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);

        mFechaIni = cal.getTime();

        mFechainicial.setText(DateUtility.format(mFechaIni,"dd MMM yyyy"));
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (!mEditTextInteres.getText().toString().isEmpty()){
            TextView editTextIntMen = findViewById(R.id.textViewIntMensualV);
            DecimalFormat formater = new DecimalFormat("###,###,###.00");

            editTextIntMen.setText(formater.format((Float.parseFloat(mEditTextInteres.getText().toString()) / 12)));
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}


