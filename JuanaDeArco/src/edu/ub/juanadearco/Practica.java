/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.juanadearco;

import edu.ub.juanadearco.actors.Heroina;
import edu.ub.juanadearco.actors.Menjar;
import edu.ub.juanadearco.actors.Vida;
import edu.ub.juanadearco.actors.Serp;
import edu.ub.juanadearco.actors.Clau;

/**
 *
 * @author joanb
 */
public class Practica {

    private Joc joc;
    private Castell castell;
    private Heroina heroina;

    private static final int MAX_MENJAR_PER_HABITACIO = 2;
    private static final int MAX_CLAUS_PER_HABITACIO = 1;

    private Practica() {
        castell = new Castell(3, 3);
        castell.addHabitacio(0, 0, crearHabitacio0Planta0());
        castell.addHabitacio(0, 1, crearHabitacio1Planta0());
        castell.addHabitacio(0, 2, crearHabitacio2Planta0());
        castell.addHabitacio(1, 0, crearHabitacio0Planta1());
        castell.addHabitacio(1, 1, crearHabitacio1Planta1());
        castell.addHabitacio(1, 2, crearHabitacio2Planta1());
        castell.addHabitacio(2, 0, crearHabitacio0Planta2());
        castell.addHabitacio(2, 1, crearHabitacio1Planta2());
        castell.addHabitacio(2, 2, crearHabitacio2Planta2());

        heroina = new Heroina();
        Habitacio h = castell.getHabitacio(0, 0);
        int[] p = h.getPosicioCela(10, 10);
        heroina.setPosicioInicial(p[0], p[1]);

        joc = new Joc(castell, heroina);
        distribuirMenjar();
        distribuirVides();
        distribuirSerps();
        distribuirClaus();
        
        

        GuiJoc gui = new GuiJoc(joc);
    }

    private Habitacio crearHabitacio0Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_0.txt");

