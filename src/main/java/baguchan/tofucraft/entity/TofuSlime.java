package baguchan.tofucraft.entity;

import baguchan.tofucraft.registry.TofuBiomes;
import baguchan.tofucraft.registry.TofuItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;

public class TofuSlime extends Slime {
	private static final EntityDataAccessor<Boolean> DATA_CONVERSION_ID = SynchedEntityData.defineId(TofuSlime.class, EntityDataSerializers.BOOLEAN);

	private int onZundaTime;
	private int conversionTime;


	public TofuSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
		super(p_33588_, p_33589_);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(DATA_CONVERSION_ID, false);
	}

	public boolean isZundaConverting() {
		return this.getEntityData().get(DATA_CONVERSION_ID);
	}

	public void tick() {
		if (!this.level.isClientSide && this.isAlive() && !this.isNoAi()) {
			if (this.isZundaConverting()) {
				--this.conversionTime;
				if (this.conversionTime < 0 && net.minecraftforge.event.ForgeEventFactory.canLivingConvert(this, EntityType.DROWNED, (timer) -> this.conversionTime = timer)) {
					this.doZundaConversion();
				}
			} else if (this.convertsOnZunda()) {
				if (this.level.getBiome(this.blockPosition()).is(TofuBiomes.ZUNDA_FOREST)) {
					++this.onZundaTime;
					if (this.onZundaTime >= 600) {
						this.startZundaConversion(300);
					}
				} else {
					this.onZundaTime = -1;
				}
			}
		}

		super.tick();
	}

	protected boolean convertsOnZunda() {
		return true;
	}

	private void startZundaConversion(int p_34279_) {
		this.conversionTime = p_34279_;
		this.getEntityData().set(DATA_CONVERSION_ID, true);
	}

	protected void doZundaConversion() {
		this.spawnAtLocation(new ItemStack(TofuItems.TOFUZUNDA.get(), 2 * getSize()));
		this.playSound(SoundEvents.ZOMBIE_VILLAGER_CONVERTED);
		this.discard();
	}

	public void addAdditionalSaveData(CompoundTag p_34319_) {
		super.addAdditionalSaveData(p_34319_);
		p_34319_.putInt("OnZundaTime", this.isInWater() ? this.onZundaTime : -1);
		p_34319_.putInt("ZundaConversionTime", this.isZundaConverting() ? this.conversionTime : -1);
	}

	public void readAdditionalSaveData(CompoundTag p_34305_) {
		super.readAdditionalSaveData(p_34305_);
		this.onZundaTime = p_34305_.getInt("OnZundaTime");
		if (p_34305_.contains("ZundaConversionTime", 99) && p_34305_.getInt("ZundaConversionTime") > -1) {
			this.startZundaConversion(p_34305_.getInt("ZundaConversionTime"));
		}

	}

	protected ParticleOptions getParticleType() {
		return new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(TofuItems.TOFUKINU.get()));
	}

	public static boolean isDarkEnoughToSpawn(ServerLevelAccessor p_33009_, BlockPos p_33010_, RandomSource p_33011_) {
		if (p_33009_.getBrightness(LightLayer.SKY, p_33010_) > p_33011_.nextInt(32)) {
			return false;
		} else {
			int var3 = p_33009_.getLevel().isThundering() ? p_33009_.getMaxLocalRawBrightness(p_33010_, 10) : p_33009_.getMaxLocalRawBrightness(p_33010_);
			return var3 <= p_33011_.nextInt(8);
		}
	}

	public static boolean checkMonsterSpawnRules(EntityType<? extends TofuSlime> p_33018_, ServerLevelAccessor p_33019_, MobSpawnType p_33020_, BlockPos p_33021_, RandomSource p_33022_) {
		return p_33019_.getDifficulty() != Difficulty.PEACEFUL && isDarkEnoughToSpawn(p_33019_, p_33021_, p_33022_) && checkMobSpawnRules(p_33018_, p_33019_, p_33020_, p_33021_, p_33022_);
	}
}
