package com.klashdevelopment.klashnetwork.klashitemsys;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Stack {
    public static Stack air = Stack.from(Material.AIR);
    public static class mat extends Stack {
        public Material matr;
        public mat(Material matr) {
            this.matr = matr;
        }
    }
    public static class ite extends Stack {
        public ItemStack matr;
        public ite(ItemStack matr) {
            this.matr = matr;
        }
    }

    public static Stack from(ItemStack stack) {
        return new ite(stack);
    }
    public static Stack from(Material stack) {
        return new mat(stack);
    }

}
