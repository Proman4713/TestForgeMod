package me.proman4713.testforgemod.Blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import me.proman4713.testforgemod.Blocks.custom.ModHorizontalDirectionalBlock;
import me.proman4713.testforgemod.Items.ModItems;
import me.proman4713.testforgemod.TestForgeMod;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TestForgeMod.MOD_ID);

	public static final RegistryObject<Block> HARRY_POTTER_HEAD = registerBlock("harry_potter_head",
			() -> new ModHorizontalDirectionalBlock(BlockBehaviour.Properties.of()
					.setId(BLOCKS.key("harry_potter_head"))
					.strength(2.0F, 3.0F)
					.sound(SoundType.WOOD)));

	public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
		ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ModItems.ITEMS.key(name))));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}