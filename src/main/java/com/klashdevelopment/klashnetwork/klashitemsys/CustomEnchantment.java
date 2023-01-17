package com.klashdevelopment.klashnetwork.klashitemsys;

import io.papermc.paper.enchantments.EnchantmentRarity;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityCategory;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public abstract class CustomEnchantment extends Enchantment {

    public String name, namespace;
    public int maxLevel;
    public boolean cursed, treasure, isInVillagerTrade, isInEnchantmentTable;
    public EnchantmentTarget target;

    public CustomEnchantment(String name, String namespace, int maxLevel, EnchantmentTarget target, boolean cursed, boolean treasure, boolean isInEnchantmentTable, boolean isInVillagerTrade) {
        super(NamespacedKey.minecraft(namespace));
        this.name = name;
        this.namespace = namespace;
        this.maxLevel = maxLevel;
        this.target = target;
        this.cursed = cursed;
        this.treasure = treasure;
        this.isInEnchantmentTable = isInEnchantmentTable;
        this.isInVillagerTrade = isInVillagerTrade;
    }
    public abstract void onBlockBreak(BlockBreakEvent event);
    public abstract void onClickWithItem(PlayerInteractEvent event);

    @Override
    public int getStartLevel() {
        return 0;
    }

    @Override
    public @NotNull EnchantmentTarget getItemTarget() {
        return target;
    }

    @Override
    public boolean isTreasure() {
        return treasure;
    }

    @Override
    public boolean isCursed() {
        return cursed;
    }

    @Override
    public boolean conflictsWith(@NotNull Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(@NotNull ItemStack item) {
        return false;
    }

    @Override
    public @NotNull Component displayName(int level) {
        return Component.text(name + " " + Enchant.levelornumeral(level));
    }

    @Override
    public boolean isTradeable() {
        return isInVillagerTrade;
    }

    @Override
    public boolean isDiscoverable() {
        return isInEnchantmentTable;
    }

    @Override
    public @NotNull EnchantmentRarity getRarity() {
        return EnchantmentRarity.RARE;
    }

    @Override
    public float getDamageIncrease(int level, @NotNull EntityCategory entityCategory) {
        return 0;
    }

    @Override
    public @NotNull Set<EquipmentSlot> getActiveSlots() {
        return Set.of();
    }

    @Override
    public @NotNull String translationKey() {
        return "";
    }
}
