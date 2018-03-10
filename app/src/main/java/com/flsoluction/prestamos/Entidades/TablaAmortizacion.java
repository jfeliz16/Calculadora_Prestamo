package com.flsoluction.prestamos.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Eridenia Lora on 3/10/2018.
 */

public class TablaAmortizacion implements Serializable {

    public Prestamo prestamo;
    public List<Cuota> cuotas;
    public double montoCuota;
    public float totalAPagar;
    public float totalInteres;
    public Date fechaUltimoPago;
}
