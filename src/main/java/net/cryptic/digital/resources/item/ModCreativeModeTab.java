package net.cryptic.digital.resources.item;

import net.cryptic.digital.resources.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab DIGITAL_TAB = new CreativeModeTab("digital_resources") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.SIMULATOR_BLOCK.get());
        }
    };
}
