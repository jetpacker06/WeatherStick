package com.jetpacker06.weatherstick;

import net.minecraft.server.commands.WeatherCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(WeatherStick.MOD_ID)
public class WeatherStick {
    public static final String MOD_ID = "weatherstick";
    public static final Logger LOGGER = LogManager.getLogger();

    public WeatherStick() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        WeatherStickItem.register(eventBus);
        eventBus.addListener(this::addToCreativeTabs);
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void addToCreativeTabs(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(WeatherStickItem.WEATHER_STICK);
        }
    }
}