        Porta porta = h.getPorta(14, 24);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 1));

        porta = h.getPorta(0, 10);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 10));

        return h;
    }

    private Habitacio crearHabitacio1Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_1.txt");

        Porta porta = h.getPorta(1, 0);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 23));

        return h;
    }

    private Habitacio crearHabitacio2Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_2.txt");
        Porta porta = h.getPorta(16, 10);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 10));

        porta = h.getPorta(0, 13);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 14));

        return h;
    }

    private Habitacio crearHabitacio0Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_0.txt");

        Porta porta = h.getPorta(16, 14);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 13));

        porta = h.getPorta(0, 20);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(12, 1));

        return h;
    }

    private Habitacio crearHabitacio1Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_1.txt");

        Porta porta = h.getPorta(12, 0);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 20));

        porta = h.getPorta(16, 14);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 6));

        return h;
    }

    private Habitacio crearHabitacio2Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_2.txt");

        Porta porta = h.getPorta(0, 6);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 14));

        porta = h.getPorta(10, 21);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8, 12));

        return h;
    }

    private Habitacio crearHabitacio0Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_0.txt");

        Porta porta = h.getPorta(7, 12);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(10, 22));

        porta = h.getPorta(0, 21);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(2, 6));

        return h;
    }

    private Habitacio crearHabitacio1Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_1.txt");

        Porta porta = h.getPorta(0, 6);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(2, 21));

        porta = h.getPorta(16, 22);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 7));

        return h;
    }

    private Habitacio crearHabitacio2Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_2.txt");

        Porta porta = h.getPorta(0, 7);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 22));

        return h;
    }

    private void distribuirMenjar() {
        String[] menjars = {"Pizza", "Pollastre", "Síndria"};
        // { calories,x,y,width,height } de cada imatge
        int[][] dades = {
            {25, 540, 14, 30, 22},
            {50, 439, 14, 27, 23},
            {50, 97, 100, 30, 20}
        };

        for (int i = 0; i < castell.getNumPlantes(); i++) {

            for (int j = 0; j < castell.getNumHabitacions(i); j++) {
                Habitacio h = castell.getHabitacio(i, j);
                int numMenjars = (int) (Math.random() * (MAX_MENJAR_PER_HABITACIO + 1));

                for (int k = 0; k < numMenjars; k++) {
                    int[] cela = obtenirCelaLliure(h);
                    int imenjar = (int) (Math.random() * menjars.length);
                    Menjar m = new Menjar(menjars[imenjar],
                            dades[imenjar][0], dades[imenjar][1], dades[imenjar][2],
                            dades[imenjar][3], dades[imenjar][4]);

                    int[] posicio = h.getPosicioCela(cela[0], cela[1]);
                    m.setPosicioInicial(posicio[0], posicio[1]);
                    h.addActor(m);
                }
            }

        }
    }

    private void distribuirVides() {
        String[] vida = {"Vida"};
        // { calories,x,y,width,height } de scada imatge
        int[][] dades = {
            {100, 174, 12, 26, 24}};

        int ivida = (0);
        Vida v1 = new Vida(vida[ivida],
                dades[ivida][0], dades[ivida][1], dades[ivida][2],
                dades[ivida][3], dades[ivida][4]);
        Vida v2 = new Vida(vida[ivida],
                dades[ivida][0], dades[ivida][1], dades[ivida][2],
                dades[ivida][3], dades[ivida][4]);

        Habitacio h = castell.getHabitacio(2, 2);
        int[] posicio1 = h.getPosicioCela(2, 2);
        v1.setPosicioInicial(posicio1[0], posicio1[1]);
        h.addActor(v1);

        Habitacio k = castell.getHabitacio(1, 2);
        int[] posicio2 = k.getPosicioCela(14, 22);
        v2.setPosicioInicial(posicio2[0], posicio2[1]);
        k.addActor(v2);

    }

    private void distribuirSerps() {
        String[] serp = {"Serp"};
        // { calories,x,y,width,height } de scada imatge
        int[][] dades = {
            {-50, 700, 42, 40, 42}};

        int iserp = (0);
        Serp s1 = new Serp(serp[iserp],
                dades[iserp][0], dades[iserp][1], dades[iserp][2],
                dades[iserp][3], dades[iserp][4]);
        Serp s2 = new Serp(serp[iserp],
                dades[iserp][0], dades[iserp][1], dades[iserp][2],
                dades[iserp][3], dades[iserp][4]);
        Serp s3 = new Serp(serp[iserp],
                dades[iserp][0], dades[iserp][1], dades[iserp][2],
                dades[iserp][3], dades[iserp][4]);
        Serp s4 = new Serp(serp[iserp],
                dades[iserp][0], dades[iserp][1], dades[iserp][2],
                dades[iserp][3], dades[iserp][4]);
        Serp s5 = new Serp(serp[iserp],
                dades[iserp][0], dades[iserp][1], dades[iserp][2],
                dades[iserp][3], dades[iserp][4]);
        Serp s6 = new Serp(serp[iserp],
                dades[iserp][0], dades[iserp][1], dades[iserp][2],
                dades[iserp][3], dades[iserp][4]);
        Serp s7 = new Serp(serp[iserp],
                dades[iserp][0], dades[iserp][1], dades[iserp][2],
                dades[iserp][3], dades[iserp][4]);

        Habitacio h = castell.getHabitacio(1, 0);
        int[] posicio1 = h.getPosicioCela(6, 17);
        s1.setPosicioInicial(posicio1[0], posicio1[1]);
        h.addActor(s1);

        Habitacio i = castell.getHabitacio(1, 1);
        int[] posicio2 = i.getPosicioCela(14, 19);
        s2.setPosicioInicial(posicio2[0], posicio2[1]);
        i.addActor(s2);

        Habitacio j = castell.getHabitacio(1, 2);
        int[] posicio3 = j.getPosicioCela(6, 21);
        s3.setPosicioInicial(posicio3[0], posicio3[1]);
        j.addActor(s3);

        Habitacio k = castell.getHabitacio(1, 2);
        int[] posicio4 = k.getPosicioCela(5, 20);
        s4.setPosicioInicial(posicio4[0], posicio4[1]);
        k.addActor(s4);

        Habitacio l = castell.getHabitacio(2, 0);
        int[] posicio5 = l.getPosicioCela(6, 4);
        s5.setPosicioInicial(posicio5[0], posicio5[1]);
        l.addActor(s5);

        Habitacio m = castell.getHabitacio(1, 0);
        int[] posicio7 = m.getPosicioCela(3, 2);
        s7.setPosicioInicial(posicio7[0], posicio7[1]);
        m.addActor(s7);

        Habitacio n = castell.getHabitacio(2, 2);
        int[] posicio6 = n.getPosicioCela(14, 9);
        s6.setPosicioInicial(posicio6[0], posicio6[1]);
        n.addActor(s6);

    }

    private void distribuirClaus() {
        String[] claus = {"Ferro", "Bronze", "Llautó", "Plata", "Or"};
        // { calories,x,y,width,height } de cada imatge
        int[][] dades = {
            {675, 50, 20, 30},
            {675, 50, 20, 30},
            {675, 50, 20, 30},
            {675, 50, 20, 30},
            {675, 50, 20, 30}
        };
        int contClaus = 0;
        boolean totesLesClaus = false;

        while (contClaus < 5) {
            if (totesLesClaus == false) {
                for (int i = 0; i < castell.getNumPlantes(); i++) {

                    for (int j = 0; j < castell.getNumHabitacions(i); j++) {
                        if (totesLesClaus == false) {
                            Habitacio h = castell.getHabitacio(i, j);
                            int numClaus = (int) (Math.random() * (MAX_CLAUS_PER_HABITACIO + 1));

                            for (int k = 0; k < numClaus; k++) {
                                int[] cela = obtenirCelaLliure(h);
                                int iclau = contClaus;
                                Clau clau = new Clau(claus[iclau],
                                        dades[iclau][0], dades[iclau][1], dades[iclau][2],
                                        dades[iclau][3]);

                                int[] posicio = h.getPosicioCela(cela[0], cela[1]);
                                clau.setPosicioInicial(posicio[0], posicio[1]);
                                h.addActor(clau);
                                if (contClaus == 4) {
                                    totesLesClaus = true;
                                }
                                if (contClaus < 5) {
                                    contClaus++;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private int[] obtenirCelaLliure(Habitacio h) {
        int fila = 0;
        int col = 0;
        int cela[] = null;
        boolean trobada = false;
        boolean terra = false;

        while (!trobada) {
            terra = false;
            while (!terra) {
                fila = (int) (Math.random() * Constants.NUM_CELES_VERTICALS);
                col = (int) (Math.random() * Constants.NUM_CELES_HORIZONTALS);
                terra = h.getValor(fila, col) == Constants.SIMBOL_TERRA;
            }

            // comprovar que cap actor està dins la cela
            Actor[] actors = h.getActorsAsArray();
            int i = 0;
            boolean lliure = true;
            while (i < actors.length && lliure) {
                cela = h.getCela(actors[i].getPosicioInicial()[0],
                        actors[i].getPosicioInicial()[1]);
                lliure = fila != cela[0] || col != cela[1];
                i++;
            }
            trobada = lliure;
        }
        return new int[]{fila, col};
    }

    /**
     * Principal.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Practica();
    }

}
