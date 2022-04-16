package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import xyz.petmydog.slashdupe.SlashDupe;
import xyz.petmydog.slashdupe.command.Command;

public class Help extends Command {
    public Help() {
        super("help", "help command", "help");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        //mc.inGameHud.addChatMessage(MessageType.SYSTEM, new LiteralText("template command ran"), mc.player.getUuid());
        for(Command c : SlashDupe.cM.getCommands()) {
            mc.inGameHud.addChatMessage(MessageType.SYSTEM, c.getHelpTooltip(), mc.player.getUuid());
        }
    }
}