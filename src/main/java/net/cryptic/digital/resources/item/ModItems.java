package net.cryptic.digital.resources.item;

import net.cryptic.digital.resources.Main;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

    // ingot cards

    public static final RegistryObject<Item> BRONZE_CARD = ITEMS.register("bronze_card",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> COPPER_CARD = ITEMS.register("copper_card",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> EMPTY_CARD = ITEMS.register("empty_card",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> GOLD_CARD = ITEMS.register("gold_card",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> IRON_CARD = ITEMS.register("iron_card",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> LEAD_CARD = ITEMS.register("lead_card",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> NICKEL_CARD = ITEMS.register("nickel_card",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> OSMIUM_CARD = ITEMS.register("osmium_card",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> PLATINUM_CARD = ITEMS.register("platinum_card",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> SILVER_CARD = ITEMS.register("silver_card",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> TIN_CARD = ITEMS.register("tin_card",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> URANIUM_CARD = ITEMS.register("uranium_card",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    // upgrade items

    public static final RegistryObject<Item> EMPTY_UPGRADE = ITEMS.register("empty_upgrade",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> SPEED_UPGRADE = ITEMS.register("speed_upgrade",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> QUANTITY_UPGRADE = ITEMS.register("quantity_upgrade",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
