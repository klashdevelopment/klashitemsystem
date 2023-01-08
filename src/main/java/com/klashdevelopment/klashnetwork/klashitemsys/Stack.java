package com.klashdevelopment.klashnetwork.klashitemsys;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class Stack {
    public static RecipeChoice air = Stack.from(Material.AIR);

    public static RecipeChoice from(ItemStack stack) {
        return new RecipeChoice.ExactChoice(stack);
    }
    public static RecipeChoice from(Material stack) {
        return new RecipeChoice.MaterialChoice(stack);
    }

}
