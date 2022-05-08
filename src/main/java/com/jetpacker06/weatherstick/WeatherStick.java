package com.jetpacker06.weatherstick;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("weatherstick")
public class WeatherStick {
    public static final String MOD_ID = "weatherstick";
    public static final Logger LOGGER = LogManager.getLogger();

    public WeatherStick() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        WeatherStickItem.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}