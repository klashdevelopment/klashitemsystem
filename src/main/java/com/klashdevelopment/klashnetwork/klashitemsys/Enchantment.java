package com.klashdevelopment.klashnetwork.klashitemsys;

public record Enchantment(org.bukkit.enchantments.Enchantment enchantment, int level) {

    public String name() {
        return enchantment().getKey().getKey();
    }

}
