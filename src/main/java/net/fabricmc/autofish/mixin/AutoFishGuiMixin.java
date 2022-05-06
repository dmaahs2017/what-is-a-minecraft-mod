package net.fabricmc.autofish.mixin;

import net.fabricmc.autofish.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.gui.screen.option.*;
import net.minecraft.client.gui.widget.*;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;


@Mixin(OptionsScreen.class)
public class AutoFishGuiMixin extends Screen {

    public AutoFishGuiMixin(Text title) {
        super(title);
    }

    public int calculateButtonY(int row) {
        return this.height / 6 + (24 * row - 6);
    }

    public int calculateButtonX(boolean isLeft) {
        return isLeft ? this.width / 2 - 155 : this.width / 2 + 5;
    }

    public Text genMessageText(boolean isOn) {
        return isOn ?
            new TranslatableText("options.randomod.toggle.on") :
            new TranslatableText("options.randomod.toggle.off");
    }

    @Inject(at = @At("TAIL"), method = "init")
    protected void drawFishToggleButton(CallbackInfo info) {
        this.addDrawableChild(new ButtonWidget(calculateButtonX(true),
            calculateButtonY(6),
            310,
            20,
            genMessageText(AutoFishMod.isEnabled()),
            widget -> {
                AutoFishMod.toggleOnOff();
                widget.setMessage(genMessageText(AutoFishMod.isEnabled()));
            }
        ));
    }
}
