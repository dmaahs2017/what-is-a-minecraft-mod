package net.fabricmc.autofish.mixin;


import net.fabricmc.autofish.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.entity.projectile.*;

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
