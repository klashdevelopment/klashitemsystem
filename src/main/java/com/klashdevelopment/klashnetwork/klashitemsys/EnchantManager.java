package com.klashdevelopment.klashnetwork.klashitemsys;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnchantManager {

    public static List<CustomEnchantment> registeredEnchantments = new ArrayList<>();
    public static void addEnchant(CustomEnchantment enchantment) {
        boolean isAlreadyAdded = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(enchantment);
        if(!isAlreadyAdded) {
            Bukkit.getServer().getPluginManager().registerEvents(new Listener() {

                @EventHandler
                public void onBlockBreak(BlockBreakEvent event) {
                    if(event.getPlayer().getInventory().getItemInMainHand() != null && event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(enchantment)
                    ) {
                        enchantment.onBlockBreak(event);
                    }
                }
                @EventHandler
                public void onClick(PlayerInteractEvent event) {
                    if(event.getPlayer().getInventory().getItemInMainHand() != null && event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(enchantment)
                    ) {
                        enchantment.onClickWithItem(event);
                    }
                }

            }, KlashItemSys.getItemSystem());
            boolean registered = true;
            try {
                Field f = Enchantment.class.getDeclaredField("acceptingNew");
                f.setAccessible(true);
                f.set(null, true);
                Enchantment.registerEnchantment(enchantment);
            } catch (Exception except) {
                registered = false;
                except.printStackTrace();
            }
            if (registered) {
                registeredEnchantments.add(enchantment);
                KlashItemSys.getItemSystem().getLogger().info("Registered new enchantment: " + enchantment.name);
            }
        }else {
            registeredEnchantments.remove(enchantment);
            try {
                Field f = Enchantment.class.getField("byKey");
                Field f2 = Enchantment.class.getField("byName");

                f.setAccessible(true);
                f2.setAccessible(true);

                Map<NamespacedKey, Enchantment> fV = (Map<NamespacedKey, Enchantment>) f.get(null);
                Map<String, Enchantment> f2V = (Map<String, Enchantment>) f.get(null);

                fV.remove(enchantment.key());
                f2V.remove(enchantment.name);

                f.set(null, fV);
                f2.set(null, f2V);
            }catch(Exception ignored) {
            }
            addEnchant(enchantment);
        }
    }
}
