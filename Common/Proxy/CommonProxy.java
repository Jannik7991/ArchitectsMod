package Proxy;

import Inventory.ContainerArchitectTable;
import Tile.TileArchitectTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * To-Do: Herausfinden wozu die Klasse gut ist hat aber was mit dem Rendern, Modelieren und Texturen zu tun
 *
 */

public class CommonProxy {
	
	public void registerTileEntities() {
		// Dem Spiel mitteilen: Hey hier ist ne TileEntity 
        GameRegistry.registerTileEntity(TileArchitectTable.class, "tileArchitectTable");

    }

}
