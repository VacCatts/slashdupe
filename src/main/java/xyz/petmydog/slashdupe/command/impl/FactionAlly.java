package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import xyz.petmydog.slashdupe.command.Command;

public class FactionAlly extends Command {
    public FactionAlly() {
        super("fa", "faction-ally", "faction-ally2");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        mc.inGameHud.getChatHud().addToMessageHistory("-fa");
        try {
            mc.player.sendChatMessage("/factions chat ally");
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }
}