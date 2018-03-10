package com.flsoluction.prestamos.BSN.Calculo.FormaCalculoCuota;

import com.flsoluction.prestamos.Entidades.Prestamo;
import com.flsoluction.prestamos.BSN.Calculo.TipoPlazo;
import com.flsoluction.prestamos.FlSoftSolution.BankException;

import java.text.DecimalFormat;

/**
 * Created by jfeliz on 2/12/2018.
 */

public class CuotaNormal implements  Cuota {
    /**
     * Calcula cuota del prestamo
     * @param param Parametros calculo cuota
     * @param pre Entidad prestamo
     * @return Entidad cuota
     */
    @Override
    public com.flsoluction.prestamos.Entidades.Cuota calcular(ParamCalculoCuota param,Prestamo pre) throws Exception {
        com.flsoluction.prestamos.Entidades.Cuota cuota = new com.flsoluction.prestamos.Entidades.Cuota();
        double interes;
        double montoCuota;

        if (pre.getPlazo() == 0){
            throw new BankException(3);
        }

        interes = (param.getsaldoCalculo() *  pre.getTasaInteres() / 100 / param.getBaseDias() ) * param.getDias();

        DecimalFormat newFormat = new DecimalFormat("###,###,###,###.##");
        interes =  Double.parseDouble (newFormat.format(interes).replace(",",""));

        cuota.setMontoInteres(interes);

        montoCuota = calcularMontoCuota(pre);
        montoCuota =  Double.parseDouble (newFormat.format(montoCuota).replace(",",""));

        cuota.setMontoTotal(montoCuota);

        cuota.setMontoCapital(cuota.getMontoTotal() - cuota.getMontoInteres());

        return  cuota;
    }

    /**
     * Calculo monto de cuota fijo
     * @param pre Entidad prestamo
     * @return Monto de cuota fijo
     */
    private double calcularMontoCuota(Prestamo pre){
        double factor;
        double monto;

        factor = calcularFactor(pre);

      //  (context.MontoDesembolsadoGastos * factorI * CType((factorI + 1D) ^ (context.Plazo), Decimal))
      //          / (CType((factorI + 1D) ^ (context.Plazo ), Decimal) - 1D)



        if (factor > 0){
            monto = (pre.getMonto() * factor * (Math.pow ((factor + 1),pre.getPlazo()))) /
                    ((Math.pow ((factor + 1),pre.getPlazo()))-1);
            /*
            monto= (float) (Math.pow(pre.getMonto() * factor * (pre.getMonto() + 1) ,
                    (pre.getPlazo())) / (Math.pow( (factor + 1) ,
                    (pre.getPlazo() )) - 1D));
                    */
        }else{
            monto=  pre.getMonto() / pre.getPlazo();
        }

        return monto;
    }

    /**
     * Calcula el factor para busca monto cuota
      * @param pre Entidad prestamo
     * @return factor
     */
    private double calcularFactor(Prestamo pre){
        double factor = 0;
        float tasa;

        tasa = pre.getTasaInteres() / 100;

        if (pre.getTipoPlazo() == TipoPlazo.DIARIO){
            factor = tasa * pre.getFrecuencia() / pre.getBaseCalculoDias();
        }
        if (pre.getTipoPlazo() == TipoPlazo.MENSUAL){
            factor = tasa * pre.getFrecuencia() / 12;
        }

        return factor;
    }


}
