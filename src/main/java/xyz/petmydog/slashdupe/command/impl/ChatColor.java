package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import xyz.petmydog.slashdupe.command.Command;

public class ChatColor extends Command {
    public ChatColor() {
        super("cc", "chat colors", "cc <red / gold / green / cyan / blue / purple / gray / black> <message>");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        mc.inGameHud.getChatHud().addToMessageHistory("-cc " + args);
        String message = "[slashdupe] malfunction";

        if (args.length >= 2) {
            switch (args[0]) {
                case "red":
                    message = "&c";
                    break;
                case "gold":
                    message = "&6";
                    break;
                case "green":
                    message = "&a";
                    break;
                case "cyan":
                    message = "&b";
                    break;
                case "blue":
                    message = "&9";
                    break;
                case "purple":
                    message = "&5";
                    break;
                case "gray":
                    message = "&7";
                    break;
                case "black":
                    message = "&0";
                    break;
            }
            // string manipulation
            message = message + " ";
            for (int i = 0; i < args.length - 1; i++) {
                message = message + i;
                System.out.println(message);
            }
            
            mc.player.sendChatMessage(message);
        }
    }
}
