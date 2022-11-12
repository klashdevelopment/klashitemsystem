package com.klashdevelopment.klashnetwork.klashitemsys;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ComponentUtils {
    public static List<TextComponent> textFromStringList(List<String> list) {
        List<TextComponent> components = new ArrayList<>();
        for (String s : list) {
            components.add(Component.text(s));
        }
        return components;
    }
    public static List<TextComponent> formatFromStringList(List<String> list) {
        List<TextComponent> components = new ArrayList<>();
        for (String s : list) {
            components.add(ComponentUtils.format(s));
        }
        return components;
    }
    public static TextComponent format(final @NotNull String content) {
        return Component.text(ChatColor.translateAlternateColorCodes('&', content));
    }
}
