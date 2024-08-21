package org.beansbeefbroccoli.crispy_garbanzo;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.beansbeefbroccoli.crispy_garbanzo.block.ModBlocks;
import org.beansbeefbroccoli.crispy_garbanzo.item.ModCreativeModeTabs;
import org.beansbeefbroccoli.crispy_garbanzo.item.ModItems;
import org.slf4j.Logger;

@Mod(CrispyGarbanzo.MOD_ID)
public class CrispyGarbanzo {
    public static final String MOD_ID = "crispy_garbanzo";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CrispyGarbanzo(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_TUNGSTEN);
            event.accept(ModItems.RAW_BISMUTH);
            event.accept(ModItems.TUNGSTEN_NUGGET);
            event.accept(ModItems.BISMUTH_NUGGET);
            event.accept(ModItems.TUNGSTEN_INGOT);
            event.accept(ModItems.BISMUTH_INGOT);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.TUNGSTEN_BLOCK);
            event.accept(ModBlocks.BISMUTH_BLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.TUNGSTEN_ORE);
            event.accept(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
            event.accept(ModBlocks.BISMUTH_ORE);
            event.accept(ModBlocks.DEEPSLATE_BISMUTH_ORE);
            event.accept(ModBlocks.RAW_TUNGSTEN_BLOCK);
            event.accept(ModBlocks.RAW_BISMUTH_BLOCK);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
