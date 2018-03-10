package com.flsoluction.prestamos.BSN.Calculo.FormaCalculoCuota;

import com.flsoluction.prestamos.Entidades.Prestamo;
import com.flsoluction.prestamos.FlSoftSolution.BankException;

/**
 * Created by jfeliz on 2/12/2018.
 */

public interface Cuota {

    public com.flsoluction.prestamos.Entidades.Cuota calcular(ParamCalculoCuota param,Prestamo pre) throws BankException, Exception;
}
