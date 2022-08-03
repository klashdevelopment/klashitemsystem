package com.klashdevelopment.klashnetwork.klashitemsys;

import com.klashdevelopment.sysomander.sysomand.Sysomand;
import com.klashdevelopment.sysomander.sysomand.SysomandPermission;
import com.samjakob.spigui.SGMenu;
import com.samjakob.spigui.buttons.SGButton;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemListCmd implements Sysomand {

    @Override
    public String getName() {
        return "itemlist";
    }

    @Override
    public SysomandPermission getPermission() {
        return new SysomandPermission("klashitemsys.listcommand");
    }

    @Override
    public void execute(CommandSender sender, String[] args, boolean isPlayer) {
        Player p = (Player) sender;
        SGMenu menu = KlashItemSys.getPlugin(KlashItemSys.class).gui.create("Item List", 4);
        for(Item item : KlashItemSys.getPlugin(KlashItemSys.class).items) {
            menu.addButton(new SGButton(Factory.createItem(item)).withListener(e -> {
                p.getInventory().addItem(Factory.createItem(item));
            }));
        }
        p.openInventory(menu.getInventory());
    }

}
