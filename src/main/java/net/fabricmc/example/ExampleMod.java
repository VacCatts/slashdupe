package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mojang.brigadier.*;

public class ExampleMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("slashdupe");

	@Override
	public void onInitialize() {
		LOGGER.info("slashdupe loaded");
	}
}
