package xyz.petmydog.slashdupe.command.impl;

import xyz.petmydog.slashdupe.command.Command;

public class ChatRed extends Command {
    public ChatRed() {
        super("cr", "stack", "s {amount}");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        for(int i=0;i<args.length;i++) {
            mc.inGameHud.getChatHud().addToMessageHistory("-cr " + args[i]);
            mc.player.sendChatMessage("&4" + i);

        }
    }
}
