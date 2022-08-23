package net.cryptic.digital.resources;

import com.mojang.logging.LogUtils;
import net.cryptic.digital.resources.block.ModBlocks;
import net.cryptic.digital.resources.block.entity.ModBlockEntities;
import net.cryptic.digital.resources.item.ModItems;
import net.cryptic.digital.resources.recipe.ModRecipes;
import net.cryptic.digital.resources.screen.ModMenuTypes;
import net.cryptic.digital.resources.sound.ModSounds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "digital_resources";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Main() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModSounds.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }



    public void setup(final FMLCommonSetupEvent event) {

        //ModRecipes.DIGITAL_SIMULATING = RecipeType.register("digital_simulating");

    }

}
