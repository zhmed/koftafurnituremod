
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.minecraft.koftafurnituremod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.koftafurnituremod.block.SprucevslabBlock;
import net.minecraft.koftafurnituremod.block.SprucetableBlock;
import net.minecraft.koftafurnituremod.block.SprucesofaBlock;
import net.minecraft.koftafurnituremod.block.SprucebedBlock;
import net.minecraft.koftafurnituremod.block.OakvslabBlock;
import net.minecraft.koftafurnituremod.block.OaktableBlock;
import net.minecraft.koftafurnituremod.block.OaksofaBlock;
import net.minecraft.koftafurnituremod.block.Oakbed1Block;
import net.minecraft.koftafurnituremod.block.DarkoakvslabBlock;
import net.minecraft.koftafurnituremod.block.DarkoaktableBlock;
import net.minecraft.koftafurnituremod.block.DarkoaksofaBlock;
import net.minecraft.koftafurnituremod.block.DarkoakchairBlock;
import net.minecraft.koftafurnituremod.block.DarkoakbedBlock;
import net.minecraft.koftafurnituremod.block.AcaciavslabBlock;
import net.minecraft.koftafurnituremod.block.AcaciatableBlock;
import net.minecraft.koftafurnituremod.block.AcaciasofaBlock;
import net.minecraft.koftafurnituremod.block.AcaciabedBlock;
import net.minecraft.koftafurnituremod.KoftafurnitureMod;

public class KoftafurnitureModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, KoftafurnitureMod.MODID);
	public static final RegistryObject<Block> DARKOAKBED = REGISTRY.register("darkoakbed", () -> new DarkoakbedBlock());
	public static final RegistryObject<Block> DARKOAKTABLE = REGISTRY.register("darkoaktable", () -> new DarkoaktableBlock());
	public static final RegistryObject<Block> OAKTABLE = REGISTRY.register("oaktable", () -> new OaktableBlock());
	public static final RegistryObject<Block> ACACIATABLE = REGISTRY.register("acaciatable", () -> new AcaciatableBlock());
	public static final RegistryObject<Block> SPRUCETABLE = REGISTRY.register("sprucetable", () -> new SprucetableBlock());
	public static final RegistryObject<Block> DARKOAKCHAIR = REGISTRY.register("darkoakchair", () -> new DarkoakchairBlock());
	public static final RegistryObject<Block> DARKOAKVSLAB = REGISTRY.register("darkoakvslab", () -> new DarkoakvslabBlock());
	public static final RegistryObject<Block> OAKVSLAB = REGISTRY.register("oakvslab", () -> new OakvslabBlock());
	public static final RegistryObject<Block> SPRUCEVSLAB = REGISTRY.register("sprucevslab", () -> new SprucevslabBlock());
	public static final RegistryObject<Block> ACACIAVSLAB = REGISTRY.register("acaciavslab", () -> new AcaciavslabBlock());
	public static final RegistryObject<Block> SPRUCEBED = REGISTRY.register("sprucebed", () -> new SprucebedBlock());
	public static final RegistryObject<Block> ACACIABED = REGISTRY.register("acaciabed", () -> new AcaciabedBlock());
	public static final RegistryObject<Block> OAKBED_1 = REGISTRY.register("oakbed_1", () -> new Oakbed1Block());
	public static final RegistryObject<Block> ACACIASOFA = REGISTRY.register("acaciasofa", () -> new AcaciasofaBlock());
	public static final RegistryObject<Block> SPRUCESOFA = REGISTRY.register("sprucesofa", () -> new SprucesofaBlock());
	public static final RegistryObject<Block> OAKSOFA = REGISTRY.register("oaksofa", () -> new OaksofaBlock());
	public static final RegistryObject<Block> DARKOAKSOFA = REGISTRY.register("darkoaksofa", () -> new DarkoaksofaBlock());
}
