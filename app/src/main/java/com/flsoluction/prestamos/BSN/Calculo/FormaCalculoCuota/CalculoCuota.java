package com.flsoluction.prestamos.BSN.Calculo.FormaCalculoCuota;

import com.flsoluction.prestamos.BSN.Calculo.CalculoPrestamo;
import com.flsoluction.prestamos.BSN.Calculo.FormaCalculoDias;
import com.flsoluction.prestamos.Entidades.Prestamo;
import com.flsoluction.prestamos.BSN.Calculo.TipoAmortizacion;
import com.flsoluction.prestamos.BSN.Calculo.TipoPlazo;
import com.flsoluction.prestamos.FlSoftSolution.DateUtility;

import java.util.Date;

/**
 * Created by jfeliz on 2/12/2018.
 */


public class CalculoCuota {

    public com.flsoluction.prestamos.Entidades.Cuota Calcular(Prestamo pre,ParamCalculoCuota paramCalc) throws Exception {
        com.flsoluction.prestamos.Entidades.Cuota entCuota;
        Cuota calCuota;
        int dias;
        CalculoPrestamo calcPrestamo;
        Date fechaProximoCorte;
        calcPrestamo = new CalculoPrestamo();

        calCuota = getInstanciaCuota(pre.getTipoAmortizacion());

        if (paramCalc.getFechaUltimoCorte() == null) {
            paramCalc.setFechaUltimoCorte(pre.getFecha());
        }

        fechaProximoCorte = calcPrestamo.calcularFechaProximoCorte(pre.getFecha(),
                paramCalc.getFechaUltimoCorte(),pre.getTipoPlazo());

        if (pre.getTipoPlazo()== TipoPlazo.MENSUAL ){
            paramCalc.setDias((short)30);

        }else {
            paramCalc.setDias(DateUtility.SubtractToDay(fechaProximoCorte,paramCalc.getFechaUltimoCorte()));;
        }

        entCuota = calCuota.calcular(paramCalc,pre);

        entCuota.setFecha(fechaProximoCorte);

        return entCuota;
    }


    public Cuota getInstanciaCuota(short tipoAmortizacion){

        switch (tipoAmortizacion){

            case TipoAmortizacion.NORMAL :
                return new CuotaNormal();
            default:
                return new CuotaNormal();
        }
    }

}
