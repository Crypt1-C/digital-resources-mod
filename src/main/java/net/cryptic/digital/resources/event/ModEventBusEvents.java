package net.cryptic.digital.resources.event;

import net.cryptic.digital.resources.Main;
import net.cryptic.digital.resources.recipe.SimulatorBlockRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, SimulatorBlockRecipe.Type.ID, SimulatorBlockRecipe.Type.INSTANCE);
    }
}
