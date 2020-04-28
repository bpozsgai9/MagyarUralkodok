package com.company;

import com.company.osztalyok.Feladatok;

public class Main {

    public static void main(String[] args) {
        Feladatok f = new Feladatok("src/forras/magyar-uralkodo.csv");
        //System.out.println(f);
        f.elsoFeladat();
        f.masodikFeladat();
        f.harmadikFeladat();
        f.negyedikFeladat();
        f.otodikFeladat();
    }
}
