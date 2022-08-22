package net.cryptic.digital.resources.block.entity;

import net.cryptic.digital.resources.Main;
import net.cryptic.digital.resources.block.ModBlocks;
import net.cryptic.digital.resources.block.entity.custom.SimulatorBlockBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Main.MOD_ID);

    public static final RegistryObject<BlockEntityType<SimulatorBlockBlockEntity>> SIMULATOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("simulator_block_entity",() -> BlockEntityType.Builder.of(SimulatorBlockBlockEntity::new, ModBlocks.SIMULATOR_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
