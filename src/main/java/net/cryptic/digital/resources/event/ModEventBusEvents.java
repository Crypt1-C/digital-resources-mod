package net.cryptic.digital.resources.event;

import net.cryptic.digital.resources.Main;
import net.cryptic.digital.resources.recipe.SimulatorBlockRecipe;
import net.cryptic.digital.resources.screen.ModMenuTypes;
import net.cryptic.digital.resources.screen.SimulatorBlockScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Main.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, SimulatorBlockRecipe.Type.ID, SimulatorBlockRecipe.Type.INSTANCE);
    }
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        MenuScreens.register(ModMenuTypes.SIMULATOR_BLOCK_MENU.get(), SimulatorBlockScreen::new);

    }

}
