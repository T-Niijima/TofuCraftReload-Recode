package baguchan.tofucraft.mixin;

import baguchan.tofucraft.api.ISmell;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Warden.class)
public class WardenMixin extends Monster implements ISmell {
	private static final EntityDataAccessor<Boolean> CANNOT_SMELL = SynchedEntityData.defineId(Warden.class, EntityDataSerializers.BOOLEAN);

	public AnimationState coughAnimationState = new AnimationState();

	protected WardenMixin(EntityType<? extends Monster> p_33002_, Level p_33003_) {
		super(p_33002_, p_33003_);
	}

	@Inject(method = "defineSynchedData", at = @At("TAIL"))
	protected void defineSynchedData(CallbackInfo callbackInfo) {
		this.entityData.define(CANNOT_SMELL, false);
	}

	@Inject(method = "handleEntityEvent", at = @At("HEAD"), cancellable = true)
	public void handleEntityEvent(byte p_219360_, CallbackInfo callbackInfo) {
		if (p_219360_ == 63) {
			this.coughAnimationState.start(this.tickCount);
			callbackInfo.cancel();
		}
	}

	@Override
	public AnimationState getCoughAnimationState() {
		return this.coughAnimationState;
	}

	@Override
	public boolean cannotSmell() {
		return this.entityData.get(CANNOT_SMELL);
	}

	@Override
	public void setCannotSmell(boolean cannotSmell) {
		this.entityData.set(CANNOT_SMELL, cannotSmell);
	}
}
