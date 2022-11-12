package com.klashdevelopment.klashnetwork.klashitemsys;

import lombok.Builder;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

@Builder()
public class ItemRecipe {

    public Stack[] stacks;
    public ItemStack result;
    public String id;
    public ShapedRecipe getfrom(String namespace) {

        if(stacks == null || stacks.length < 9
        || id == null || id == "" ||
        result == null) {
            throw new RuntimeException("Invalid stacks/id/result.");
        }

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(namespace, id), result);
        if(stacks[0] instanceof Stack.ite) {
            Stack.ite stack = (Stack.ite)stacks[0];
            recipe.setIngredient('A', stack.matr);
        }
        if(stacks[1] instanceof Stack.ite) {
            Stack.ite stack = (Stack.ite)stacks[1];
            recipe.setIngredient('B', stack.matr);
        }
        if(stacks[2] instanceof Stack.ite) {
            Stack.ite stack = (Stack.ite)stacks[2];
            recipe.setIngredient('C', stack.matr);
        }
        if(stacks[3] instanceof Stack.ite) {
            Stack.ite stack = (Stack.ite)stacks[3];
            recipe.setIngredient('D', stack.matr);
        }
        if(stacks[4] instanceof Stack.ite) {
            Stack.ite stack = (Stack.ite)stacks[4];
            recipe.setIngredient('E', stack.matr);
        }
        if(stacks[5] instanceof Stack.ite) {
            Stack.ite stack = (Stack.ite)stacks[5];
            recipe.setIngredient('F', stack.matr);
        }
        if(stacks[6] instanceof Stack.ite) {
            Stack.ite stack = (Stack.ite)stacks[6];
            recipe.setIngredient('G', stack.matr);
        }
        if(stacks[7] instanceof Stack.ite) {
            Stack.ite stack = (Stack.ite)stacks[7];
            recipe.setIngredient('H', stack.matr);
        }
        if(stacks[8] instanceof Stack.ite) {
            Stack.ite stack = (Stack.ite)stacks[8];
            recipe.setIngredient('I', stack.matr);
        }
        if(stacks[0] instanceof Stack.mat) {
            Stack.mat stack = (Stack.mat)stacks[0];
            recipe.setIngredient('A', stack.matr);
        }
        if(stacks[1] instanceof Stack.mat) {
            Stack.mat stack = (Stack.mat)stacks[1];
            recipe.setIngredient('B', stack.matr);
        }
        if(stacks[2] instanceof Stack.mat) {
            Stack.mat stack = (Stack.mat)stacks[2];
            recipe.setIngredient('C', stack.matr);
        }
        if(stacks[3] instanceof Stack.mat) {
            Stack.mat stack = (Stack.mat)stacks[3];
            recipe.setIngredient('D', stack.matr);
        }
        if(stacks[4] instanceof Stack.mat) {
            Stack.mat stack = (Stack.mat)stacks[4];
            recipe.setIngredient('E', stack.matr);
        }
        if(stacks[5] instanceof Stack.mat) {
            Stack.mat stack = (Stack.mat)stacks[5];
            recipe.setIngredient('F', stack.matr);
        }
        if(stacks[6] instanceof Stack.mat) {
            Stack.mat stack = (Stack.mat)stacks[6];
            recipe.setIngredient('G', stack.matr);
        }
        if(stacks[7] instanceof Stack.mat) {
            Stack.mat stack = (Stack.mat)stacks[7];
            recipe.setIngredient('H', stack.matr);
        }
        if(stacks[8] instanceof Stack.mat) {
            Stack.mat stack = (Stack.mat)stacks[8];
            recipe.setIngredient('I', stack.matr);
        }

        recipe.shape(
                "ABC",
                "DEF",
                "GHI"
        );

        return recipe;
    }

}
