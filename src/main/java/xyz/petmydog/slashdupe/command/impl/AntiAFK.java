package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import xyz.petmydog.slashdupe.command.Command;

public class AntiAFK extends Command {
    private boolean toggle = false;
    public long curTime = Long.MAX_VALUE - 1000000L;
    public int startTime = 30000; // 30 seconds
    public AntiAFK() {
        super("antiafk", "sends /afk every 5 minutes", "antiafk");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        toggle = !toggle;

        if (toggle) {
            curTime = System.currentTimeMillis();
            mc.inGameHud.addChatMessage(MessageType.SYSTEM, new LiteralText("starting antiafk"), mc.player.getUuid());
        } else {
            mc.inGameHud.addChatMessage(MessageType.SYSTEM, new LiteralText("stopping antiafk"), mc.player.getUuid());
        }
    }

    public void tick() {
        if (toggle) {
            if (curTime + startTime < System.currentTimeMillis()) {
                curTime = System.currentTimeMillis();
                mc.player.sendChatMessage("/afk");
            }
        }
    }
}
