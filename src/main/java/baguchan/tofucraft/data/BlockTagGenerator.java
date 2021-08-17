package baguchan.tofucraft.data;

import baguchan.tofucraft.TofuCraftReload;
import baguchan.tofucraft.registry.TofuBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagGenerator extends BlockTagsProvider {
	public BlockTagGenerator(DataGenerator generator, ExistingFileHelper exFileHelper) {
		super(generator, TofuCraftReload.MODID, exFileHelper);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addTags() {
		tag(BlockTags.MINEABLE_WITH_SHOVEL)
				.add(TofuBlocks.KINUTOFU, TofuBlocks.MOMENTOFU);
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(TofuBlocks.ISHITOFU, TofuBlocks.METALTOFU, TofuBlocks.DIAMONDTOFU);

		tag(BlockTags.NEEDS_STONE_TOOL)
				.add(TofuBlocks.METALTOFU);
		tag(BlockTags.NEEDS_IRON_TOOL)
				.add(TofuBlocks.DIAMONDTOFU);
	}
}