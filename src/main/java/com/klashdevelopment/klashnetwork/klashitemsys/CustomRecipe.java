package com.klashdevelopment.klashnetwork.klashitemsys;

import lombok.Builder;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

@Builder()
public class CustomRecipe {

    public RecipeChoice[] stacks;
    public Item result;
    public String id;
    public ShapedRecipe getfrom(String namespace) {

        if(stacks == null || stacks.length < 9
        || id == null || id == "" ||
        result == null) {
            throw new RuntimeException("Invalid stacks/id/result.");
        }

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(namespace, id), Factory.createItem(result));
        recipe.shape(
                "ABC",
                "DEF",
                "GHI"
        );
        recipe.setIngredient('A', stacks[0]);
        recipe.setIngredient('B', stacks[1]);
        recipe.setIngredient('C', stacks[2]);
        recipe.setIngredient('D', stacks[3]);
        recipe.setIngredient('E', stacks[4]);
        recipe.setIngredient('F', stacks[5]);
        recipe.setIngredient('G', stacks[6]);
        recipe.setIngredient('H', stacks[7]);
        recipe.setIngredient('I', stacks[8]);

        return recipe;
    }

}
