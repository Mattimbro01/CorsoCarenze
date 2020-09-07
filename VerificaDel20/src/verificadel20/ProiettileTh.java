/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificadel20;

/**
 *
 * @author Imbrosciano Mattia
 */
public class ProiettileTh extends Thread {

    public ProiettileTh(DatiCondivisi datiCon, int numeroTh) {
        this.datiCon = datiCon;
        this.numeroTh = numeroTh;
    }

    @Override
    public void run() {
        System.out.println("proiettile " + numeroTh + " PARTITO");
           try {
            Thread.sleep((long)((Math.random() *2+1)*1000));
        } catch (InterruptedException ignored) { }
        datiCon.SignalProiettile();
        System.out.println("proiettile " + numeroTh + " COLPISCE");
        datiCon.SignalPiatello(numeroTh);
        datiCon.SignalProiettile();
    }
    DatiCondivisi datiCon;
    int numeroTh;
}
