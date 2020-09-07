/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2_frequenze;

/**
 *
 * @author imbrosciano_mattia
 */
public class Ora {

    public Ora(int hh, int mm) {
        this.hh = hh;
        this.mm = mm;
    }

    public Ora(int hh) {
        this.hh = hh;
        mm = 0;
    }

    public Ora() {
        hh = 0;
        mm = 0;
    }

    @Override
    public String toString() {
        return AggiungiZero(hh) + ":" + AggiungiZero(mm);
    }

    public Ora ConvertiInOra(String s) {
        int indexDuepunti = s.indexOf(s);
        if (s.indexOf(":") != -1) {
            String[] OraMin = s.split(":");
            int h = Integer.parseInt(OraMin[0]);
            int m = Integer.parseInt(OraMin[1]);
            return new Ora(h, m);
        } else {
            return new Ora(Integer.parseInt(s));
        }
    }
    public String AggiungiZero(int numero){
        String s="";
        if(numero>9)
            s+=numero;
        else
            s+="0"+numero;
        return s;
        
    }

    public int getHh() {
        return hh;
    }

    public int getMm() {
        return mm;
    }

    private int hh;
    private int mm;

}
