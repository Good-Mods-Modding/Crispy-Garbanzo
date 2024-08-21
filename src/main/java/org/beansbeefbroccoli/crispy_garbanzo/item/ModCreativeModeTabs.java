package org.beansbeefbroccoli.crispy_garbanzo.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.beansbeefbroccoli.crispy_garbanzo.CrispyGarbanzo;
import org.beansbeefbroccoli.crispy_garbanzo.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrispyGarbanzo.MOD_ID);

    public static final Supplier<CreativeModeTab> CRISPY_GARBANZO = CREATIVE_MODE_TAB.register("crispy_garbanzo", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TUNGSTEN_INGOT.get())).title(Component.translatable("itemGroup.crispy_garbanzo")).displayItems((itemDisplayParameters, output) -> {
        output.accept(ModItems.RAW_TUNGSTEN);
        output.accept(ModItems.RAW_BISMUTH);
        output.accept(ModItems.TUNGSTEN_NUGGET);
        output.accept(ModItems.BISMUTH_NUGGET);
        output.accept(ModItems.TUNGSTEN_INGOT);
        output.accept(ModItems.BISMUTH_INGOT);
        output.accept(ModBlocks.TUNGSTEN_BLOCK);
        output.accept(ModBlocks.BISMUTH_BLOCK);
        output.accept(ModBlocks.TUNGSTEN_ORE);
        output.accept(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
        output.accept(ModBlocks.BISMUTH_ORE);
        output.accept(ModBlocks.DEEPSLATE_BISMUTH_ORE);
        output.accept(ModBlocks.DEEPSLATE_BISMUTH_ORE);
        output.accept(ModBlocks.RAW_TUNGSTEN_BLOCK);
        output.accept(ModBlocks.RAW_BISMUTH_BLOCK);
    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
