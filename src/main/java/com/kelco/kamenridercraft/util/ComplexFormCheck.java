package com.kelco.kamenridercraft.util;

public class ComplexFormCheck {
    public static String oooComboCheck(String medalOne, String medalTwo, String medalThree) {
        String comboText = medalOne.replace("kamenridercraft:", "") + " " + medalTwo.replace("kamenridercraft:", "") + " " + medalThree.replace("kamenridercraft:", "");
        System.out.println(comboText);
        return switch (comboText) {
            case "taka_medal tora_medal batta_medal" -> "tatoba";
            case "super_taka_medal super_tora_medal super_batta_medal" -> "super_tatoba";
            case "kuwagata_medal kamakiri_medal batta_medal" -> "gatakiriba";
            case "lion_medal tora_medal cheetah_medal" -> "latorartar";
            case "taka_medal kujaku_medal condor_medal" -> "tajadol";
            case "taka_eternity_medal kujaku_eternity_medal condor_eternity_medal" -> "tajadol_eternity";
            case "shachi_medal unagi_medal tako_medal" -> "shauta";
            case "sai_medal gorilla_medal zou_medal" -> "sagohzo";
            case "ptera_medal tricera_medal tyranno_medal" -> "putotyra";
            case "cobra_medal kame_medal wani_medal" -> "burakawani";
            case "seiuchi_medal shirokuma_medal penguin_medal" -> "seishirogin ";
            case "mukade_medal hachi_medal ari_medal" -> "mukachiri";
            case "shika_medal gazelle_medal ushi_medal" -> "shigazeshi";
            case "ebi_medal kani_medal sasori_medal" -> "bikaso";
            case "same_medal kujira_medal ookamiuo_medal" -> "saramiuo";
            case "love_core_medal love_core2_medal love_core_3_medal" -> "renai";
            case "taka_medal imagin_medal shocker_medal" -> "tamashii";
            default -> "";
        };
    }

}
