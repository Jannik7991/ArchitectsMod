package lib;

import net.minecraft.util.ResourceLocation;

/**
 * 
 * Die Klasse sollte selbsterklärend sein :D
 * 
 * To-Do: ResourceLocation verbessern und herausfinden wie man die Pfade einstellt
 *
 */

public class reference {
	// Variablen
	public static final String MOD_ID = "architectsmod";
	public static final String MOD_NAME = "Architect's Mod";
	public static final String VERSION = "0.0.1";
	
	// IDs
	public static final int SAW_ID = 1997;
	public static final int TABLE_ID = 997;
	
	// Proxy Klasse
	public static final String CLIENT_PROXY_CLASS = "Proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "Proxy.CommonProxy";
	
	// Pfade
	public static final String GUI_SHEET_LOCATION = "AM/textures/gui";
	
	public static final ResourceLocation GUI_ARCHITECT_TABLE = new ResourceLocation(MOD_ID, "textures/gui/ArchitectTable.png");
			
}
