package com.company.osztalyok;

public class Uralkodo {

    private String nev;
    private int uralkodasKezdete;
    private int uralkodasVege;
    private String uralkodasTipus;

    public Uralkodo(String nev, int uralkodasKezdete, int uralkodasVege, String uralkodasTipus) {
        this.nev = nev;
        this.uralkodasKezdete = uralkodasKezdete;
        this.uralkodasVege = uralkodasVege;
        this.uralkodasTipus = uralkodasTipus;
    }

    public Uralkodo(String sor){
        String[] adatok = sor.split(";");

        this.nev = adatok[0];
        this.uralkodasKezdete = Integer.parseInt(adatok[1]);
        if ("".equals(adatok[2])) {
            this.uralkodasVege = 0;
        } else {
            this.uralkodasVege = Integer.parseInt(adatok[2]);
        }
        this.uralkodasTipus = adatok[3];
    }

    public String getNev() {
        return nev;
    }

    public int getUralkodasKezdete() {
        return uralkodasKezdete;
    }

    public int getUralkodasVege() {
        return uralkodasVege;
    }

    public String getUralkodasTipus() {
        return uralkodasTipus;
    }

    @Override
    public String toString() {
        return  this.nev + " " +
                this.uralkodasKezdete + " " +
                this.uralkodasVege + " " +
                this.uralkodasTipus;
    }
}
