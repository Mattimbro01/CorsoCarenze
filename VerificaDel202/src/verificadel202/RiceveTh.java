/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificadel202;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Imbrosciano Mattia
 */
public class RiceveTh extends Thread {

    public RiceveTh(DatiCondivisi datiCon) {
        this.datiCon = datiCon;
    }

    @Override
    //thread 1 che riceve dall’utente un URL un carattere alla volta e li accoda ad una stringa STR
    public void run() {
        String lettera = " ";
        String ultimalettera = " ";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            datiCon.WaitRicevere();
            System.out.print("URL suggeriti per " + datiCon.getSTR());
            lettera = scanner.nextLine();
            if (!lettera.equals("")) {
                datiCon.ResetVETT();
                datiCon.SetSTR(lettera);
                datiCon.SignalLettura();
            } else if (lettera.equals("")) {
                datiCon.setStart(false);
                break;
            }
        }
    }
    //Dati Condivisi
    private DatiCondivisi datiCon;
}
