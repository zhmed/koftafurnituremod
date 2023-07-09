
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.minecraft.koftafurnituremod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KoftafurnitureModTabs {
	@SubscribeEvent
	public static void buildTabContentsModded(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("koftafurniture", "kofta_furniture"),
				builder -> builder.title(Component.translatable("item_group.koftafurniture.kofta_furniture")).icon(() -> new ItemStack(Blocks.BLAST_FURNACE)).displayItems((parameters, tabData) -> {
					tabData.accept(KoftafurnitureModBlocks.DARKOAKBED.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.DARKOAKTABLE.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.OAKTABLE.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.ACACIATABLE.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.SPRUCETABLE.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.DARKOAKCHAIR.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.DARKOAKVSLAB.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.OAKVSLAB.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.SPRUCEVSLAB.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.ACACIAVSLAB.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.SPRUCEBED.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.ACACIABED.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.OAKBED_1.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.ACACIASOFA.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.SPRUCESOFA.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.OAKSOFA.get().asItem());
					tabData.accept(KoftafurnitureModBlocks.DARKOAKSOFA.get().asItem());
				})

		);
	}
}
