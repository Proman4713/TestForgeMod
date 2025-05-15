package me.proman4713.testforgemod.Items;

import me.proman4713.testforgemod.Items.custom.FuelItem;
import me.proman4713.testforgemod.Items.custom.StandardOllivandersWandItem;
import me.proman4713.testforgemod.TestForgeMod;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
		DeferredRegister.create(ForgeRegistries.ITEMS, TestForgeMod.MOD_ID);

	public static final RegistryObject<Item> STANDARD_OLLIVANDERS_WAND = ITEMS.register("standard_ollivanders_wand", () ->
			new StandardOllivandersWandItem(new Item.Properties()
				.setId(ITEMS.key("standard_ollivanders_wand"))
				.fireResistant()
				.rarity(Rarity.COMMON)
				.durability(100))
	);

	public static final RegistryObject<Item> PHOENIX_FEATHER = ITEMS.register("phoenix_feather", () ->
			new FuelItem(new Item.Properties()
					.setId(ITEMS.key("phoenix_feather"))
					.fireResistant()
					.rarity(Rarity.UNCOMMON), 216000) {
				@Override
				public void appendHoverText(ItemStack pStack, TooltipContext pContext, TooltipDisplay pTooltipDisplay, Consumer<Component> pTooltipAdder, TooltipFlag pFlag) {
					pTooltipAdder.accept(Component.translatable("tooltip.testforgemod.phoenix_feather"));
					super.appendHoverText(pStack, pContext, pTooltipDisplay, pTooltipAdder, pFlag);
				}
			});

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
