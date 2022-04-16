package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import xyz.petmydog.slashdupe.command.Command;

public class FactionChat extends Command {
    public FactionChat() {
        super("fc", "changes your chat to faction chat", "fc");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        mc.inGameHud.getChatHud().addToMessageHistory("-fc");
        try {
            mc.player.sendChatMessage("/f c f");
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }
}
