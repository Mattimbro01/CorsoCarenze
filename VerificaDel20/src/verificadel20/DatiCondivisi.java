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
public class DatiCondivisi {

    private Semaforo piatello1;
    private Semaforo piatello2;
    private Semaforo proiettile;

    public DatiCondivisi() {
        piatello1 = new Semaforo(0);
        piatello2 = new Semaforo(0);
        proiettile = new Semaforo(1);
    }

    public void SignalPiatello(int i) {
        if (i == 1) {
            piatello1.Signal();
        } else {
            piatello2.Signal();
        }
    }

    public void SignalProiettile() {
        proiettile.Signal();
    }

    public void WaitPiatello(int i) {
        if (i == 1) {
            piatello1.Wait();
        } else {
            piatello2.Wait();
        }
    }

    public void WaitProiettile() {
        proiettile.Wait();
    }
}
