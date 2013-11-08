package Inventory;

import Tile.TileArchitectTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * 
 * To-Do: Es stehen noch Kommentare und die Funktion onContainerClosing() aus
 *
 */

public class ContainerArchitectTable extends Container {
	// Erstellen eines lokalen tileArchitectTable
    private TileArchitectTable tileArchitectTable;
    
    // Anzahl der Inventarreihen
    private final int SPIELER_INVENTAR_REIHEN = 3;
    // Anzahl der Inventarspalten
    private final int SPIELER_INVENTAR_SPALTEN = 9;
    
    // Anzahl der Kistenreihen
    private final int KISTEN_INVENTAR_REIHEN = 4;	// Es sind aber wegen der for Schleife nur 3 Reihen und 12 Spalten
    // Anzahl der Kistenspalten
    private final int KISTEN_INVENTAR_SPALTEN = 13;
    
    // Konstructor der als Paramterer das Inventar des Spielers und das TileArchitectTable mitkriegt
    public ContainerArchitectTable(InventoryPlayer inventoryPlayer, TileArchitectTable tileArchitectTable) {
    	
    	// Lokales tileArchitectTable mit dem des Paramters tileArchitectTable
    	this.tileArchitectTable = tileArchitectTable;
    	
    	
    	// Hinzufügen der Aktionsleistenslots
    	for (int AktionsLeistenIndex = 0; AktionsLeistenIndex < SPIELER_INVENTAR_SPALTEN; ++AktionsLeistenIndex) {
    		this.addSlotToContainer(new Slot(inventoryPlayer, AktionsLeistenIndex, 44+AktionsLeistenIndex*18, 162));
    	}
    	
    	// Hinzufügen der Inventarslots
    	for (int InventoryReihenIndex = 0; InventoryReihenIndex < SPIELER_INVENTAR_REIHEN; ++InventoryReihenIndex) {
    		for (int InventorySpaltenIndex = 0; InventorySpaltenIndex < SPIELER_INVENTAR_SPALTEN; ++InventorySpaltenIndex) {
    			this.addSlotToContainer(new Slot(inventoryPlayer, 9 + 9 * InventoryReihenIndex + InventorySpaltenIndex, 44 + InventorySpaltenIndex * 18, 104+InventoryReihenIndex * 18));
    		}
    	}
    	
    	// Hinzufügn der Kistenslots
    	for (int KistenReihenIndex = 0; KistenReihenIndex < KISTEN_INVENTAR_REIHEN; ++KistenReihenIndex) {
    		for (int KistenSpaltenIndex = 0; KistenSpaltenIndex < KISTEN_INVENTAR_SPALTEN; ++ KistenSpaltenIndex) {
    			this.addSlotToContainer(new Slot(tileArchitectTable, KistenSpaltenIndex + KistenReihenIndex * 13,8 + KistenSpaltenIndex * 18, 18 + 18 * KistenReihenIndex));
    		}
    	}
    	
    }
    
    
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// Nur falls der Spieler die TileEntity benutzen kann kann er auch den Container benutzen
		return tileArchitectTable.isUseableByPlayer(entityplayer);
	}
	
	/**
	 * @param itemStack ItemStack to merge into inventory
	 * @param start minimum slot to attempt fill
	 * @param end maximum slot to attempt fill
	 * @param backwards go backwards
	 * @return true if stacks merged successfully
	 */
	@Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
            ItemStack stack = null;
            Slot slotObject = (Slot) inventorySlots.get(slot);
            stack = slotObject.getStack();

            return stack;
    }

}