package xyz.petmydog.slashdupe.command.impl;

import xyz.petmydog.slashdupe.command.Command;

public class ChatRed extends Command {
    public ChatRed() {
        super("cr", "stack", "s {amount}");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        mc.inGameHud.getChatHud().addToMessageHistory("-cr " + args[0]);
        try {
            mc.player.sendChatMessage("&4" + args[0]);

        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }
}
