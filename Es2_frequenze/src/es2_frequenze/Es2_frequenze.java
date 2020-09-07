/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2_frequenze;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Imbrosciano Mattia
 */
public class Es2_frequenze {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        //chiedere all'utente una stringa contenente delle fermate di una linea di autobus
        String fermate = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci le fermate:(ogni fermata deve essere diviso da una ,)");
        fermate = scanner.nextLine();
        fermate += ", ";
        //memorizzo in un vettore le fermate
        String[] fermateBus = fermate.split(",");
        //gli orari di 5 corse che partono ad orari differenti
        ArrayList<Ora[]> elencoCorse = new ArrayList<Ora[]>();
        elencoCorse.add(TrasmormoOre(VerificaCorsa(RiempiCorsa(1), 1)));
        elencoCorse.add(TrasmormoOre(VerificaCorsa(RiempiCorsa(2), 2)));
        elencoCorse.add(TrasmormoOre(VerificaCorsa(RiempiCorsa(3), 3)));
        elencoCorse.add(TrasmormoOre(VerificaCorsa(RiempiCorsa(4), 4)));
        elencoCorse.add(TrasmormoOre(VerificaCorsa(RiempiCorsa(5), 5)));
        //chiedere all'utente di inserire il nome del comune da cui parte e il nome del comune dove deve andare 
        String ComunePartenza = "";
        String ComuneArrivo = "";
        System.out.println("Inserisci il comune di partenza");
        ComunePartenza = scanner.nextLine();
        System.out.println("Inserisci il comune di arrivo");
        ComuneArrivo = scanner.nextLine();
        //Thead
        DatiCondivisi datiCon = new DatiCondivisi(ComunePartenza, ComuneArrivo, fermateBus, elencoCorse);
        RicercaTh th1 = new RicercaTh(datiCon, 0);
        RicercaTh th2 = new RicercaTh(datiCon, 1);
        RicercaTh th3 = new RicercaTh(datiCon, 2);
        RicercaTh th4 = new RicercaTh(datiCon, 3);
        RicercaTh th5 = new RicercaTh(datiCon, 4);
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th1.join();
        th2.join();
        th3.join();
        th4.join();
        th5.join();
        //al termine il programma visualizzerà il numero di corse trovate e gli orari di ogni corsa
        if (datiCon.getCountCorseTrovate() > 0) {
            System.out.println("Corse trovate:" + datiCon.getCountCorseTrovate());
            visualizza(datiCon.getOrePartArrivo(),datiCon.getNumEl());
        } else {
            System.out.println("Corse non trovate");
        }
    }
    private static String[] OrariDiPartenza = new String[5];

    //Metodo per rempire gli array
    private static String[] RiempiCorsa(int i) {
        Scanner scanner = new Scanner(System.in);
        String[] Corsa;
        String orari = "";
        System.out.println("Inserisci gli orari della corsa " + i + "(:ogni orario deve essere diviso da una ,)");
        orari = scanner.nextLine();
        orari += ", ";
        Corsa = orari.split(",");
        return Corsa;
    }
//Metodo per verificare la partenza se concide con altre corse

    private static String[] VerificaCorsa(String[] Corsa, int numeroCorsa) {
        for (int j = 0; j < 5; j++) {
            if (Corsa[0].equals(OrariDiPartenza[j])) {
                System.out.println("Ricreare corsa!!Concidenza con altre corse sul orario di partenza ");
                return VerificaCorsa(RiempiCorsa(numeroCorsa), numeroCorsa);
            }
        }

        OrariDiPartenza[numeroCorsa - 1] = Corsa[0];
        return Corsa;
    }

    private static Ora[] TrasmormoOre(String[] array) {
        Ora[] ore = new Ora[array.length];
        Ora ora=new Ora();
        for (int i = 0; i < array.length; i++) {
            if ("".equals(array[i]) || " ".equals(array[i])) {
                ore[i] = ora.ConvertiInOra("-1");
            } else {
                ore[i] = ora.ConvertiInOra(array[i]);
            }
        }
        return ore;
    }
//Visualizza un array

    private static void visualizza(String[] array,int numEl) {
        for (int i = 0; i < numEl; i++) {
            //if (!(array[i].equals(""))) {
            System.out.println(array[i]);
            //}
        }
    }
}
