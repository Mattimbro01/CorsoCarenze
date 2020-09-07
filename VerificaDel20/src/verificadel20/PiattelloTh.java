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
public class PiattelloTh extends Thread {

    public PiattelloTh(DatiCondivisi datiCon, int numeroTh) {
        this.datiCon = datiCon;
        this.numeroTh = numeroTh;
    }

    //il thread 1 simula il piattello 1-2 (lancio e disintegrazione)
    @Override
    public void run() {
        System.out.println("piattello "+numeroTh+" PARTITO");
        datiCon.WaitPiatello(numeroTh);
        System.out.println("piattello "+numeroTh+" DISINTEGRA");
    }
    DatiCondivisi datiCon;
    int numeroTh;
}
