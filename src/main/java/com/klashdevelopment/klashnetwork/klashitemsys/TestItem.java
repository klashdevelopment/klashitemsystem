package com.klashdevelopment.klashnetwork.klashitemsys;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class TestItem implements Item {
    @Override
    public FormattedPropertySet getPropertySet() {
        return PropertySet.builder().setDescription("This is a test item! Please do not use in production.").build().format();
    }

    @Override
    public void rightClick(PlayerInteractEvent ev) {
        ev.getPlayer().sendMessage("Right Click has been called on Test Item!");
    }

    @Override
    public void blockBreak(BlockBreakEvent ev) {
        ev.getPlayer().sendMessage("BlockBreak has been called on Test Item!");
    }
}
