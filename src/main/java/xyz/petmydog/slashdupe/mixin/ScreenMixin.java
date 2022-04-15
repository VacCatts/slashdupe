package xyz.petmydog.slashdupe.mixin;
import com.mojang.brigadier.Command;
import net.fabricmc.fabric.api.registry.CommandRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.petmydog.slashdupe.SlashDupe;
import xyz.petmydog.slashdupe.command.CommandManager;

import javax.annotation.Nullable;
import java.util.Arrays;

@Mixin(Screen.class)
public abstract class ScreenMixin {
	@Shadow public abstract void sendMessage(String message);

	/*@Inject(method = "render", at = @At("HEAD"))
	private void render(CallbackInfo callback) {

	}*/

	@Inject(method="sendMessage(Ljava/lang/String;Z)V",at=@At("HEAD"),cancellable = true)
	public void sendMessage(String message, boolean toHud, CallbackInfo ci) {
		String msg = (message.split(" "))[0];
		if (SlashDupe.cM.getCommand(msg) != null) {
			SlashDupe.cM.callCommand(message);
			ci.cancel();
		}
		// TODO: port this to new command system and cancel
		/* if (message.toLowerCase().startsWith("-sld")) {
			String amt1 = message.split(" ")[1];
			try {
				int amt = Integer.parseInt(amt1);
				// do stuff
				for (int i = 0; i < amt; i++) {
					sendMessage("/dupe");
				}
			}
			catch (NumberFormatException ex){
				ex.printStackTrace();
			}
		} */
		System.out.println("User sent "+message+" to the server.");
	}
}