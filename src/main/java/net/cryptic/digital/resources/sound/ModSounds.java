package net.cryptic.digital.resources.sound;

import net.cryptic.digital.resources.Main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.MOD_ID);

    public static final RegistryObject<SoundEvent> SIMULATOR_BLOCK_WORKING = registerSoundEvent("simulator_block_working");
    public static final RegistryObject<SoundEvent> SIMULATOR_BLOCK_BOOTING_UP = registerSoundEvent("simulator_block_booting_up");
    public static final RegistryObject<SoundEvent> SIMULATOR_BLOCK_SHUTTING_DOWN = registerSoundEvent("simulator_block_shuttingdown");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENT.register(name, () -> new SoundEvent(new ResourceLocation(Main.MOD_ID,name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENT.register(eventBus);
    }
}
