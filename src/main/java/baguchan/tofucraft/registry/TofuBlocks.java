package baguchan.tofucraft.registry;

import baguchan.tofucraft.TofuCraftReload;
import baguchan.tofucraft.block.KinuTofuBlock;
import baguchan.tofucraft.block.TofuBlock;
import baguchan.tofucraft.block.TofuFluidBlock;
import baguchan.tofucraft.block.crop.SoybeanCropsBlock;
import baguchan.tofucraft.block.crop.SoybeanNetherCropsBlock;
import baguchan.tofucraft.block.crop.SoybeanSoulCropsBlock;
import baguchan.tofucraft.block.utils.SaltPanBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = TofuCraftReload.MODID, bus = EventBusSubscriber.Bus.MOD)
public class TofuBlocks {
	public static final Block SOYMILK = new TofuFluidBlock(TofuFluids.SOYMILK, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noDrops());
	public static final Block SOYMILK_HELL = new TofuFluidBlock(TofuFluids.SOYMILK_HELL, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noDrops());
	public static final Block SOYMILK_SOUL = new TofuFluidBlock(TofuFluids.SOYMILK_SOUL, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noDrops());
	public static final Block BITTERN = new TofuFluidBlock(TofuFluids.BITTERN, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noDrops());

	public static final Block SOYBEAN = new SoybeanCropsBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP));
	public static final Block SOYBEAN_NETHER = new SoybeanNetherCropsBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP));
	public static final Block SOYBEAN_SOUL = new SoybeanSoulCropsBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP));

	public static final Block KINUTOFU = new KinuTofuBlock(BlockBehaviour.Properties.of(TofuMaterial.TOFU).randomTicks().strength(0.1F, 0.2F).sound(SoundType.SNOW));
	public static final Block MOMENTOFU = new TofuBlock(BlockBehaviour.Properties.of(TofuMaterial.TOFU).randomTicks().strength(0.35F, 0.5F).sound(SoundType.SNOW));
	public static final Block ISHITOFU = new TofuBlock(BlockBehaviour.Properties.of(Material.STONE).randomTicks().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE));
	public static final Block METALTOFU = new Block(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL));
	public static final Block DIAMONDTOFU = new Block(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL));


	public static final Block SALTPAN = new SaltPanBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).randomTicks().noOcclusion().sound(SoundType.WOOD));

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> registry) {
		registry.getRegistry().register(SOYMILK.setRegistryName("soymilk"));
		registry.getRegistry().register(SOYMILK_HELL.setRegistryName("soymilk_hell"));
		registry.getRegistry().register(SOYMILK_SOUL.setRegistryName("soymilk_soul"));
		registry.getRegistry().register(BITTERN.setRegistryName("bittern"));
		registry.getRegistry().register(SOYBEAN.setRegistryName("soybean"));
		registry.getRegistry().register(SOYBEAN_NETHER.setRegistryName("soybean_nether"));
		registry.getRegistry().register(SOYBEAN_SOUL.setRegistryName("soybean_soul"));
		registry.getRegistry().register(KINUTOFU.setRegistryName("blocktofukinu"));
		registry.getRegistry().register(MOMENTOFU.setRegistryName("blocktofumomen"));
		registry.getRegistry().register(ISHITOFU.setRegistryName("blocktofuishi"));
		registry.getRegistry().register(METALTOFU.setRegistryName("blocktofumetal"));
		registry.getRegistry().register(DIAMONDTOFU.setRegistryName("blocktofudiamond"));

		registry.getRegistry().register(SALTPAN.setRegistryName("blocksaltpan"));
	}

	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> registry) {
		TofuItems.register(registry, new BlockItem(KINUTOFU, (new Item.Properties()).tab(TofuItemGroup.TOFUCRAFT)));
		TofuItems.register(registry, new BlockItem(MOMENTOFU, (new Item.Properties()).tab(TofuItemGroup.TOFUCRAFT)));
		TofuItems.register(registry, new BlockItem(ISHITOFU, (new Item.Properties()).tab(TofuItemGroup.TOFUCRAFT)));
		TofuItems.register(registry, new BlockItem(METALTOFU, (new Item.Properties()).tab(TofuItemGroup.TOFUCRAFT)));
		TofuItems.register(registry, new BlockItem(DIAMONDTOFU, (new Item.Properties()).tab(TofuItemGroup.TOFUCRAFT)));
	}
}
