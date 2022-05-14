package baguchan.tofucraft.registry;

import baguchan.tofucraft.item.*;
import baguchan.tofucraft.utils.RecipeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static baguchan.tofucraft.TofuCraftReload.MODID;

public class TofuItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

	public static final RegistryObject<Item> TOFUKINU = ITEMS.register("tofukinu", () -> new Item((new Item.Properties()).food(TofuFoods.TOFU).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUMOMEN = ITEMS.register("tofumomen", () -> new Item((new Item.Properties()).food(TofuFoods.TOFU).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUISHI = ITEMS.register("tofuishi", () -> new Item((new Item.Properties()).food(TofuFoods.ISHITOFU).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUMETAL = ITEMS.register("tofumetal", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUDIAMOND = ITEMS.register("tofudiamond", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUDIAMOND_NUGGET = ITEMS.register("tofudiamondnugget", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUHELL = ITEMS.register("tofuhell", () -> new Item((new Item.Properties()).food(TofuFoods.TOFUHELL).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUSOUL = ITEMS.register("tofusoul", () -> new Item((new Item.Properties()).food(TofuFoods.TOFUSOUL).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUGRILLED = ITEMS.register("tofugrilled", () -> new Item((new Item.Properties()).food(TofuFoods.TOFUGRILLED).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUZUNDA = ITEMS.register("tofuzunda", () -> new Item((new Item.Properties()).food(TofuFoods.TOFUZUNDA).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUMISO = ITEMS.register("tofumiso", () -> new Item((new Item.Properties()).food(TofuFoods.TOFUMISO).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUDRIED = ITEMS.register("tofudried", () -> new Item((new Item.Properties()).food(TofuFoods.TOFUDRIED).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> BITTERN_BOTTLE = ITEMS.register("bittern_bottle", () -> new BitternItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SEEDS_SOYBEANS = ITEMS.register("seeds_soybeans", () -> new ItemNameBlockItem(TofuBlocks.SOYBEAN.get(), (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SEEDS_SOYBEANS_NETHER = ITEMS.register("seeds_soybeans_nether", () -> new ItemNameBlockItem(TofuBlocks.SOYBEAN_NETHER.get(), (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SEEDS_SOYBEANS_SOUL = ITEMS.register("seeds_soybeans_soul", () -> new ItemNameBlockItem(TofuBlocks.SOYBEAN_SOUL.get(), (new Item.Properties()).rarity(Rarity.UNCOMMON).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SOYBEAN_PARCHED = ITEMS.register("soybeans_parched", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> KINAKO = ITEMS.register("kinako", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> EDAMAME = ITEMS.register("edamame", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> BOILED_EDAMAME = ITEMS.register("edamame_boild", () -> new Item((new Item.Properties()).food(TofuFoods.BOILED_EDAMAME).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> KOUJI_BASE = ITEMS.register("koujibase", () -> new KoujiBaseItem((new Item.Properties()).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> KOUJI = ITEMS.register("kouji", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> MISO = ITEMS.register("miso", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> BOTTLE_SOYSAUSE = ITEMS.register("bottle_soysause", () -> new Item((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> LEEK = ITEMS.register("leek", () -> new ItemNameBlockItem(TofuBlocks.LEEK_CROP.get(), (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> YUBA = ITEMS.register("yuba", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ZUNDA = ITEMS.register("zunda", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ZUNDAMA = ITEMS.register("zundama", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ZUNDARUBY = ITEMS.register("zundaruby", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_HAMBURG_RAW = ITEMS.register("tofuhamburg_raw", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_HAMBURG = ITEMS.register("tofuhamburg", () -> new Item((new Item.Properties()).food(TofuFoods.TOFU_HAMBURG).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> RAW_TOFU_FISH = ITEMS.register("raw_tofufish", () -> new Item((new Item.Properties()).food(TofuFoods.RAW_TOFUFISH).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> COOKED_TOFU_FISH = ITEMS.register("cooked_tofufish", () -> new Item((new Item.Properties()).food(TofuFoods.COOKED_TOFUFISH).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUCOOKIE = ITEMS.register("tofucookie", () -> new Item((new Item.Properties()).food(TofuFoods.TOFUCOOKIE).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SOYSTICK = ITEMS.register("soystick", () -> new Item((new Item.Properties()).food(TofuFoods.SOYSTICK).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SALTYMELON = ITEMS.register("saltymelon", () -> new Item((new Item.Properties()).food(TofuFoods.SALTYMELON).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> SOYMILK = ITEMS.register("soymilk", () -> new SoymilkBottleItem(MobEffects.REGENERATION, MobEffects.HEALTH_BOOST, (new Item.Properties()).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SOYMILK_APPLE = ITEMS.register("soymilk_apple", () -> new SoymilkBottleItem(MobEffects.DAMAGE_RESISTANCE, MobEffects.ABSORPTION, (new Item.Properties()).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SOYMILK_COCOA = ITEMS.register("soymilk_cocoa", () -> new SoymilkBottleItem(MobEffects.JUMP, MobEffects.MOVEMENT_SPEED, (new Item.Properties()).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SOYMILK_KINAKO = ITEMS.register("soymilk_kinako", () -> new SoymilkBottleItem(MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED, (new Item.Properties()).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SOYMILK_PUDDING = ITEMS.register("soymilk_pudding", () -> new SoymilkBottleItem(MobEffects.REGENERATION, MobEffects.HEALTH_BOOST, (new Item.Properties()).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SOYMILK_PUMPKIN = ITEMS.register("soymilk_pumpkin", () -> new SoymilkBottleItem(MobEffects.DAMAGE_BOOST, MobEffects.DIG_SPEED, (new Item.Properties()).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> KINAKO_MANJU = ITEMS.register("kinakomanju", () -> new Item((new Item.Properties()).food(TofuFoods.KINAKO_MANJU).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ZUNDA_MANJU = ITEMS.register("zundamanju", () -> new Item((new Item.Properties()).food(TofuFoods.ZUNDA_MANJU).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> NETHER_MANJU = ITEMS.register("nethermanju", () -> new Item((new Item.Properties()).food(TofuFoods.NETHER_MANJU).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SOUL_MANJU = ITEMS.register("soulmanju", () -> new Item((new Item.Properties()).food(TofuFoods.SOUL_MANJU).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ZUNDA_MOCHI = ITEMS.register("zunda_mochi", () -> new Item((new Item.Properties()).food(TofuFoods.ZUNDA_MOCHI).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> KINAKO_MOCHI = ITEMS.register("kinako_mochi", () -> new Item((new Item.Properties()).food(TofuFoods.KINAKO_MOCHI).tab(TofuCreativeModeTab.TOFUCRAFT)));


	public static final RegistryObject<Item> SOY_CHOCOLATE = ITEMS.register("soy_chocolate", () -> new Item((new Item.Properties()).food(TofuFoods.SOY_CHOCOLATE).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUNIAN_SOY_CHOCOLATE = ITEMS.register("tofunian_soy_chocolate", () -> new Item((new Item.Properties()).food(TofuFoods.SOY_CHOCOLATE).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> BUCKET_SOYMILK = ITEMS.register("bucket_soymilk", () -> new BucketItem(TofuFluids.SOYMILK, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> BUCKET_SOYMILK_NETHER = ITEMS.register("bucket_soymilk_nether", () -> new BucketItem(TofuFluids.SOYMILK_HELL, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> BUCKET_SOYMILK_SOUL = ITEMS.register("bucket_soymilk_soul", () -> new BucketItem(TofuFluids.SOYMILK_SOUL, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUFISH_BUCKET = ITEMS.register("tofufish_bucket", () -> new MobBucketItem(TofuEntityTypes.TOFUFISH, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUFISH_SOYMILK_BUCKET = ITEMS.register("tofufish_soymilk_bucket", () -> new MobBucketItem(TofuEntityTypes.TOFUFISH, () -> TofuFluids.SOYMILK.get(), () -> SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> BUCKET_BITTERN = ITEMS.register("bucket_bittern", () -> new BucketItem(TofuFluids.BITTERN, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> TOFU_KINU_SWORD = ITEMS.register("tofu_kinu_sword", () -> new SwordItem(TofuItemTier.KINU, 0, -2.2F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_KINU_AXE = ITEMS.register("tofu_kinu_axe", () -> new AxeItem(TofuItemTier.KINU, 0.0F, -2.25F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_KINU_PICKAXE = ITEMS.register("tofu_kinu_pickaxe", () -> new PickaxeItem(TofuItemTier.KINU, 0, -2.2F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_KINU_SHOVEL = ITEMS.register("tofu_kinu_shovel", () -> new ShovelItem(TofuItemTier.KINU, 0.0F, -2.2F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> TOFU_MOMEN_SWORD = ITEMS.register("tofu_momen_sword", () -> new SwordItem(TofuItemTier.MOMEN, 0, -2.2F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_MOMEN_AXE = ITEMS.register("tofu_momen_axe", () -> new AxeItem(TofuItemTier.MOMEN, 1.0F, -2.5F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_MOMEN_PICKAXE = ITEMS.register("tofu_momen_pickaxe", () -> new PickaxeItem(TofuItemTier.MOMEN, 0, -2.25F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_MOMEN_SHOVEL = ITEMS.register("tofu_momen_shovel", () -> new ShovelItem(TofuItemTier.MOMEN, 0.0F, -2.25F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> TOFU_SOLID_SWORD = ITEMS.register("tofu_solid_sword", () -> new SwordItem(TofuItemTier.SOLID, 3, -2.3F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_SOLID_AXE = ITEMS.register("tofu_solid_axe", () -> new AxeItem(TofuItemTier.SOLID, 6.0F, -2.9F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_SOLID_PICKAXE = ITEMS.register("tofu_solid_pickaxe", () -> new PickaxeItem(TofuItemTier.SOLID, 1, -2.7F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_SOLID_SHOVEL = ITEMS.register("tofu_solid_shovel", () -> new ShovelItem(TofuItemTier.SOLID, 1.5F, -2.9F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> TOFU_METAL_SWORD = ITEMS.register("tofu_metal_sword", () -> new SwordItem(TofuItemTier.METAL, 3, -2.3F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_METAL_AXE = ITEMS.register("tofu_metal_axe", () -> new AxeItem(TofuItemTier.METAL, 5.0F, -3.1F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_METAL_PICKAXE = ITEMS.register("tofu_metal_pickaxe", () -> new PickaxeItem(TofuItemTier.METAL, 1, -2.7F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_METAL_SHOVEL = ITEMS.register("tofu_metal_shovel", () -> new ShovelItem(TofuItemTier.METAL, 1.5F, -2.9F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> TOFU_DIAMOND_SWORD = ITEMS.register("tofu_diamond_sword", () -> new SwordItem(TofuItemTier.TOFUDIAMOND, 3, -2.4F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_DIAMOND_AXE = ITEMS.register("tofu_diamond_axe", () -> new AxeItem(TofuItemTier.TOFUDIAMOND, 5.0F, -3.2F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_DIAMOND_PICKAXE = ITEMS.register("tofu_diamond_pickaxe", () -> new PickaxeItem(TofuItemTier.TOFUDIAMOND, 1, -2.8F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFU_DIAMOND_SHOVEL = ITEMS.register("tofu_diamond_shovel", () -> new ShovelItem(TofuItemTier.TOFUDIAMOND, 1.5F, -3.0F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> ARMOR_TOFU_KINUHELMET = ITEMS.register("tofu_kinu_helmet", () -> new ArmorItem(TofuArmorMaterial.KINU, EquipmentSlot.HEAD, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_KINUCHESTPLATE = ITEMS.register("tofu_kinu_chestplate", () -> new ArmorItem(TofuArmorMaterial.KINU, EquipmentSlot.CHEST, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_KINULEGGINGS = ITEMS.register("tofu_kinu_leggings", () -> new ArmorItem(TofuArmorMaterial.KINU, EquipmentSlot.LEGS, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_KINUBOOTS = ITEMS.register("tofu_kinu_boots", () -> new ArmorItem(TofuArmorMaterial.KINU, EquipmentSlot.FEET, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> ARMOR_TOFU_MOMENHELMET = ITEMS.register("tofu_momen_helmet", () -> new ArmorItem(TofuArmorMaterial.MOMEN, EquipmentSlot.HEAD, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_MOMENCHESTPLATE = ITEMS.register("tofu_momen_chestplate", () -> new ArmorItem(TofuArmorMaterial.MOMEN, EquipmentSlot.CHEST, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_MOMENLEGGINGS = ITEMS.register("tofu_momen_leggings", () -> new ArmorItem(TofuArmorMaterial.MOMEN, EquipmentSlot.LEGS, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_MOMENBOOTS = ITEMS.register("tofu_momen_boots", () -> new ArmorItem(TofuArmorMaterial.MOMEN, EquipmentSlot.FEET, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> ARMOR_TOFU_SOLIDHELMET = ITEMS.register("tofu_solid_helmet", () -> new ArmorItem(TofuArmorMaterial.SOLID, EquipmentSlot.HEAD, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_SOLIDCHESTPLATE = ITEMS.register("tofu_solid_chestplate", () -> new ArmorItem(TofuArmorMaterial.SOLID, EquipmentSlot.CHEST, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_SOLIDLEGGINGS = ITEMS.register("tofu_solid_leggings", () -> new ArmorItem(TofuArmorMaterial.SOLID, EquipmentSlot.LEGS, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_SOLIDBOOTS = ITEMS.register("tofu_solid_boots", () -> new ArmorItem(TofuArmorMaterial.SOLID, EquipmentSlot.FEET, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> ARMOR_TOFU_METALHELMET = ITEMS.register("tofu_metal_helmet", () -> new ArmorItem(TofuArmorMaterial.METAL, EquipmentSlot.HEAD, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_METALCHESTPLATE = ITEMS.register("tofu_metal_chestplate", () -> new ArmorItem(TofuArmorMaterial.METAL, EquipmentSlot.CHEST, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_METALLEGGINGS = ITEMS.register("tofu_metal_leggings", () -> new ArmorItem(TofuArmorMaterial.METAL, EquipmentSlot.LEGS, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_METALBOOTS = ITEMS.register("tofu_metal_boots", () -> new ArmorItem(TofuArmorMaterial.METAL, EquipmentSlot.FEET, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> ARMOR_TOFU_DIAMONDHELMET = ITEMS.register("tofu_diamond_helmet", () -> new ArmorItem(TofuArmorMaterial.DIAMOND, EquipmentSlot.HEAD, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_DIAMONDCHESTPLATE = ITEMS.register("tofu_diamond_chestplate", () -> new ArmorItem(TofuArmorMaterial.DIAMOND, EquipmentSlot.CHEST, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_DIAMONDLEGGINGS = ITEMS.register("tofu_diamond_leggings", () -> new ArmorItem(TofuArmorMaterial.DIAMOND, EquipmentSlot.LEGS, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> ARMOR_TOFU_DIAMONDBOOTS = ITEMS.register("tofu_diamond_boots", () -> new ArmorItem(TofuArmorMaterial.DIAMOND, EquipmentSlot.FEET, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> TOFU_SHIELD = ITEMS.register("tofu_shield", () -> new TofuShieldItem((new Item.Properties()).stacksTo(1).durability(420).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> BUGLE = ITEMS.register("bugle", () -> new BugleItem((new Item.Properties()).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUSCOOP = ITEMS.register("tofuscoop", () -> new TofuScoopItem((new Item.Properties()).stacksTo(1).durability(264).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUSTICK = ITEMS.register("tofustick", () -> new TofuStickItem((new Item.Properties()).stacksTo(1).durability(264).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> FUKUMAME = ITEMS.register("fukumame", () -> new FukumameItem((new Item.Properties()).stacksTo(1).durability(64).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> NETHER_FUKUMAME = ITEMS.register("nether_fukumame", () -> new NetherFukumameItem((new Item.Properties()).stacksTo(1).durability(64).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> SOUL_FUKUMAME = ITEMS.register("soul_fukumame", () -> new SoulFukumameItem((new Item.Properties()).stacksTo(1).durability(64).rarity(Rarity.UNCOMMON).tab(TofuCreativeModeTab.TOFUCRAFT)));

	public static final RegistryObject<Item> TOFUGEM = ITEMS.register("tofugem", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TF_CAPACITOR = ITEMS.register("tf_capacitor", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TF_COIL = ITEMS.register("tf_coil", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TF_CIRCUIT = ITEMS.register("tf_circuit", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TF_OSCILLATOR = ITEMS.register("tf_oscillator", () -> new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));


	public static final RegistryObject<Item> TOFUNIAN_SPAWNEGG = ITEMS.register("tofunian_spawnegg", () -> new ForgeSpawnEggItem(TofuEntityTypes.TOFUNIAN, 15460584, 13291425, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUCOW_SPAWNEGG = ITEMS.register("tofucow_spawnegg", () -> new ForgeSpawnEggItem(TofuEntityTypes.TOFUCOW, 15460584, 10724259, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUSLIME_SPAWNEGG = ITEMS.register("tofuslime_spawnegg", () -> new ForgeSpawnEggItem(TofuEntityTypes.TOFUSLIME, 15460584, 3026478, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));
	public static final RegistryObject<Item> TOFUSPIDER_SPAWNEGG = ITEMS.register("tofuspider_spawnegg", () -> new ForgeSpawnEggItem(TofuEntityTypes.TOFUSPIDER, 15460584, 3026478, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT)));

	//Tofu delight item
	public static final RegistryObject<Item> TOMATO_SOYBEAN_STEW = ITEMS.register("tomato_soybean_stew", () -> new StackableBowlItem((new Item.Properties()).stacksTo(16).craftRemainder(Items.BOWL).food(TofuFoods.TOMATO_SOYBEAN_STEW).tab(TofuCreativeModeTab.TOFU_DELIGHT)));
	public static final RegistryObject<Item> YUDOFU = ITEMS.register("yudofu", () -> new StackableBowlItem((new Item.Properties()).stacksTo(16).craftRemainder(Items.BOWL).food(TofuFoods.YUDOFU).tab(TofuCreativeModeTab.TOFU_DELIGHT)));
	public static final RegistryObject<Item> EDAMAME_RICE = ITEMS.register("edamame_rice", () -> new StackableBowlItem((new Item.Properties()).stacksTo(16).craftRemainder(Items.BOWL).food(TofuFoods.EDAMAME_RICE).tab(TofuCreativeModeTab.TOFU_DELIGHT)));
	public static final RegistryObject<Item> BOTTLE_DASHI = ITEMS.register("bottle_dashi", () -> new Item((new Item.Properties()).stacksTo(1).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFU_DELIGHT)));
	public static final RegistryObject<Item> TOFUEGG = ITEMS.register("tofuegg", () -> new Item((new Item.Properties()).food(TofuFoods.TOFU_EGG).tab(TofuCreativeModeTab.TOFU_DELIGHT)));
	public static final RegistryObject<Item> SOYSAUSE_RAMEN = ITEMS.register("soysause_ramen", () -> new StackableBowlItem((new Item.Properties()).stacksTo(16).craftRemainder(Items.BOWL).food(TofuFoods.SOYSAUSE_RAMEN).tab(TofuCreativeModeTab.TOFU_DELIGHT)));
	public static final RegistryObject<Item> SOY_CHEESE = ITEMS.register("soy_cheese", () -> new Item((new Item.Properties()).food(TofuFoods.SOY_CHEESE).tab(TofuCreativeModeTab.TOFU_DELIGHT)));


	public static void registerCompostableItem() {
		ComposterBlock.COMPOSTABLES.put(TofuItems.EDAMAME.get(), 0.1F);
		ComposterBlock.COMPOSTABLES.put(TofuItems.BOILED_EDAMAME.get(), 0.1F);
		ComposterBlock.COMPOSTABLES.put(TofuItems.SEEDS_SOYBEANS.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TofuItems.SEEDS_SOYBEANS_NETHER.get(), 0.3F);
		ComposterBlock.COMPOSTABLES.put(TofuItems.SEEDS_SOYBEANS_SOUL.get(), 0.3F);
	}

	public static void registerDispenserItem() {

		DispenseItemBehavior dispenseitembehavior1 = new DefaultDispenseItemBehavior() {
			private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

			public ItemStack execute(BlockSource p_123561_, ItemStack p_123562_) {
				DispensibleContainerItem dispensiblecontaineritem = (DispensibleContainerItem) p_123562_.getItem();
				BlockPos blockpos = p_123561_.getPos().relative(p_123561_.getBlockState().getValue(DispenserBlock.FACING));
				Level level = p_123561_.getLevel();
				if (dispensiblecontaineritem.emptyContents((Player) null, level, blockpos, (BlockHitResult) null)) {
					dispensiblecontaineritem.checkExtraContent((Player) null, level, p_123562_, blockpos);
					return new ItemStack(Items.BUCKET);
				} else {
					return this.defaultDispenseItemBehavior.dispense(p_123561_, p_123562_);
				}
			}
		};
		DispenserBlock.registerBehavior(BUCKET_SOYMILK.get(), dispenseitembehavior1);
		DispenserBlock.registerBehavior(BUCKET_SOYMILK_NETHER.get(), dispenseitembehavior1);
		DispenserBlock.registerBehavior(BUCKET_SOYMILK_SOUL.get(), dispenseitembehavior1);
		DispenserBlock.registerBehavior(BUCKET_BITTERN.get(), dispenseitembehavior1);
		DispenseItemBehavior dispenseitembehavior2 = new DefaultDispenseItemBehavior() {
			private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

			public ItemStack execute(BlockSource p_123561_, ItemStack p_123562_) {
				BlockPos blockpos = p_123561_.getPos().relative(p_123561_.getBlockState().getValue(DispenserBlock.FACING));
				FluidState fluidState = p_123561_.getLevel().getFluidState(blockpos);
				ItemStack result = RecipeHelper.getBitternResult(fluidState.getType());
				if (result != null) {
					p_123561_.getLevel().setBlock(blockpos, Block.byItem(result.getItem()).defaultBlockState(), 11);
					p_123561_.getLevel().levelEvent(2001, blockpos, Block.getId(p_123561_.getLevel().getBlockState(blockpos)));
					p_123562_.shrink(1);
					this.defaultDispenseItemBehavior.dispense(p_123561_, new ItemStack(Items.GLASS_BOTTLE));
				}
				return p_123562_;
			}
		};
		DispenserBlock.registerBehavior(BITTERN_BOTTLE.get(), dispenseitembehavior2);
		DispenseItemBehavior dispenseitembehavior3 = new DefaultDispenseItemBehavior() {
			private boolean success = false;
			private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

			public ItemStack execute(BlockSource p_123561_, ItemStack p_123562_) {
				BlockPos blockpos = p_123561_.getPos().relative(p_123561_.getBlockState().getValue(DispenserBlock.FACING));
				if (p_123561_.getLevel().getBlockState(blockpos).is(TofuTags.Blocks.SOFT_TOFU)) {
					ItemStack stack = new ItemStack(Item.BY_BLOCK.get(p_123561_.getLevel().getBlockState(blockpos).getBlock()));
					p_123561_.getLevel().levelEvent(2001, blockpos, Block.getId(p_123561_.getLevel().getBlockState(blockpos)));
					p_123561_.getLevel().removeBlock(blockpos, false);
					this.defaultDispenseItemBehavior.dispense(p_123561_, stack);
					p_123562_.hurt(1, p_123561_.getLevel().getRandom(), null);
					setSuccess(true);
				}
				return p_123562_;
			}

			public boolean isSuccess() {
				return this.success;
			}

			public void setSuccess(boolean p_123574_) {
				this.success = p_123574_;
			}

			protected void playSound(BlockSource p_123572_) {
				p_123572_.getLevel().levelEvent(this.isSuccess() ? 1000 : 1001, p_123572_.getPos(), 0);
			}
		};
		DispenserBlock.registerBehavior(TOFUSCOOP.get(), dispenseitembehavior3);
	}
}
