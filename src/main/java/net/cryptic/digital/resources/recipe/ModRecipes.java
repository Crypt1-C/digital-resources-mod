package net.cryptic.digital.resources.recipe;

import net.cryptic.digital.resources.Main;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {

    //public static RecipeType<SimulatorBlockRecipe> DIGITAL_SIMULATING;

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Main.MOD_ID);

    public static final RegistryObject<RecipeSerializer<SimulatorBlockRecipe>> DIGITAL_SIMULATING_SERIALIZER =
            SERIALIZERS.register("digital_simulating",()-> SimulatorBlockRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
