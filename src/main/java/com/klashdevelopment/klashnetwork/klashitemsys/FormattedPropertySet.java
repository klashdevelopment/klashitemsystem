package com.klashdevelopment.klashnetwork.klashitemsys;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class FormattedPropertySet extends PropertySet {

    protected FormattedPropertySet(PropertySet ps) {
        super();
        this.description = format(ps.description);
        this.name = format(ps.name);
        this.lore = format(ps.lore);
        this.enchantments = ps.enchantments;
        this.material = ps.material;
        this.defaultAmount = ps.defaultAmount;
        this.flags = ps.flags;
        this.cancelClickEvent = ps.cancelClickEvent;
        this.cancelBreakEvent = ps.cancelBreakEvent;
    }
    private FormattedPropertySet(){super();};

    private String format(String s) {
        return ChatColor.translateAlternateColorCodes('&', "&r&f"+s);
    }
    private List<String> format(List<String> s) {
        List newList = new ArrayList();
        for(String str : s) {
            newList.add(format(str));
        }
        return newList;
    }


}
