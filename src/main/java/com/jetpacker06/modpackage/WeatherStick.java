package com.jetpacker06.modpackage;

import com.jetpacker06.modpackage.register.AllItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("weatherstick")
public class WeatherStick {
    public static final String MOD_ID = "weatherstick";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public WeatherStick() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        AllItems.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
