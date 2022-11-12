package com.klashdevelopment.klashnetwork.klashitemsys;

import com.destroystokyo.paper.Namespaced;
import com.destroystokyo.paper.NamespacedTag;
import com.klashdevelopment.sysomander.sysomand.Sysomander;
import com.samjakob.spigui.SpiGUI;
//import net.dv8tion.jda.api.JDA;
//import net.dv8tion.jda.api.JDABuilder;
//import net.dv8tion.jda.api.events.GenericEvent;
//import net.dv8tion.jda.api.hooks.EventListener;
//import net.dv8tion.jda.api.hooks.ListenerAdapter;
//import net.dv8tion.jda.api.JDA;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

public final class KlashItemSys extends JavaPlugin implements Listener {

    public ItemList items = new ItemList();

    public Sysomander sys;
    public SpiGUI gui;

    @Override
    public void onEnable() {
        sys = new Sysomander(this);
        gui = new SpiGUI(this);

        items.add(new TestItem(), "klashitemsys");

        // Add sysomands
        sys.addSysomandToServer(new ItemListCmd());
        getServer().getPluginManager().registerEvents(this, this);
    }

    public static void registerItem(Item item) {
        getPlugin(KlashItemSys.class).items.add(item);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent ev) {
        ItemStack stack = ev.getItem();
        if (stack == null || stack.getType() == Material.AIR) return;
        for (Item item : items) {
            for (Namespaced v : stack.getItemMeta().getPlaceableKeys()) {
                if (v.getKey().equals(item.getPropertySet().id)) {
                    if (item.getPropertySet().cancelClickEvent) {
                        ev.setCancelled(true);
                    }
                    item.rightClick(ev);
                }
            }
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        ItemStack stack = event.getPlayer().getInventory().getItemInMainHand();
        if(stack.getType() == Material.AIR) return;
        for(Item item : items) {
            for(Namespaced v : stack.getItemMeta().getPlaceableKeys()) {
                if (v.getKey().equals(item.getPropertySet().id)) {
                    if (item.getPropertySet().cancelBreakEvent) {
                        event.setCancelled(true);
                    }
                    item.blockBreak(event);
                }
            }
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return sys.runCommandSystem(sender, label, args);
    }
}
