package net.cryptic.digital.resources.block;

import net.cryptic.digital.resources.Main;
import net.cryptic.digital.resources.block.custom.SimulatorBlock;
import net.cryptic.digital.resources.item.ModCreativeModeTab;
import net.cryptic.digital.resources.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BlOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);


    public static final RegistryObject<Block> SIMULATOR_BLOCK = registerBlock("simulator_block",
            () -> new SimulatorBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f)
                    .requiresCorrectToolForDrops()),
            ModCreativeModeTab.DIGITAL_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BlOCKS.register(name,block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.ITEMS.register(name,() -> new BlockItem(block.get(),new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BlOCKS.register(eventBus);
    }
}
