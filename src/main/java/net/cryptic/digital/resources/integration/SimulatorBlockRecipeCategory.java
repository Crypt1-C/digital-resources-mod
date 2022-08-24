package net.cryptic.digital.resources.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.cryptic.digital.resources.Main;
import net.cryptic.digital.resources.block.ModBlocks;
import net.cryptic.digital.resources.recipe.SimulatorBlockRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class SimulatorBlockRecipeCategory implements IRecipeCategory<SimulatorBlockRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Main.MOD_ID, "digital_simulating");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Main.MOD_ID, "textures/gui/simulator_block_gui_jei.png");

    private final IDrawable background;
    private final IDrawable icon;

    public SimulatorBlockRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 82);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SIMULATOR_BLOCK.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends SimulatorBlockRecipe> getRecipeClass() {
        return SimulatorBlockRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Digital Simulating");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull SimulatorBlockRecipe recipe, @Nonnull IFocusGroup focusGroup) {

        builder.addSlot(RecipeIngredientRole.INPUT, 8, 7).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 152, 57).addItemStack(recipe.getResultItem());
    }
}
