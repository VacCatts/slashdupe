package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.*;
import xyz.petmydog.slashdupe.command.Command;

public class Template extends Command {
    public Template() {
        super("template", "template command", "template");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        mc.inGameHud.addChatMessage(MessageType.SYSTEM, new LiteralText("template command ran"), mc.player.getUuid());
    }
}
