package net.cryptic.digital.resources.block.entity.custom;

import net.cryptic.digital.resources.block.custom.SimulatorBlock;
import net.cryptic.digital.resources.block.entity.ModBlockEntities;
import net.cryptic.digital.resources.item.ModItems;
import net.cryptic.digital.resources.recipe.SimulatorBlockRecipe;
import net.cryptic.digital.resources.screen.SimulatorBlockMenu;
import net.cryptic.digital.resources.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Optional;

public class SimulatorBlockBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            if (slot==1 || slot == 3) {
                if (stack.getItem() == ModItems.SPEED_UPGRADE.get()) {
                    return true;
                } else if (stack.getItem() == ModItems.QUANTITY_UPGRADE.get()) {
                    return true;
                } else {
                    return false;
                }
            } else if (slot==0) {
                if (stack.getItem() == ModItems.ALUMINUM_CARD.get()
                || stack.getItem() == ModItems.AMETHYST_CARD.get()
                || stack.getItem() == ModItems.AMETHYST_CARD.get()
                || stack.getItem() == ModItems.ANDESITE_ALLOY_CARD.get()
                || stack.getItem() == ModItems.BRASS_CARD.get()
                || stack.getItem() == ModItems.BRONZE_CARD.get()
                || stack.getItem() == ModItems.CHORUS_CARD.get()
                || stack.getItem() == ModItems.CLAY_CARD.get()
                || stack.getItem() == ModItems.COAL_CARD.get()
                || stack.getItem() == ModItems.CONSTANTAN_CARD.get()
                || stack.getItem() == ModItems.COPPER_CARD.get()
                || stack.getItem() == ModItems.DIAMOND_CARD.get()
                || stack.getItem() == ModItems.ELECTRUM_CARD.get()
                || stack.getItem() == ModItems.EMERALD_CARD.get()
                || stack.getItem() == ModItems.GLOWSTONE_CARD.get()
                || stack.getItem() == ModItems.GOLD_CARD.get()
                || stack.getItem() == ModItems.IRON_CARD.get()
                || stack.getItem() == ModItems.LAPIS_CARD.get()
                || stack.getItem() == ModItems.LEAD_CARD.get()
                || stack.getItem() == ModItems.NETHER_BRICK_CARD.get()
                || stack.getItem() == ModItems.NETHERITE_CARD.get()
                || stack.getItem() == ModItems.NETHER_WART_CARD.get()
                || stack.getItem() == ModItems.NICKEL_CARD.get()
                || stack.getItem() == ModItems.OSMIUM_CARD.get()
                || stack.getItem() == ModItems.PLATINUM_CARD.get()
                || stack.getItem() == ModItems.QUARTZ_CARD.get()
                || stack.getItem() == ModItems.REDSTONE_CARD.get()
                || stack.getItem() == ModItems.SILVER_CARD.get()
                || stack.getItem() == ModItems.STEEL_CARD.get()
                || stack.getItem() == ModItems.TIN_CARD.get()
                || stack.getItem() == ModItems.URANIUM_CARD.get()
                || stack.getItem() == ModItems.ZINC_CARD.get()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;

    private int speed = 1;
    private int maxProgress = 20*60*2; // 2 minutes

    public SimulatorBlockBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.SIMULATOR_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0: return SimulatorBlockBlockEntity.this.progress;
                    case 1: return SimulatorBlockBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: SimulatorBlockBlockEntity.this.progress = value; break;
                    case 1: SimulatorBlockBlockEntity.this.maxProgress = value; break;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }



    @Override
    public Component getDisplayName() {
        return new TextComponent(" ");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new SimulatorBlockMenu(pContainerId,pPlayerInventory,this,this.data);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("simulator_block.progress",progress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("simulator_block.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }


    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, SimulatorBlockBlockEntity pBlockEntity) {
        int isPlaying = 0;
        if(hasRecipe(pBlockEntity)) {
            pLevel.setBlock(pPos,pState.setValue(SimulatorBlock.WORKING,true),3);
            if (pBlockEntity.itemHandler.getStackInSlot(1).getItem() == ModItems.SPEED_UPGRADE.get()) {
                pBlockEntity.speed = pBlockEntity.itemHandler.getStackInSlot(1).getCount() * 2;
            } else if(pBlockEntity.itemHandler.getStackInSlot(3).getItem() == ModItems.SPEED_UPGRADE.get()) {
                pBlockEntity.speed = pBlockEntity.itemHandler.getStackInSlot(3).getCount() * 2;
            }else if (pBlockEntity.itemHandler.getStackInSlot(1).getItem() == ModItems.SPEED_UPGRADE.get() && pBlockEntity.itemHandler.getStackInSlot(3).getItem() == ModItems.SPEED_UPGRADE.get()){
                pBlockEntity.speed = (pBlockEntity.itemHandler.getStackInSlot(1).getCount()+pBlockEntity.itemHandler.getStackInSlot(3).getCount())*2;
            } else {
                pBlockEntity.speed = 1;
            }
            pBlockEntity.progress = pBlockEntity.progress + pBlockEntity.speed;
            setChanged(pLevel, pPos, pState);
            if(pBlockEntity.progress > pBlockEntity.maxProgress) {
                craftItem(pBlockEntity);
            }
        } else {


            pLevel.setBlock(pPos,pState.setValue(SimulatorBlock.WORKING,false),3);
            //pLevel.playLocalSound(pPos.getX(),pPos.getY(),pPos.getZ(),ModSounds.SIMULATOR_BLOCK_SHUTTING_DOWN.get(),SoundSource.BLOCKS,1f,1f,false);
            pBlockEntity.resetProgress();

            setChanged(pLevel, pPos, pState);

        }
    }

    private static boolean hasRecipe(SimulatorBlockBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<SimulatorBlockRecipe> match = level.getRecipeManager().getRecipeFor(SimulatorBlockRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent()
                && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem());
    }

    private static void craftItem(SimulatorBlockBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<SimulatorBlockRecipe> match = level.getRecipeManager().getRecipeFor(SimulatorBlockRecipe.Type.INSTANCE, inventory, level);



        if(match.isPresent()) {
            // quantity upgrade
            // slot 1
            if (entity.itemHandler.getStackInSlot(1).getItem() == ModItems.QUANTITY_UPGRADE.get()) {
                entity.itemHandler.setStackInSlot(2, new ItemStack(match.get().getResultItem().getItem(),
                        entity.itemHandler.getStackInSlot(2).getCount() + entity.itemHandler.getStackInSlot(1).getCount() * 2));

                entity.resetProgress();
            //slot 2
            } else if (entity.itemHandler.getStackInSlot(3).getItem() == ModItems.QUANTITY_UPGRADE.get()) {
                entity.itemHandler.setStackInSlot(2, new ItemStack(match.get().getResultItem().getItem(),
                        entity.itemHandler.getStackInSlot(2).getCount() + entity.itemHandler.getStackInSlot(3).getCount() * 2));

                entity.resetProgress();
            //both slots are Quantity upgrades
            } else if (entity.itemHandler.getStackInSlot(3).getItem() == ModItems.QUANTITY_UPGRADE.get() && entity.itemHandler.getStackInSlot(1).getItem() == ModItems.QUANTITY_UPGRADE.get()) {
                // check if the 1st slot contains more upgrades then the 2nd slot
                if (entity.itemHandler.getStackInSlot(1).getCount() >= entity.itemHandler.getStackInSlot(3).getCount()) {
                    entity.itemHandler.setStackInSlot(2, new ItemStack(match.get().getResultItem().getItem(),
                            entity.itemHandler.getStackInSlot(2).getCount() +
                                    entity.itemHandler.getStackInSlot(1).getCount() * 2));
                    entity.resetProgress();
                } else {
                    entity.itemHandler.setStackInSlot(2, new ItemStack(match.get().getResultItem().getItem(),
                            entity.itemHandler.getStackInSlot(2).getCount() +
                                    entity.itemHandler.getStackInSlot(3).getCount() * 2));
                    entity.resetProgress();
                }
            //no Quantity Upgrades - invalid upgrades
            } else {
                entity.itemHandler.setStackInSlot(2, new ItemStack(match.get().getResultItem().getItem(),
                        entity.itemHandler.getStackInSlot(2).getCount() + 1));

                entity.resetProgress();
            }

        }

    }

    private void resetProgress() {
        this.progress = 0;

    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(2).getItem() == output.getItem() || inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
}
