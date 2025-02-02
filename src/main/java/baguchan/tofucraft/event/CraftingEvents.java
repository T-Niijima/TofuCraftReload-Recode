package baguchan.tofucraft.event;

import baguchan.tofucraft.TofuCraftReload;
import baguchan.tofucraft.registry.TofuItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Optional;

public class CraftingEvents {

	@SubscribeEvent
	public void onCraftingOkara(PlayerEvent.ItemCraftedEvent event) {
		Player player = event.getEntity();
		ItemStack item = event.getCrafting();
		Container craftMatrix = event.getInventory();
		Optional<? extends Recipe> recipe = player.level.getRecipeManager().byKey(new ResourceLocation(TofuCraftReload.MODID, "bucket_soymilk_okara"));
		if (recipe.isPresent() && recipe.stream().findFirst().get().matches(craftMatrix, player.level)) {
			player.getInventory().add(new ItemStack(TofuItems.OKARA.get(), 1));
		}

	}
}
