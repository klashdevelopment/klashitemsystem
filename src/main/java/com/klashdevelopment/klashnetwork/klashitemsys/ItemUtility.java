package com.klashdevelopment.klashnetwork.klashitemsys;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ItemUtility {

    public static void removeAmountOfItemInMainHand(int amount, Player player) {
        player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount()-amount);
    }
    public static void removeOneOfItemInMainHand(Player player) {
        player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount()-1);
    }
    public static void clearItemInMainHand(Player player) {
        player.getInventory().getItemInMainHand().setAmount(0);
    }

    /*
     * See rgb.birdflop.com
     */
    public static String createHexColoredMessage(String message) {
        java.util.regex.Pattern HEX_PATTERN = java.util.regex.Pattern
                .compile("&#([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])");
        return ChatColor.translateAlternateColorCodes('&',
                HEX_PATTERN.matcher((message)).replaceAll("&x&$1&$2&$3&$4&$5&$6"));
    }

}
