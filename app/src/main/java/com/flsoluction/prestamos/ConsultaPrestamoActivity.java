package com.flsoluction.prestamos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.flsoluction.prestamos.Entidades.Cuota;
import com.flsoluction.prestamos.Entidades.Prestamo;
import com.flsoluction.prestamos.Entidades.TablaAmortizacion;
import com.flsoluction.prestamos.FlSoftSolution.DateUtility;
import com.flsoluction.prestamos.Utility.FlSoftDialog;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

public class ConsultaPrestamoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_consulta_prestamo);

            DecimalFormat formater = new DecimalFormat("###,###,###.00");

            Prestamo pre =(Prestamo) getIntent().getSerializableExtra(MainActivity.PRESTAMO);
            double montoCuota =(double) getIntent().getSerializableExtra(MainActivity.MONTO_CUOTA);
            Float totalInteres =(float) getIntent().getSerializableExtra(MainActivity.TOTAL_INTERES);
            Float totalAPagar =(float) getIntent().getSerializableExtra(MainActivity.TOTAL_A_PAGAR);
            Date fechaUltiPAgo =(Date) getIntent().getSerializableExtra(MainActivity.FECHA_ULT_PAGO);
            List<Cuota> cuotas=(List<Cuota>) getIntent().getSerializableExtra(MainActivity.CUOTAS);

            TextView textView = findViewById(R.id.textViewMontoPrestamoValor);
            textView.setText(formater.format( pre.getMonto()));

            textView = findViewById(R.id.textViewIntAnualValor);
            textView.setText(formater.format( pre.getTasaInteres()));

            textView = findViewById(R.id.textViewIntMenValor);
            textView.setText(formater.format( pre.getTasaInteres() /12));

            textView = findViewById(R.id.textViewPlazoValor);
            textView.setText(Short.toString( pre.getPlazo()));

            textView = findViewById(R.id.textViewFechaValor);
            textView.setText(DateUtility.format(pre.getFecha(),"dd MMM yyyy"));

            textView = findViewById(R.id.textViewMontoCuotaValor);
            textView.setText(formater.format(montoCuota));

            textView = findViewById(R.id.textViewTotalInteresValor);
            textView.setText(formater.format(totalInteres));

            textView = findViewById(R.id.textViewTotalPagarValor);
            textView.setText(formater.format(totalAPagar));

            textView = findViewById(R.id.textViewFechaUltCuotaValor);
            textView.setText(DateUtility.format(fechaUltiPAgo,"dd MMM yyyy"));

            TableLayout tableAmor = findViewById(R.id.tableLayoutTablaAmort);

            fillRow(tableAmor,cuotas,formater);

        }catch (Exception ex){
            FlSoftDialog.showOk(this,ex.getMessage());
        }
    }

    public void fillRow(TableLayout table,List<Cuota> cuotas,DecimalFormat formater){
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TextView col;
        View row;

        for (Cuota cuo : cuotas){
            row = inflater.inflate(R.layout.row_amortizacion, null);

            col  = (TextView) row.findViewById(R.id.numeroCuota);
            col.setText(Integer.toString(cuo.getNumero()));

            col  = (TextView) row.findViewById(R.id.fechaCuota);
            col.setText(DateUtility.format( cuo.getFecha(),"MMM yyyy"));

            col  = (TextView) row.findViewById(R.id.saldoCuota);
            col.setText( formater.format(cuo.getSaldoPrestamo()));

            col  = (TextView) row.findViewById(R.id.capitalCuota);
            col.setText(formater.format(cuo.getMontoCapital()));

            col  = (TextView) row.findViewById(R.id.interesCuota);
            col.setText(formater.format(cuo.getMontoInteres()));

            col  = (TextView) row.findViewById(R.id.montoCuota);
            col.setText(formater.format(cuo.getMontoTotal()));

            table.addView(row);
        }
    }
}
