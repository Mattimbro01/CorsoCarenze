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
public class DatiCondivisi {

    //Costruttore
    public DatiCondivisi(int[] numeriUtente, int[] sequenzaCasuale, int lung, boolean trovato) {
        this.numeriUtente = numeriUtente;
        this.sequenzaCasuale = sequenzaCasuale;
        this.lung = lung;
        this.trovato = trovato;
        s1 = new Semaforo(1);
        s2 = new Semaforo(0);
        s3 = new Semaforo(0);
        pos = 0;
    }

    //Getter
    public int[] getNumeriUtente() {
        return numeriUtente;
    }

    public int[] getSequenzaCasuale() {
        return sequenzaCasuale;
    }

    public int getLung() {
        return lung;
    }

    public int getPos() {
        return pos;
    }

    public boolean isTrovato() {
        return trovato;
    }

    //Setter
    public  void setTrovato(boolean trovato) {
        this.trovato = trovato;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    //Signal
    public void SemSignal(int num){
        if(num==1){
            s1.Signal();
        }
        else if(num==2){
            s2.Signal();
        }
        else if(num==3){
            s3.Signal();
        }
    }
    //Wait
    public void SemWait(int num){
        if(num==1){
            s1.Wait();
        }
        else if(num==2){
            s2.Wait();
        }
        else if(num==3){
            s3.Wait();
        }
    }
    //Dati condivisi
    private int[] numeriUtente;
    private int[] sequenzaCasuale;
    private int lung;
    private int pos;
    private boolean trovato;
    private Semaforo s1;
    private Semaforo s2;
    private Semaforo s3;

}
