package Mod;

import Block.BlockArchitectsTable;
import Item.ItemSaw;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import lib.reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = reference.MOD_ID, name = reference.MOD_NAME, version = reference.VERSION)

public class ArchitectsMod {
	
	public static Item saw = new ItemSaw(reference.SAW_ID);
	public static Block table = new BlockArchitectsTable(reference.TABLE_ID);
	
	@EventHandler
	public void load(FMLInitializationEvent Event){	
		
		LanguageRegistry.addName(saw, "Saw");
		LanguageRegistry.addName(table, "Architect's Table");
		GameRegistry.registerBlock(table, "table");
		
	}
	
}
