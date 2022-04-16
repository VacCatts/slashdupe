package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import xyz.petmydog.slashdupe.command.Command;

public class AntiKick extends Command {
    public AntiKick() {
        super("AK", "faction-public", "faction-public2");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        mc.inGameHud.getChatHud().addToMessageHistory("-Ak");
        while(mc.player.isPlayer()) {

            wait(300000);
            mc.player.sendChatMessage("/afk");
        }

    }
}
