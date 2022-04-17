package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import xyz.petmydog.slashdupe.command.Command;

public class Help extends Command {
    public Help() {
        super("help", "Help command", "h");
    }

    @Override
    public void onCommand(String alias, String[] args) throws Exception {
        mc.inGameHud.addChatMessage(MessageType.SYSTEM, new LiteralText(  "§b--------------HELP--------------\n" + "§bNeed Help? Heres the following commands in this mod!" + "\n§b-s <amount> §f(You need custom rank + for it to work!)" +  "\n§b-d <amount> §fDupes the amount provided." + "\n§b-fa §fFaction Alliance Chat." + "\n§b-fc §fFaction Chat " + "\n§b-fp §fPublic Chat" + "\n§b-ft §fFaction Truce Chat" + "\n§b-inf §fShows info on player." + "\n§b--------------------------------") , mc.player.getUuid());
        mc.inGameHud.getChatHud().addToMessageHistory("-help");
        try {
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }
}
