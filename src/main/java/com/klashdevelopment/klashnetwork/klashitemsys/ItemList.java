package com.klashdevelopment.klashnetwork.klashitemsys;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;

import java.util.ArrayList;

public class ItemList extends ArrayList<Item> {

    public boolean add(Item item, String namespace) {
        try {
            if(item.getPropertySet().recipe == null) {

            }else {
                KlashItemSys.getPlugin(KlashItemSys.class).getServer().addRecipe(item.getPropertySet().recipe.getfrom(namespace));
            }
        }catch(Exception ignored) {

        }
        return super.add(item);
    }

    @Override
    public boolean add(Item item) {
        return add(item, item.getPropertySet().id);
    }
}
