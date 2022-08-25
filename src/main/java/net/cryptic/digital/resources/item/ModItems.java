package net.cryptic.digital.resources.item;

import net.cryptic.digital.resources.Main;
import net.cryptic.digital.resources.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

    // ingot cards

    public static final RegistryObject<Item> ALUMINUM_CARD = ITEMS.register("aluminum_card", () -> new AluminumCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> AMETHYST_CARD = ITEMS.register("amethyst_card", () -> new AmethystCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    //public static final RegistryObject<Item> ANDESITE_ALLOY_CARD = ITEMS.register("andesite_alloy_card", () -> new AndesiteAlloyCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> BRASS_CARD = ITEMS.register("brass_card", () -> new BrassCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> BRONZE_CARD = ITEMS.register("bronze_card", () -> new BronzeCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> CHORUS_CARD = ITEMS.register("chorus_card", () -> new ChorusCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> CLAY_CARD = ITEMS.register("clay_card", () -> new ClayCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> COAL_CARD = ITEMS.register("coal_card", () -> new CoalCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> CONSTANTAN_CARD = ITEMS.register("constantan_card", () -> new ConstantanCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> COPPER_CARD = ITEMS.register("copper_card", () -> new CopperCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> DIAMOND_CARD = ITEMS.register("diamond_card", () -> new DiamondCardItem(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> ELECTRUM_CARD = ITEMS.register("electrum_card", () -> new ElectrumCardItem(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> EMERALD_CARD = ITEMS.register("emerald_card", () -> new EmeraldCardItem(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> EMPTY_CARD = ITEMS.register("empty_card", () -> new EmptyCardItem(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> GLOWSTONE_CARD = ITEMS.register("glowstone_card", () -> new GlowstoneCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> GOLD_CARD = ITEMS.register("gold_card", () -> new GoldCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> IRON_CARD = ITEMS.register("iron_card", () -> new IronCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> LAPIS_CARD = ITEMS.register("lapis_card", () -> new LapisCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> LEAD_CARD = ITEMS.register("lead_card", () -> new LeadCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> NETHER_BRICK_CARD = ITEMS.register("nether_brick_card", () -> new NetherBrickCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> NETHERITE_CARD = ITEMS.register("netherite_card", () -> new NetheriteCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> NETHER_WART_CARD = ITEMS.register("nether_wart_card", () -> new NetherWartCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> NICKEL_CARD = ITEMS.register("nickel_card", () -> new NickelCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> OSMIUM_CARD = ITEMS.register("osmium_card", () -> new OsmiumCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> PLATINUM_CARD = ITEMS.register("platinum_card", () -> new PlatinumCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> QUARTZ_CARD = ITEMS.register("quartz_card", () -> new QuartzCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> REDSTONE_CARD = ITEMS.register("redstone_card", () -> new RedstoneCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> SILVER_CARD = ITEMS.register("silver_card", () -> new SilverCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> STEEL_CARD = ITEMS.register("steel_card", () -> new SteelCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> TIN_CARD = ITEMS.register("tin_card", () -> new TinCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> URANIUM_CARD = ITEMS.register("uranium_card", () -> new UraniumCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> ZINC_CARD = ITEMS.register("zinc_card", () -> new ZincCardItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DIGITAL_TAB)));

    // upgrade items

    public static final RegistryObject<Item> EMPTY_UPGRADE = ITEMS.register("empty_upgrade",
            () -> new EmptyUpgradeItem(new Item.Properties().tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> SPEED_UPGRADE = ITEMS.register("speed_upgrade",
            () -> new SpeedUpgradeItem(new Item.Properties().stacksTo(32).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static final RegistryObject<Item> QUANTITY_UPGRADE = ITEMS.register("quantity_upgrade",
            () -> new QuantityUpgradeItem(new Item.Properties().stacksTo(8).tab(ModCreativeModeTab.DIGITAL_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
