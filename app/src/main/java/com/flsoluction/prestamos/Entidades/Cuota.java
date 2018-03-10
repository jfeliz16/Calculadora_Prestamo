package com.flsoluction.prestamos.Entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jfeliz on 2/12/2018.
 */

public class Cuota implements Serializable {

    private  int id;
    private  int idPrestamo;
    private  short numero;
    private  double MontoCapital;

    public double getMontoInteres() {
        return MontoInteres;
    }

    public void setMontoInteres(double montoInteres) {
        MontoInteres = montoInteres;
    }

    private  double MontoInteres;
    private  float MontoMora;
    private  float MontoCargos;
    private  float SaldoMora;
    private  float SaldoInteres;
    private  float SaldoCapital;
    private  float SaldoCargos;
    private  double SaldoPrestamo;
    private Date fecha;
    private Date fechaVencimiento;

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    private double montoTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public double getMontoCapital() {
        return MontoCapital;
    }

    public void setMontoCapital(double montoCapital) {
        MontoCapital = montoCapital;
    }

    public float getMontoMora() {
        return MontoMora;
    }

    public void setMontoMora(float montoMora) {
        MontoMora = montoMora;
    }

    public float getMontoCargos() {
        return MontoCargos;
    }

    public void setMontoCargos(float montoCargos) {
        MontoCargos = montoCargos;
    }

    public float getSaldoMora() {
        return SaldoMora;
    }

    public void setSaldoMora(float saldoMora) {
        SaldoMora = saldoMora;
    }

    public float getSaldoInteres() {
        return SaldoInteres;
    }

    public void setSaldoInteres(float saldoInteres) {
        SaldoInteres = saldoInteres;
    }

    public float getSaldoCapital() {
        return SaldoCapital;
    }

    public void setSaldoCapital(float saldoCapital) {
        SaldoCapital = saldoCapital;
    }

    public float getSaldoCargos() {
        return SaldoCargos;
    }

    public void setSaldoCargos(float saldoCargos) {
        SaldoCargos = saldoCargos;
    }

    public double getSaldoPrestamo() {
        return SaldoPrestamo;
    }

    public void setSaldoPrestamo(double saldoPrestamo) {
        SaldoPrestamo = saldoPrestamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }



}
