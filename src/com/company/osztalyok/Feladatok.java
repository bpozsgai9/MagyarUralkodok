package com.company.osztalyok;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Feladatok {

    private List<Uralkodo> uralkodoLista;

    public Feladatok(String fajlNev) {

        this.uralkodoLista = new LinkedList<Uralkodo>();

        try{

            FileReader fr = new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);

            String sor = br.readLine();
            while (sor != null){

                this.uralkodoLista.add(new Uralkodo(sor));
                sor = br.readLine();
            }

            br.close();
            fr.close();

        } catch (Exception e) {
            System.out.println("Hiba: " + e);
            e.printStackTrace();
        }
    }

    public void elsoFeladat(){
        System.out.println("1. feladat: ");

        Uralkodo elsoUralkodoKezdete = this.uralkodoLista.stream()
                .min(Comparator.comparing(Uralkodo::getUralkodasKezdete))
                .get();

        System.out.println(elsoUralkodoKezdete.getNev());
    }

    public void masodikFeladat(){
        System.out.println("2. feladat: ");

        int leghosszabbIdeigUralkodo = 0;
        String leghosszabbIdeigUralkodoSzemely = "";
        for (Uralkodo i : this.uralkodoLista) {
            if (i.getUralkodasVege() != 0){
                if (leghosszabbIdeigUralkodo < i.getUralkodasVege() - i.getUralkodasKezdete()) {
                    leghosszabbIdeigUralkodo = i.getUralkodasVege() - i.getUralkodasKezdete();
                    leghosszabbIdeigUralkodoSzemely = i.getNev();
                }
            }
        }
        System.out.println(leghosszabbIdeigUralkodoSzemely);
    }

    public void harmadikFeladat(){
        System.out.println("3. feladat: ");

        long arpadHaziKiralyokSzama = this.uralkodoLista.stream()
                .filter(uralkodo -> uralkodo.getUralkodasTipus().equals("Árpád-házi király"))
                .count();

        System.out.println(arpadHaziKiralyokSzama);
    }

    public void negyedikFeladat(){
        System.out.println("4. feladat: ");

        String bemenoParameter = "Erdélyi fejedelmek";
        List<String> kiralyok = this.uralkodoLista.stream()
                .filter(uralkodo -> uralkodo.getUralkodasTipus().equals(bemenoParameter))
                .map(uralkodo -> uralkodo.getNev())
                .collect(Collectors.toList());
        for (String i : kiralyok) {
            System.out.println(i);
        }
    }

    public void otodikFeladat(){
        System.out.println("5. feladat: ");

        int kezdet = 1625;
        int veg = 1825;

        List<Uralkodo> lista = this.uralkodoLista.stream()
                .filter(uralkodo -> uralkodo.getUralkodasKezdete() > kezdet
                        && uralkodo.getUralkodasVege() < veg)
                .collect(Collectors.toList());

        System.out.println(lista.size());

    }

    @Override
    public String toString() {

        String s = "";
        for (Uralkodo i : this.uralkodoLista) {
            s += i + "\n";
        }
        return s;
    }
}
