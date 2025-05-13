package me.proman4713.testforgemod.Items;

import me.proman4713.testforgemod.TestForgeMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
		DeferredRegister.create(ForgeRegistries.ITEMS, TestForgeMod.MOD_ID);

	public static final RegistryObject<Item> WAND = ITEMS.register("wand", () -> {
		return new Item(new Item.Properties()
				.setId(ITEMS.key("wand"))
				.fireResistant()
				.rarity(Rarity.EPIC)
				.stacksTo(1)
				.durability(10));
	});

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
