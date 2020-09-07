/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificadel202;

/**
 *
 * @author Imbrosciano Mattia
 */
public class VisualizzaTh extends Thread {

    public VisualizzaTh(DatiCondivisi datiCon) {
        this.datiCon = datiCon;
    }

    public void run() {
        while (true) {
            datiCon.WaitVisualizza();
                if (!datiCon.isStart()) {
                break;
            }
            String[] VETT = datiCon.getVETT();
            int numElVETT = datiCon.getNumElVETT();
            for (int i = 0; i < numElVETT; i++) {
                System.out.println(VETT[i]);
            }
            datiCon.SignalRicevere();
        }
    }
    private DatiCondivisi datiCon;
}
