package com.klashdevelopment.klashnetwork.klashitemsys;

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
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class KlashItemSys extends JavaPlugin implements Listener {

    void debug(CharSequence sqnc){
        System.out.println(String.format("[klsh-dbg]:-: %s", sqnc));
    }
    public ItemList items = new ItemList();

    public Sysomander sys;
    public SpiGUI gui;

    @Override
    public void onEnable() {
        sys = new Sysomander(this);
        gui = new SpiGUI(this);

        items.add(new TestItem());

        // Add sysomands
        sys.addSysomandToServer(new ItemListCmd());
        getServer().getPluginManager().registerEvents(this, this);
    }

    public static void registerItem(Item item) {
        KlashItemSys.getPlugin(KlashItemSys.class).items.add(item);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent ev) {
        ItemStack stack = ev.getItem();
        if (stack == null || stack.getType() == Material.AIR) return;
        for (Item item : items) {
            if(stack.getType() == item.getPropertySet().material) {
                if(stack.getItemMeta().hasLore()) {
                    if(stack.getItemMeta().hasDisplayName()) {
                        if(ChatColor.stripColor(stack.getItemMeta().getDisplayName()).contains(ChatColor.stripColor(item.getPropertySet().name))) {
                            if (item.getPropertySet().cancelClickEvent) {
                                ev.setCancelled(true);
                            }
                            item.itemInteract(ev);
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent ev) {
        ItemStack stack = ev.getPlayer().getInventory().getItemInMainHand();
        if (stack == null || stack.getType() == Material.AIR) return;
        for (Item item : items) {
            if(stack.getType() == item.getPropertySet().material) {
                if(stack.getItemMeta().hasLore()) {
                    if(stack.getItemMeta().hasDisplayName()) {
                        if(ChatColor.stripColor(stack.getItemMeta().getDisplayName()).contains(ChatColor.stripColor(item.getPropertySet().name))) {
                            if (item.getPropertySet().cancelClickEvent) {
                                ev.setCancelled(true);
                            }
                            item.blockBreak(ev);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return sys.runCommandSystem(sender, label, args);
    }
}
