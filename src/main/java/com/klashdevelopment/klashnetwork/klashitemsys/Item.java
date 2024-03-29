package com.klashdevelopment.klashnetwork.klashitemsys;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public interface Item {
    public FormattedPropertySet getPropertySet();
    public default ItemStack modifyBeforeCreation(ItemStack stack) {
        stack.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return stack;
    }
    public default void itemInteract(PlayerInteractEvent ev) {};
    public default void blockBreak(BlockBreakEvent ev) {};
}
