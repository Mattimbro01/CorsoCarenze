/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es1carenzacon;

/**
 *
 * @author Imbrosciano Mattia
 */
public class RicercaTh extends Thread {
     //Costruttore
    public RicercaTh(DatiCondivisi datiCon, int numeroTh) {
        this.datiCon = datiCon;
        this.numeroTh = numeroTh;
    }

    //run
    //facendo utilizzo di thread ricercare un numero nella sequenza e determinare la posizione in cui si trova
    @Override
    public void run() {
        //Dati
        int[] numeriUtente = datiCon.getNumeriUtente();
        int[] sequenzaCasuale = datiCon.getSequenzaCasuale();
        int lung = datiCon.getLung();
        boolean trovato = datiCon.isTrovato();
        int i=0;
        //ricerca
        while (trovato == false && i<lung) {
            datiCon.SemWait(numeroTh);
            if(numeriUtente[numeroTh-1]==sequenzaCasuale[i]){
            //
                trovato=true;
                datiCon.setTrovato(trovato);
                datiCon.setPos(i);
            }
                
            i++;
           datiCon.SemSignal(numeroTh);
        }
 
    }
    //Dati Condivisi
    DatiCondivisi datiCon;
    //Numero Thread
    int numeroTh;
}
