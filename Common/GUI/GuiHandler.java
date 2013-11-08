package GUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import Inventory.ContainerArchitectTable;
import Tile.TileArchitectTable;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * To-Do: Eigentlich nichts weiter :D
 *
 */

public class GuiHandler implements IGuiHandler{
	
	// wird aufgerufen wenn der Spieler eine Gui öffnen will
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// Falls die GuiId gleich 0 ist: (0 ist zurzeit die GuiId für den ArchitectTable)
		if (ID == 0) {
			// na ja der Container will eine TileEntity und das ist in diesem Fall die TileArchitectTable des jeweiligen Bloks
            TileArchitectTable tileArchitectTable = (TileArchitectTable) world.getBlockTileEntity(x, y, z);
            // Zurückgeben des Containers auf welchen der Spieler zugreift
            return new ContainerArchitectTable(player.inventory, tileArchitectTable);
        }
		// Falls keine Id übereinstimmt wird nichts zurückgegeben
		return null;
	}

	// Dasselbe noch mal für den Client mit einer Änderung ( Der Server will einen Container zurückgegeben haben der CLient eine Gui zum darstellen )
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == 0) {
            TileArchitectTable tileArchitectTable = (TileArchitectTable) world.getBlockTileEntity(x, y, z);
            return new GUIArchitectTable(player.inventory, tileArchitectTable);
        }		
		
		// Nicht weiter auskommentiert da sie fast identisch zur oberen ist
		
		return null;
	}

}
