package com.klashdevelopment.klashnetwork.klashitemsys;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertySet {

    public String name = "&eMyItemName";
    public String description = "Add a description to your custom item here!";
    public List<String> lore = new ArrayList<String>();
    public Material material = Material.STONE;
    public int defaultAmount = 1;
    public Enchantment[] enchantments = new Enchantment[] {};
    public ItemFlag[] flags = new ItemFlag[] {ItemFlag.HIDE_ENCHANTS};
    public boolean cancelClickEvent = false;
    public boolean cancelBreakEvent = false;
    public ItemRecipe recipe = null;
    public String id = null;

    public FormattedPropertySet format() {
        return new FormattedPropertySet(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    // builder
    public static class Builder {

        private PropertySet propertySet;

        public Builder() {
            propertySet = new PropertySet();
        }
        public Builder setName(String name) {
            propertySet.name = name;
            return this;
        }
        public Builder setDescription(String description) {
            propertySet.description = description;
            return this;
        }
        public Builder setLore(List<String> lore) {
            propertySet.lore = lore;
            return this;
        }
        public Builder setMaterial(Material material) {
            propertySet.material = material;
            return this;
        }
        public Builder setDefaultAmount(int defaultAmount) {
            propertySet.defaultAmount = defaultAmount;
            return this;
        }
        public Builder setId(String id) {
            propertySet.id = id;
            return this;
        }
        public Builder setEnchantments(Enchantment[] enchantments) {
            propertySet.enchantments = enchantments;
            return this;
        }
        public Builder setRecipe(ItemRecipe recipe) {
            propertySet.recipe = recipe;
            return this;
        }
        public Builder setFlags(ItemFlag[] flags) {
            propertySet.flags = flags;
            return this;
        }
        public Builder setCancelClickEvent(boolean cancelClickEvent) {
            propertySet.cancelClickEvent = cancelClickEvent;
            return this;
        }
        public Builder setCancelBreakEvent(boolean cancelBreakEvent) {
            propertySet.cancelBreakEvent = cancelBreakEvent;
            return this;
        }
        public PropertySet build() {
            return propertySet;
        }

    }
}
