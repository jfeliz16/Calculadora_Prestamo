package com.flsoluction.prestamos.FlSoftSolution;

import java.util.ArrayList;

/**
 * Created by jfeliz on 2/14/2018.
 */

public class BankException extends FlSoluctionException {

    public  BankException(int codigo){
        super(codigo);
        setCodigo(codigo);
    }

    public  BankException(int codigo,String ...values){
        super(codigo,values);
        this.codigo = codigo;
        this.values = new ArrayList<String>();

        for(String i:values){
            this.values.add(i);
        }
    }
}
