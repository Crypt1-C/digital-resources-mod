package net.cryptic.digital.resources.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.cryptic.digital.resources.Main;
import net.cryptic.digital.resources.recipe.SimulatorBlockRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;


import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIDigitalResourcesPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Main.MOD_ID,"jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SimulatorBlockRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<SimulatorBlockRecipe> recipes = rm.getAllRecipesFor(SimulatorBlockRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(SimulatorBlockRecipeCategory.UID, SimulatorBlockRecipe.class), recipes);
    }

}
