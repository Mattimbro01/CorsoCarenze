/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificadel20;

import java.util.Scanner;

/**
 *
 * @author Imbrosciano Mattia
 */
public class VerificaDel20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);// Create a Scanner object
        String carattere = "";

        do {
            System.out.println("premi p per lanciare (pull) i due piattelli o f per finire");
            carattere = scanner.nextLine();
            if (carattere.equals("p")) {
                DatiCondivisi datiCon = new DatiCondivisi();
                PiattelloTh p1 = new PiattelloTh(datiCon, 1);
                PiattelloTh p2 = new PiattelloTh(datiCon, 2);
                ProiettileTh pro1 = new ProiettileTh(datiCon, 1);
                ProiettileTh pro2 = new ProiettileTh(datiCon, 2);
                p1.start();
                p2.start();
                int s = 0;
                Thread.sleep(10);
                do {
                    if (s == 0) {
                        do {
                            System.out.println("premi s per sparare il primo proiettile");
                            carattere = scanner.nextLine();
                        } while (!carattere.equals("s"));
                        pro1.start();
                        s++;
                    }
                    if (s == 1) {
                        do {
                            System.out.println("premi s per sparare il secondo proiettile");
                            carattere = scanner.nextLine();
                        } while (!carattere.equals("s"));
                        pro2.start();
                        s++;
                    }
                } while (s < 2);
                p1.join();
                p2.join();
                pro1.join();
                pro2.join();
            }
        } while (!carattere.equals("f"));
    }

}
