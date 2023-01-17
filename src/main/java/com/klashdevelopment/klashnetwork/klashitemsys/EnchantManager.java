package com.klashdevelopment.klashnetwork.klashitemsys;

import org.bukkit.Bukkit;
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
        }
    }
}
