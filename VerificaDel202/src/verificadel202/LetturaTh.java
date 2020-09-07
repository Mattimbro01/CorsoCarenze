/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificadel202;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Imbrosciano Mattia
 */
public class LetturaTh extends Thread {

    //Dati Condivisi
    public LetturaTh(DatiCondivisi datiCon, int numeroBuffer) {
        this.datiCon = datiCon;
        this.numeroBuffer = numeroBuffer;
    }

    public void run() {

        while (true) {
            datiCon.WaitLettura(numeroBuffer + 1);
            if (!datiCon.isStart()) {
                break;
            }
            String[] Buffer = datiCon.getBuffer(numeroBuffer);
            String str = datiCon.getSTR();
            for (int i = 0; i < Buffer.length; i++) {
                if (Buffer[i].contains(str)) {
                    datiCon.pushVett(Buffer[i]);
                }
            }
            datiCon.SignalVisualizza();
        }
    }
    private DatiCondivisi datiCon;
    private int numeroBuffer;
}
