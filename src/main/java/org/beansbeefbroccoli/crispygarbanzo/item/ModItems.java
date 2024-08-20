package org.beansbeefbroccoli.crispygarbanzo.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.beansbeefbroccoli.crispygarbanzo.CrispyGarbanzo;


public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CrispyGarbanzo.MOD_ID/*"minecraft"*/);

    public static final DeferredItem<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
