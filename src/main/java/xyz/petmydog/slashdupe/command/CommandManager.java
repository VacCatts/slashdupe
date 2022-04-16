package xyz.petmydog.slashdupe.command;

import org.apache.commons.lang3.ArrayUtils;
import xyz.petmydog.slashdupe.command.impl.*;
import java.util.ArrayList;

public class CommandManager {
    public static boolean allowNextMsg = false;
    public ArrayList<Command> modules;

    public CommandManager() {
        (modules = new ArrayList<Command>()).clear();
        this.modules.add(new Template());
        this.modules.add(new Dupe());
        this.modules.add(new FactionPublic());
        this.modules.add(new FactionAlly());
        this.modules.add(new FactionTruce());
        this.modules.add(new Stack());
        this.modules.add(new Join());
        this.modules.add(new FactionChat());
        this.modules.add(new AntiKick());
        this.modules.add(new Help());
    }

    public void callCommand(String input) {
        System.out.println("help3");
        String[] split = input.split(" ");


        split[0] = split[0].replace("-","");
        for (Command c : getCommands()) {
            if (c.hasAlias(split[0])) {
                try {
                    c.onCommand(split[0], ArrayUtils.subarray(split, 1, split.length));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }

    public Command getCommand(String name) {
        System.out.println("help");
        for (Command m : this.modules) {
            for (String i : m.getAliases()) {
                i = "-" + i;
                System.out.println(i);
                if (i.equalsIgnoreCase(name)) {
                    System.out.println("help2");
                    return m;
                }
            }
        }
        return null;
    }

    public ArrayList<Command> getCommands() {
        return this.modules;
    }
}
