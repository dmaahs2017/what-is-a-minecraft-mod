package net.fabricmc.autofish.mixin;


import net.fabricmc.autofish.AutoFishMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.projectile.FishingBobberEntity;

@Mixin(FishingBobberEntity.class)
public class BobberMixin {

    @Shadow
    private boolean caughtFish;


    @Inject(at = @At("TAIL"), method = "onTrackedDataSet")
    private void reelAndCast(CallbackInfo info) {
        if (caughtFish) {
            AutoFishMod.catchAndRecast();
        }
    }
}
