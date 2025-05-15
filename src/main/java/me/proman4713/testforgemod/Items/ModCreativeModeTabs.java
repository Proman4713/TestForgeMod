package me.proman4713.testforgemod.Items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import me.proman4713.testforgemod.Blocks.ModBlocks;
import me.proman4713.testforgemod.TestForgeMod;

public class ModCreativeModeTabs {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestForgeMod.MOD_ID);

	public static final RegistryObject<CreativeModeTab> WIZARDING_WORLD_TAB = CREATIVE_MODE_TABS.register("wizarding_world_tab",
			() -> CreativeModeTab.builder()
					.icon(() -> new ItemStack(ModItems.STANDARD_OLLIVANDERS_WAND.get()))
					.title(Component.translatable("creativetab.testforgemod.wizarding_world"))
					.displayItems((pParameters, pOutput) -> {
						pOutput.accept(ModItems.STANDARD_OLLIVANDERS_WAND.get());
						pOutput.accept(ModBlocks.HARRY_POTTER_HEAD.get());
					}).build());

	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
}