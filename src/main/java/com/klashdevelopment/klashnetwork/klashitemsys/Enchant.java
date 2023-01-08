package com.klashdevelopment.klashnetwork.klashitemsys;

public record Enchant(org.bukkit.enchantments.Enchantment enchantment, int level) {

    public String name() {
        return enchantment().getKey().getKey();
    }
    public String format() { return name().substring(0, 1).toUpperCase() + name().substring(1) + " " + levelornumeral(); }
    public String levelornumeral() {
        String rslt = String.valueOf(level());
        if(rslt.equals("0")) {
            return "";
        } else if (rslt.equals("1")) {
            return "I";
        } else if (rslt.equals("2")) {
            return "II";
        } else if (rslt.equals("3")) {
            return "III";
        } else if (rslt.equals("4")) {
            return "IV";
        } else if (rslt.equals("5")) {
            return "V";
        } else if (rslt.equals("6")) {
            return "VI";
        } else if (rslt.equals("7")) {
            return "VII";
        } else if (rslt.equals("8")) {
            return "VIII";
        } else if (rslt.equals("9")) {
            return "IX";
        } else if (rslt.equals("10")) {
            return "X";
        } else {
            return rslt;
        }
    }

}
