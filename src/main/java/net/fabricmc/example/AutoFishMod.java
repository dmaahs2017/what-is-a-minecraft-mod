package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class AutoFishMod implements ClientModInitializer {

    private static int recastCount = -1;

    public static final Logger LOGGER = LoggerFactory.getLogger("AutoFisher");

    public void onInitializeClient() {
        LOGGER.info("Register Client Fish Ticker");
        ClientTickEvents.END_CLIENT_TICK.register(this::fishTicker);
    }

    public static void catchAndRecast() {
        MinecraftClient client = MinecraftClient.getInstance();
        client.interactionManager.interactItem(client.player, client.world, Hand.MAIN_HAND);

        recastCount = 20;
    }
    public void fishTicker(MinecraftClient client) {
        if (recastCount >= 0) {
            --recastCount;
            if (recastCount == 0) {
                client.interactionManager.interactItem(client.player, client.world, Hand.MAIN_HAND);
            }
        }
    }
}
