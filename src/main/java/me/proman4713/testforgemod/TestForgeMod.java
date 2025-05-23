package me.proman4713.testforgemod;

import com.mojang.logging.LogUtils;

import me.proman4713.testforgemod.Blocks.ModBlocks;
import me.proman4713.testforgemod.Items.ModCreativeModeTabs;
import me.proman4713.testforgemod.Items.ModItems;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestForgeMod.MOD_ID)
public class TestForgeMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "testforgemod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

	// TODO: To create wands: there will be a phoenix mob, when you shear it or kill it you get a phoenix feather
	// TODO: Elder trees to create Elder Wands, the creation of the Elder Wand will involve the dragon egg to ensure that only one wand can be created

	// .setId(ITEMS.key("wand")).enchantable(0).fireResistant().rarity(Rarity.EPIC).stacksTo(1));

    public TestForgeMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register Mod additions
	    ModCreativeModeTabs.register(modEventBus);

		ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        
    }

	// Add the example block item to the building blocks tab
	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			event.accept(ModItems.STANDARD_OLLIVANDERS_WAND);
		}

		if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			event.accept(ModBlocks.HARRY_POTTER_HEAD);
		}

		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.accept(ModItems.PHOENIX_FEATHER);
		}
	}

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
