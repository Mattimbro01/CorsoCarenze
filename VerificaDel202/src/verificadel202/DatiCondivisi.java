/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificadel202;

import java.util.ArrayList;

/**
 *
 * @author Imbrosciano Mattia
 */
public class DatiCondivisi {

    public DatiCondivisi(String[] google, String[] cache) {
        elencoBuffer = new ArrayList<String[]>();
        elencoBuffer.add(google);
        elencoBuffer.add(cache);
        STR = "";
        VETT = new String[google.length + cache.length];
        numElVETT = 0;
        Ricevere = new Semaforo(1);
        lettura1 = new Semaforo(0);
        lettura2 = new Semaforo(0);
        Visualizza = new Semaforo(0);
        start = true;

    }

    public ArrayList<String[]> getElencoBuffer() {
        return elencoBuffer;
    }

    public String getSTR() {
        return STR;
    }

    public String[] getVETT() {
        return VETT;
    }

    public int getNumElVETT() {
        return numElVETT;
    }

    public String[] getBuffer(int i) {
        return elencoBuffer.get(i);
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
        lettura1.Signal();
        lettura2.Signal();
        Visualizza.Signal();

    }

    public void SetSTR(String lettera) {
        STR += lettera;
    }

    public synchronized void pushVett(String newEntry) {
        if (numElVETT < VETT.length) {
            VETT[numElVETT] = newEntry;
            numElVETT++;
        }
    }

    public void ResetVETT() {
        numElVETT = 0;

    }

    public void SignalLettura() {
        lettura1.Signal();
        lettura2.Signal();
    }
    int i = 0;

    public synchronized void SignalVisualizza() {
        i++;
        if (i == 2) {
            Visualizza.Signal();
            i = 0;
        }
    }

    public void SignalRicevere() {
        Ricevere.Signal();
    }

    public void WaitLettura(int i) {
        if (i == 1) {
            lettura1.Wait();
        } else {
            lettura2.Wait();
        }
    }

    public void WaitRicevere() {
        Ricevere.Wait();
    }

    public void WaitVisualizza() {
        Visualizza.Wait();
    }
    private ArrayList<String[]> elencoBuffer;
    private String STR;
    private String[] VETT;
    private int numElVETT;
    private Semaforo Ricevere;
    private Semaforo lettura1;
    private Semaforo lettura2;
    private Semaforo Visualizza;

    private boolean start;

}
