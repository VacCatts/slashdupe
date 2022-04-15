package xyz.petmydog.slashdupe;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.petmydog.slashdupe.command.CommandManager;

public class SlashDupe implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("slashdupe");
	public static final CommandManager cM = new CommandManager();

	@Override
	public void onInitialize() {
		LOGGER.info("slashdupe loaded");
	}
}
