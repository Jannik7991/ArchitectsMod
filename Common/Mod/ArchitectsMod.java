package Mod;

import Block.BlockArchitectsTable;
import Proxy.*;
import GUI.GuiHandler;
import Item.ItemFireStick;
import Item.ItemSaw;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import lib.reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 
 * To-Do: Auskommentieren beenden und herausfinden wann genau die Funktion load gerufen wird und wann die preInit
 *
 */

// Forge sagen, dass hier ne Mod ist und wo genau sie ist
@Mod(modid = reference.MOD_ID, name = reference.MOD_NAME, version = reference.VERSION)

public class ArchitectsMod {
	// Objekt Item saw erstellen
	public static Item saw = new ItemSaw(reference.SAW_ID);
	public static Item Firestick = (new ItemFireStick(1001)).setFull3D().setUnlocalizedName("firestick").setCreativeTab(CreativeTabs.tabMaterials);
	
	// Objekt Block table erstellen
	public static Block table = new BlockArchitectsTable(reference.TABLE_ID);
	
	// Ein Objekt(Instance) der Hauptklasse erstellen
	@Instance(reference.MOD_ID)
    public static ArchitectsMod instance;
	
	// Proxy registrieren und erstellen
	@SidedProxy(clientSide = reference.CLIENT_PROXY_CLASS, serverSide = reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
	
	// GuiHandler Objekt erstellen, um GUI's zu registrieren
	private GuiHandler guihandler = new GuiHandler();
	
	// Hier werden Blöcke, Items , Namen, Handlers und TileEntity's registriert
	@EventHandler
	public void load(FMLInitializationEvent Event){	
		
		// Den GUI Handler registrieren
		NetworkRegistry.instance().registerGuiHandler(this, guihandler);

		// Namen von Objekten registrieren
		LanguageRegistry.addName(saw, "Saw");
		LanguageRegistry.addName(Firestick, "FireStick");
		LanguageRegistry.addName(table, "Architect's Table");
		
		// Blöcke registrieren
		GameRegistry.registerBlock(table, "table");
		
		// TileEntity's registrieren
		proxy.registerTileEntities();
		
	}
	
}
