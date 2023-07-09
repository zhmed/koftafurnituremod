
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.minecraft.koftafurnituremod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.koftafurnituremod.KoftafurnitureMod;

public class KoftafurnitureModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, KoftafurnitureMod.MODID);
	public static final RegistryObject<Item> DARKOAKBED = block(KoftafurnitureModBlocks.DARKOAKBED);
	public static final RegistryObject<Item> DARKOAKTABLE = block(KoftafurnitureModBlocks.DARKOAKTABLE);
	public static final RegistryObject<Item> OAKTABLE = block(KoftafurnitureModBlocks.OAKTABLE);
	public static final RegistryObject<Item> ACACIATABLE = block(KoftafurnitureModBlocks.ACACIATABLE);
	public static final RegistryObject<Item> SPRUCETABLE = block(KoftafurnitureModBlocks.SPRUCETABLE);
	public static final RegistryObject<Item> DARKOAKCHAIR = block(KoftafurnitureModBlocks.DARKOAKCHAIR);
	public static final RegistryObject<Item> DARKOAKVSLAB = block(KoftafurnitureModBlocks.DARKOAKVSLAB);
	public static final RegistryObject<Item> OAKVSLAB = block(KoftafurnitureModBlocks.OAKVSLAB);
	public static final RegistryObject<Item> SPRUCEVSLAB = block(KoftafurnitureModBlocks.SPRUCEVSLAB);
	public static final RegistryObject<Item> ACACIAVSLAB = block(KoftafurnitureModBlocks.ACACIAVSLAB);
	public static final RegistryObject<Item> SPRUCEBED = block(KoftafurnitureModBlocks.SPRUCEBED);
	public static final RegistryObject<Item> ACACIABED = block(KoftafurnitureModBlocks.ACACIABED);
	public static final RegistryObject<Item> OAKBED_1 = block(KoftafurnitureModBlocks.OAKBED_1);
	public static final RegistryObject<Item> ACACIASOFA = block(KoftafurnitureModBlocks.ACACIASOFA);
	public static final RegistryObject<Item> SPRUCESOFA = block(KoftafurnitureModBlocks.SPRUCESOFA);
	public static final RegistryObject<Item> OAKSOFA = block(KoftafurnitureModBlocks.OAKSOFA);
	public static final RegistryObject<Item> DARKOAKSOFA = block(KoftafurnitureModBlocks.DARKOAKSOFA);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
