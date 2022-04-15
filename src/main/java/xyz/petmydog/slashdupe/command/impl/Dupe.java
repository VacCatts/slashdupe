package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import xyz.petmydog.slashdupe.command.Command;

public class Dupe extends Command {
    public Dupe() {
        super("d", "dupe", "d {amount}");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        mc.inGameHud.addChatMessage(MessageType.SYSTEM, new LiteralText("Duped " + args[0] + " times"), mc.player.getUuid());
        mc.inGameHud.getChatHud().addToMessageHistory("-d " + args[0]);
        try {
            int amt = Integer.parseInt(args[0]);
            // do stuff
            for (int i = 0; i < amt; i++) {
                mc.player.sendChatMessage("/dupe");
            }
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }
}
