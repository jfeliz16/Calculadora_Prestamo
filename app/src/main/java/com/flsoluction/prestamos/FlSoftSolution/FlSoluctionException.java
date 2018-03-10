package com.flsoluction.prestamos.FlSoftSolution;

import java.util.ArrayList;

/**
 * Created by jfeliz on 2/14/2018.
 */

public class FlSoluctionException extends Exception {

    public FlSoluctionException(int codigo){
        super();
        setCodigo(codigo);
    }

    public FlSoluctionException(int codigo, String ...values){
        super();
        this.codigo = codigo;
        this.values = new ArrayList<String>();

        for(String i:values){
            this.values.add(i);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    protected int codigo;

    public ArrayList<String> getValues() {
        return values;
    }

    public void setValues(ArrayList<String> values) {
        this.values = values;
    }

    protected ArrayList<String> values;

}
