package baguchan.tofucraft.world.gen.features;

import baguchan.tofucraft.TofuCraftReload;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;

import java.util.List;

public class ModVegetationFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> TOFU_TREES = registerKey("tofu_trees");

	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, TofuCraftReload.prefix(name));
	}

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

		Holder<ConfiguredFeature<?, ?>> holder1 = holdergetter.getOrThrow(ModTreeFeatures.TOFU_TREE);
		Holder<ConfiguredFeature<?, ?>> holder2 = holdergetter.getOrThrow(ModTreeFeatures.TOFU_TREE_BIG);
		FeatureUtils.register(context, TOFU_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(holder2), 0.33333334F)), PlacementUtils.inlinePlaced(holder1)));
	}
}
