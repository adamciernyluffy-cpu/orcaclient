package com.orca.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class OrcaScreen extends Screen {
    private int x = 90;
    private int y = 55;
    private final int width = 720;
    private final int height = 440;
    private boolean dragging;
    private double offsetX;
    private double offsetY;

    public OrcaScreen() {
        super(Component.literal("Orca Client"));
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        graphics.fill(0, 0, this.width(), this.height(), 0x55000000);

        // Floating glass-style panel
        graphics.fill(x, y, x + width, y + height, 0xE90A1824);
        graphics.fill(x, y, x + width, y + 42, 0xFF102C3D);

        graphics.drawString(this.font, "ORCA", x + 18, y + 14, 0xFFB8F4FF);
        graphics.drawString(this.font, "Build. Customize. Play.", x + 92, y + 14, 0xFF75AFC0);

        String[] tabs = {
                "Home", "PvP", "Movement", "Render", "World",
                "Player", "Base Finder", "Character", "HUD", "Settings"
        };

        int sidebarY = y + 58;
        for (int i = 0; i < tabs.length; i++) {
            int yy = sidebarY + i * 32;
            if (i == 0) {
                graphics.fill(x + 10, yy - 4, x + 150, yy + 23, 0xFF164B63);
            }
            graphics.drawString(this.font, tabs[i], x + 22, yy + 4, 0xFFD5F7FF);
        }

        int contentX = x + 172;
        int contentY = y + 62;

        graphics.drawString(this.font, "Welcome to Orca Client", contentX, contentY, 0xFFE7FAFF);
        graphics.drawString(this.font, "A premium ocean-themed client interface.",
                contentX, contentY + 22, 0xFF8CB4C0);

        graphics.fill(contentX, contentY + 52, x + width - 18, contentY + 145, 0xFF102E3D);
        graphics.drawString(this.font, "Orca AI", contentX + 16, contentY + 68, 0xFF9EEBFF);
        graphics.drawString(this.font, "Build anything with AI", contentX + 16, contentY + 88, 0xFFFFFFFF);
        graphics.drawString(this.font, "Tell Orca what you want to build...",
                contentX + 16, contentY + 112, 0xFF739AA7);

        graphics.fill(x + width - 112, contentY + 102, x + width - 34, contentY + 132, 0xFF17627E);
        graphics.drawString(this.font, "Generate",
                x + width - 100, contentY + 112, 0xFFFFFFFF);

        String[] info = {"FPS", "Ping", "Time", "Name"};
        int cardWidth = 118;
        for (int i = 0; i < info.length; i++) {
            int xx = contentX + i * (cardWidth + 8);
            graphics.fill(xx, contentY + 165, xx + cardWidth, contentY + 215, 0xFF0D2632);
            graphics.drawString(this.font, info[i], xx + 10, contentY + 176, 0xFF72B8CA);
            graphics.drawString(this.font, i == 3 ? "Player" : "--",
                    xx + 10, contentY + 194, 0xFFFFFFFF);
        }

        graphics.drawString(this.font, "Right Shift", x + width - 105, y + height - 22, 0xFF6F9EAA);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0 && mouseX >= x && mouseX <= x + width
                && mouseY >= y && mouseY <= y + 42) {
            dragging = true;
            offsetX = mouseX - x;
            offsetY = mouseY - y;
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0) dragging = false;
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button,
                                double dragX, double dragY) {
        if (dragging && button == 0) {
            x = (int) (mouseX - offsetX);
            y = (int) (mouseY - offsetY);
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
