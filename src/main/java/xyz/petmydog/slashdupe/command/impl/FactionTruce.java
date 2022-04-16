package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import xyz.petmydog.slashdupe.command.Command;

public class FactionTruce extends Command {
    public FactionTruce() {
        super("ft", "changes your chat to truce chat", "ft");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        mc.inGameHud.getChatHud().addToMessageHistory("-ft");
        try {
            mc.player.sendChatMessage("/f c t");
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }
}
