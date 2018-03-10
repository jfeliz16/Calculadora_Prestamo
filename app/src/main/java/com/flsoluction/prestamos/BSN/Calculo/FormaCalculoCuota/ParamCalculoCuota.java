package com.flsoluction.prestamos.BSN.Calculo.FormaCalculoCuota;

import java.util.Date;

/**
 * Created by jfeliz on 2/13/2018.
 */

public class ParamCalculoCuota {

    private double saldoCalculo;

    public double getsaldoCalculo() {
        return saldoCalculo;
    }

    public void setsaldoCalculo(double saldoCalculo) {
        this.saldoCalculo = saldoCalculo;
    }

    public float getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(float tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public short getBaseDias() {
        return baseDias;
    }

    public void setBaseDias(short baseDias) {
        this.baseDias = baseDias;
    }

    private float tasaInteres;
    private int dias;
    private short baseDias;

    public Date getFechaUltimoCorte() {
        return fechaUltimoCorte;
    }

    public void setFechaUltimoCorte(Date fechaUltimoCorte) {
        this.fechaUltimoCorte = fechaUltimoCorte;
    }

    private Date fechaUltimoCorte;
    }
