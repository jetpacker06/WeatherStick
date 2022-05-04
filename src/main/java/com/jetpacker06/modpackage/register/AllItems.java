package com.jetpacker06.modpackage.register;

import com.jetpacker06.modpackage.WeatherStick;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WeatherStick.MOD_ID);
    //begin items
    public static final RegistryObject<Item> WEATHER_STICK = ITEMS.register("weather_stick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    //end items
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}