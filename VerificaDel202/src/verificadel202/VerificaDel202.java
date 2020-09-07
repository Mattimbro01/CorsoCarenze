/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificadel202;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Imbrosciano Mattia
 */
public class VerificaDel202 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here

        String[] elencoGOOGLE = {"agora.ismonnet.it", "www.google.com",
            "github.com", "www.ismonnet.gov.it", "github.com/giodabg",
            "github.com/test"};
        String[] elencoCACHE = {"https://www.html.it/pag/50430/gli-array-injava",
            "www.html.it", "https://www.ismonnet.gov.it",
            "github.com/giodabg/EseThread",
            "https://www.ismonnet.gov.it/circolari.asp?bld=doc"};

        DatiCondivisi datiCon = new DatiCondivisi(elencoGOOGLE, elencoCACHE);
        RiceveTh ric = new RiceveTh(datiCon);
        LetturaTh l1 = new LetturaTh(datiCon, 0);
        LetturaTh l2 = new LetturaTh(datiCon, 1);
        VisualizzaTh v1 = new VisualizzaTh(datiCon);
        ric.start();
        l1.start();
        l2.start();
        v1.start();
        ric.join();
        l1.join();
        l2.join();
        v1.join();
        if (datiCon.getNumElVETT() > 0) {
            System.out.println("L' elenco degli URL suggeriti per " + datiCon.getSTR() + " è");
            Visualizza(datiCon.getVETT(), datiCon.getNumElVETT());
        } else {
            System.out.println("Non ho trovato niente!!");
        }
    }

    private static void Visualizza(String[] array, int numEl) {
        for (int i = 0; i < numEl; i++) {
            System.out.println(array[i]);
        }

    }

}
