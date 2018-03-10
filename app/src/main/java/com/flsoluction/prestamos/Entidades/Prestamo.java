package com.flsoluction.prestamos.Entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jfeliz on 2/12/2018.
 */

public class Prestamo implements Serializable {

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(float tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public float getTasaMora() {
        return tasaMora;
    }

    public void setTasaMora(float tasaMora) {
        this.tasaMora = tasaMora;
    }

    public short getPlazo() {
        return plazo;
    }

    public void setPlazo(short plazo) {
        this.plazo = plazo;
    }

    public short getTipoPlazo() {
        return tipoPlazo;
    }

    public void setTipoPlazo(short tipoPlazo) {
        this.tipoPlazo = tipoPlazo;
    }

    public short getTipoAmortizacion() {
        return tipoAmortizacion;
    }

    public void setTipoAmortizacion(short tipoAmortizacion) {
        this.tipoAmortizacion = tipoAmortizacion;
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

    public short getDiaCorte() {
        return diaCorte;
    }

    public void setDiaCorte(short diaCorte) {
        this.diaCorte = diaCorte;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public short getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(short frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public float getCuotaFija() {
        return cuotaFija;
    }

    public void setCuotaFija(float cuotaFija) {
        this.cuotaFija = cuotaFija;
    }

    public short getCantidadGraciaCuota() {
        return cantidadGraciaCuota;
    }

    public void setCantidadGraciaCuota(short cantidadGraciaCuota) {
        this.cantidadGraciaCuota = cantidadGraciaCuota;
    }

    public short getDiasGraciaMora() {
        return diasGraciaMora;
    }

    public void setDiasGraciaMora(short diasGraciaMora) {
        this.diasGraciaMora = diasGraciaMora;
    }

    public Date getFechaUltimoCorte() {
        return fechaUltimoCorte;
    }

    public void setFechaUltimoCorte(Date fechaUltimoCorte) {
        this.fechaUltimoCorte = fechaUltimoCorte;
    }

    private Date fechaUltimoCorte;

    private int id;
    private String referencia;
    private float monto;
    private float saldo;
    private float tasaInteres;
    private float tasaMora;
    private short plazo;
    private short tipoPlazo;
    private short frecuencia;
    private short tipoAmortizacion;
    private Date fecha;
    private Date fechaVencimiento;
    private short diaCorte;
    private short estado;
    private short cantidadGraciaCuota;
    private short diasGraciaMora;
    private float cuotaFija;

    public short getBaseCalculoDias() {
        return baseCalculoDias;
    }

    public void setBaseCalculoDias(short baseCalculo) {
        this.baseCalculoDias = baseCalculo;
    }

    private short baseCalculoDias;

    public Prestamo() {
    }


}
