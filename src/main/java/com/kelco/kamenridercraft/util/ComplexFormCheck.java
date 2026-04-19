package com.kelco.kamenridercraft.util;

public class ComplexFormCheck {
    public static String oooComboCheck(String medalOne, String medalTwo, String medalThree) {
        if (medalOne.equals("kamenridercraft:kuwagata_medal") && medalTwo.equals("kamenridercraft:kamakiri_medal") && medalThree.equals("kamenridercraft:batta_medal")) {
            return "gatakiriba";
        }
       return "";
    }

}
