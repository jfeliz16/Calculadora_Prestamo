package com.flsoluction.prestamos.BSN.Calculo;

import com.flsoluction.prestamos.BSN.Calculo.FormaCalculoCuota.CalculoCuota;
import com.flsoluction.prestamos.BSN.Calculo.FormaCalculoCuota.ParamCalculoCuota;
import com.flsoluction.prestamos.Entidades.Cuota;
import com.flsoluction.prestamos.Entidades.TablaAmortizacion;
import com.flsoluction.prestamos.FlSoftSolution.BankException;
import com.flsoluction.prestamos.Entidades.Prestamo;
import com.flsoluction.prestamos.FlSoftSolution.DateUtility;
import com.flsoluction.prestamos.FlSoftSolution.FlSoluctionException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jfeliz on 2/12/2018.
 */

public class CalculoPrestamo {

    /**
     * Genera tabla amortizacion de prestamo
     * @param pre Entidad prestamo
     * @return Lista de cuotas
     * @throws Exception
     */
    public TablaAmortizacion generarTablaAmortizacion(Prestamo pre) throws Exception {
        TablaAmortizacion tablaAmortizacion;
        List<Cuota> cuotas = new ArrayList<>();
        ParamCalculoCuota paramCalcCuota;
        CalculoCuota calculoCuota;
        Cuota cuota;
        Date fechaUltimoCorte = null;
        double saldo;

        //Validar monto prestamo
        if (pre.getMonto() == 0){
                throw new BankException(2);
        }

        //Validar fecha prestamo
        if (pre.getFecha() == null){
            throw new BankException(1);
        }

        paramCalcCuota = new ParamCalculoCuota();
        calculoCuota = new CalculoCuota();

        saldo = pre.getMonto();
        paramCalcCuota.setBaseDias(pre.getBaseCalculoDias());

        paramCalcCuota.setFechaUltimoCorte(pre.getFecha());

        tablaAmortizacion = new TablaAmortizacion();

        tablaAmortizacion.prestamo = pre;

        for (short i=1;i <= pre.getPlazo(); i++) {

            paramCalcCuota.setFechaUltimoCorte(fechaUltimoCorte);
            paramCalcCuota.setsaldoCalculo(saldo);

            cuota =  calculoCuota.Calcular(pre,paramCalcCuota);

            cuota.setSaldoPrestamo(saldo);
            saldo = saldo - cuota.getMontoCapital();
            cuota.setNumero(i);
            fechaUltimoCorte = cuota.getFecha();

            tablaAmortizacion.totalAPagar += cuota.getMontoTotal();
            tablaAmortizacion.totalInteres += cuota.getMontoInteres();
            if (tablaAmortizacion.montoCuota ==0)tablaAmortizacion.montoCuota = cuota.getMontoTotal();

            if (i== pre.getPlazo()) tablaAmortizacion.fechaUltimoPago = cuota.getFecha();

            cuotas.add(cuota);
        }

        tablaAmortizacion.cuotas = cuotas;

        return tablaAmortizacion;
    }

    /**
     * Calcula la fecha de proximo corte del prestamo
     * @param fecha Fecha prestamo
     * @param fechaUltimoCorte Fecha ultimo corte
     * @param tipoPlazo Tipo plazo prestamo
     * @return Fecha de proximo corte
     * @throws BankException
     */
    public Date calcularFechaProximoCorte(Date fecha,Date fechaUltimoCorte,short tipoPlazo ) throws BankException {
        Date fechaProximoCorte;

        if (fechaUltimoCorte == null){

            if (fecha == null){
                throw new BankException(1);
            }
            fechaUltimoCorte = fecha;
        }

        if (tipoPlazo== TipoPlazo.MENSUAL){

            fechaProximoCorte = DateUtility.addMonth(fechaUltimoCorte,1);
        }else {
            fechaProximoCorte=  DateUtility.addDays(fechaUltimoCorte,7);
        }

        return fechaProximoCorte;
    }
}
