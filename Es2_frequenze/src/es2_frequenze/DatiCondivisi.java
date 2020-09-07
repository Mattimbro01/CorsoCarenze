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
public class DatiCondivisi {

    //Getter
    public String getComunePartenza() {
        return ComunePartenza;
    }

    public String getComuneArrivo() {
        return ComuneArrivo;
    }

    public String[] getFermateBus() {
        return fermateBus;
    }

    public ArrayList<Ora[]> getElencoCorse() {
        return elencoCorse;
    }

    public int getCountCorseTrovate() {
        return countCorseTrovate;
    }

    public String[] getOrePartArrivo() {
        return OrePartArrivo;
    }

    public int getNumEl() {
        return numEl;
    }

    //Mettodo per incrementare il contatore dei corsi trovati
    public void incCountCorseTrovate() {
        countCorseTrovate++;
    }

    public synchronized void push(String s) {
        if (numEl < OrePartArrivo.length) {
            OrePartArrivo[numEl] = s;
            numEl++;
        }
        incCountCorseTrovate();
    }

    //reset array 
    private void ResetArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = "";
        }
    }

    //Costruttore
    public DatiCondivisi(String ComunePartenza, String ComuneArrivo, String[] fermateBus, ArrayList<Ora[]> elencoCorse) {
        this.ComunePartenza = ComunePartenza;
        this.ComuneArrivo = ComuneArrivo;
        this.fermateBus = fermateBus;
        this.elencoCorse = elencoCorse;
        countCorseTrovate = 0;
        OrePartArrivo = new String[fermateBus.length * 5];
        ResetArray(OrePartArrivo);
        numEl = 0;

    }
    //Dati
    private String ComunePartenza;
    private String ComuneArrivo;
    private String[] fermateBus;
    private ArrayList<Ora[]> elencoCorse;

    private int countCorseTrovate;
    private String[] OrePartArrivo;

    private int numEl;

}
