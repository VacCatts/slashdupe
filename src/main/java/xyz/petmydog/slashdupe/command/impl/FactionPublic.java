package xyz.petmydog.slashdupe.command.impl;

import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import xyz.petmydog.slashdupe.command.Command;

public class FactionPublic extends Command {
public FactionPublic() {
        super("fp", "faction-public", "faction-public2");
        }

@Override
public void onCommand(String alias, String[] args) throws Exception {
        mc.inGameHud.getChatHud().addToMessageHistory("-fp");
        try {
        mc.player.sendChatMessage("/factions chat public");
        }
        catch (NumberFormatException ex){
        ex.printStackTrace();
        }
        }
        }
