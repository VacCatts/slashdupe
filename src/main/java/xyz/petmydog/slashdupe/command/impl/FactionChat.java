package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import xyz.petmydog.slashdupe.command.Command;

public class FactionChat extends Command {
    public FactionChat() {
        super("fc", "faction-chat", "faction");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        mc.inGameHud.getChatHud().addToMessageHistory("-fc");
        try {
            mc.player.sendChatMessage("/factions chat faction");
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }
}
