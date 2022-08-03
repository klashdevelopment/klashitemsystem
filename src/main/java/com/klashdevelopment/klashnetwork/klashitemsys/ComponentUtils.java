package com.klashdevelopment.klashnetwork.klashitemsys;

import net.kyori.adventure.text.Component;

import java.util.ArrayList;
import java.util.List;

public class ComponentUtils {
    public static List<Component> fromStringList(List<String> list) {
        List<Component> components = new ArrayList<>();
        for (String s : list) {
            components.add(Component.text(s));
        }
        return components;
    }
}
