package net.fabricmc.autofish;

import net.fabricmc.api.*;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import org.slf4j.*;

import org.slf4j.Logger;

public class AutoFishMod implements ClientModInitializer {
    private static int recastCount = -1;
    public static final Logger LOGGER = LoggerFactory.getLogger("AutoFisher");
    private static boolean isEnabled = false;


    public void onInitializeClient() {
        LOGGER.info("Register Client Fish Ticker");
        ClientTickEvents.END_CLIENT_TICK.register(this::fishTicker);
    }

    public static void catchAndRecast() {
        if (isEnabled) {
            MinecraftClient client = MinecraftClient.getInstance();
            client.interactionManager.interactItem(client.player, client.world, Hand.MAIN_HAND);

            recastCount = 20;
        }
    }

    public static boolean isEnabled() {
        return isEnabled;
    }

    public static void toggleOnOff() {
        isEnabled = !isEnabled;
        recastCount = -1;
    }

    public void fishTicker(MinecraftClient client) {
        if (isEnabled) {
            if (recastCount >= 0) {
                --recastCount;
                if (recastCount == 0) {
                    client.interactionManager.interactItem(client.player, client.world, Hand.MAIN_HAND);
                }
            }
        }
    }
}
