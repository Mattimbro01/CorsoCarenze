/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2_frequenze;

import java.util.ArrayList;

/**
 *
 * @author Imbrosciano Mattia
 */
public class RicercaTh extends Thread {

    //Dati Condivisi
    DatiCondivisi datiCon;
    //Numero Thread
    int numeroTh;

    //Costruttore
    public RicercaTh(DatiCondivisi datiCon, int numeroTh) {
        this.datiCon = datiCon;
        this.numeroTh = numeroTh;
    }

    //facendo utilizzo di thread ricercare se la linea permette di arrivare a destinazione 
    //e in caso positivo l'elenco di tutti gli orari di partenza e di arrivo
    @Override
    public void run() {
        //Dati
        Ora Oraesclusa=new Ora(-1);
        String ComunePartenza = datiCon.getComunePartenza();
        String ComuneArrivo = datiCon.getComuneArrivo();
        ArrayList<Ora[]> elencoCorse = datiCon.getElencoCorse();
        Ora[] Corsa = elencoCorse.get(numeroTh);
        int indexComunePartenza = Controllo(ComunePartenza);
        int indexComuneArrivo = Controllo(ComuneArrivo);
        //facendo utilizzo di thread ricercare se la linea permette di arrivare a destinazione 
        if (indexComunePartenza != -1 && indexComuneArrivo != -1) {
            if (indexComunePartenza < indexComuneArrivo) {
                if (Corsa[indexComunePartenza].getHh()!=-1 && Corsa[indexComuneArrivo].getHh()!=-1) {
                        //in caso positivo l'elenco di tutti gli orari di partenza e di arrivo
                        String OraPartArr = "Ora Partenza:" + Corsa[indexComunePartenza].toString() + " Arrivo:" + Corsa[indexComuneArrivo].toString();
                        datiCon.push(OraPartArr);
                }
            }
        }
    }

    private int Controllo(String trovare) {
        int index = -1;
        int i = 0;
        String[] fermateBus = datiCon.getFermateBus();

        while (i < fermateBus.length && index == -1) {
            if (fermateBus[i].equals(trovare)) {
                index = i;
            }
            i++;
        }
        return index;
    }
}
