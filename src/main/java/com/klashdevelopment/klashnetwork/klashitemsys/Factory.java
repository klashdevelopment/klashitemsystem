package com.klashdevelopment.klashnetwork.klashitemsys;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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

        stack.setItemMeta(meta);

        stack = item.modifyBeforeCreation(stack);

        return stack;
    }

    public static List<Component> presetLore(FormattedPropertySet propertySet) {
        List<String> befores = new ArrayList<>();
        List<String> afters = new ArrayList<>();
        befores.add(propertySet.description);
        for(Enchantment enchantment : propertySet.enchantments) {
            befores.add(enchantment.enchantment() + ": L" + enchantment.level());
        }

        List<String> lore = new ArrayList<>();
        lore.addAll(befores);
        if(!propertySet.lore.isEmpty()) {
            lore.add(" ");
        }
        lore.addAll(propertySet.lore);
        if(!propertySet.lore.isEmpty()) {
            lore.add(" ");
        }
        lore.addAll(afters);
        return ComponentUtils.fromStringList(lore);
    }
}
