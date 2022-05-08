package com.jetpacker06.weatherstick;

import net.minecraft.server.commands.WeatherCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
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
    public static class WeatherStickItem extends Item {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WeatherStick.MOD_ID);
        public static final RegistryObject<Item> WEATHER_STICK = ITEMS.register("weather_stick", () -> new WeatherStick.WeatherStickItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));
        //end registering
        public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
        }
        public WeatherStickItem(Properties pProperties) {
            super(pProperties);
        }

        @Override
        public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
            WeatherStick.LOGGER.info("Used");WeatherStick.LOGGER.info(pLevel.getClass());
            if (pLevel instanceof ServerLevel) {
                if (pLevel.getLevelData().isRaining()) {
                    WeatherCommand.setClear(pPlayer.createCommandSourceStack().withLevel((ServerLevel) pLevel), 6000);
                } else {
                    WeatherCommand.setRain(pPlayer.createCommandSourceStack().withLevel((ServerLevel) pLevel), 6000);
                }
            }
            return super.use(pLevel, pPlayer, pUsedHand);
        }}
}