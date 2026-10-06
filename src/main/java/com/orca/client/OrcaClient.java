package com.orca.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public final class OrcaClient implements ClientModInitializer {
    private static final KeyMapping OPEN_GUI = new KeyMapping(
            "key.orca.open_gui",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "category.orca"
    );

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (OPEN_GUI.consumeClick()) {
                if (client.screen instanceof OrcaScreen) {
                    client.setScreen(null);
                } else {
                    client.setScreen(new OrcaScreen());
                }
            }
        });
    }
}
