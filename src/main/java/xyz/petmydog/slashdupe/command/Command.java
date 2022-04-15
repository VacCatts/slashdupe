package xyz.petmydog.slashdupe.command;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.apache.commons.lang3.ArrayUtils;

import java.util.stream.Stream;

public abstract class Command {
    protected final MinecraftClient mc = MinecraftClient.getInstance();

    private String[] aliases;
    private String description;
    private String syntax;

    public Command(String alias, String desc, String syntax, String... moreAliases) {
        this.aliases = ArrayUtils.add(moreAliases, 0, alias);
        this.description = desc;
        this.syntax = syntax;
    }

    public static String getPrefix() {
        return "-";
    }

    public String[] getAliases() {
        return aliases;
    }

    public String getDescription() {
        return description;
    }

    public String getSyntax() {
        return syntax;
    }

    public boolean hasAlias(String alias) {
        return Stream.of(aliases).anyMatch(alias::equalsIgnoreCase);
    }

    public Text getHelpTooltip() {
        return new LiteralText("\n")
                .append("Aliases: \u00a7f" + getPrefix() + String.join(" \u00a77/\u00a7f " + getPrefix(), getAliases()) + "\n").styled(s -> s.withColor(Formatting.BLUE))
                .append("Usage: \u00a7f" + getSyntax() + "\n").styled(s -> s.withColor(Formatting.BLUE))
                .append("Description: \u00a7f" + getDescription()).styled(s -> s.withColor(Formatting.BLUE));
    }

    public abstract void onCommand(String alias, String[] args) throws Exception;
}
