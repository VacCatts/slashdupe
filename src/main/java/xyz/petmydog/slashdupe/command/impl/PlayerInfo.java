package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import xyz.petmydog.slashdupe.command.Command;

public class PlayerInfo extends Command {
    public PlayerInfo() {
        super("pinfo", "shows info about the player", "pinfo");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        mc.inGameHud.addChatMessage(MessageType.SYSTEM, new LiteralText("Player y: \n" + mc.player.getY() + "\nPlayer X: " + mc.player.getX() + "\nPlayer UUID: " + mc.player.getUuid() + "\nPlayer Age: " + mc.player.age + "\nPlayer Name: " + mc.player.getName() + "\nServer: " + mc.player.getServer()) , mc.player.getUuid());
        mc.inGameHud.getChatHud().addToMessageHistory("-pinfo" );
    }
}
