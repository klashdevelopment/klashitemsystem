package com.klashdevelopment.klashnetwork.klashitemsys;

import com.destroystokyo.paper.Namespaced;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Factory {
    public static ItemStack createItem(Item item) {
        ItemStack stack = new ItemStack(item.getPropertySet().material);
        ItemMeta meta = stack.getItemMeta();
        stack.setAmount(item.getPropertySet().defaultAmount);
        meta.displayName(Component.text(item.getPropertySet().name));
        meta.lore(presetLore(item.getPropertySet()));

        for(Enchantment enchantment : item.getPropertySet().enchantments) {
            meta.addEnchant(enchantment.enchantment(), enchantment.level(), true);
        }
        stack.addItemFlags(item.getPropertySet().flags);

        Set<Namespaced> keys = meta.getPlaceableKeys();
        keys.add(LazyNamespaced.ofItemSys(item.getPropertySet().id));
        meta.setPlaceableKeys(keys);

        stack.setItemMeta(meta);

        stack = item.modifyBeforeCreation(stack);

        return stack;
    }

    public static List<Component> presetLore(FormattedPropertySet propertySet) {
        return new ArrayList<>(ComponentUtils.textFromStringList(propertySet.getLoreList()));
    }
}
