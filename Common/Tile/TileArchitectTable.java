package Tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.TileEntity;

/**
 * 
 * To-Do: Kommentare beenden und Bug fixen der das Spiel abstürzen lässt wenn jemand etwas dem Inventar hinzufügen will
 * 		  Der Bug zeigt sich auch sobald man nur in den Slot klickt und zeigt eine Fehlermeldung an, dass die Tabelle an der Stelle i leer ist
 *
 */

public class TileArchitectTable extends TileEntity implements IInventory {
	
	// Namen der TileEntity festlegen
	protected String customName;
	// lokalen Wert state erstellen
	protected byte state;
	// lokales Array Inventory inventory erstellen
	public ItemStack[] inventory;

	// Größe des Inventars 	
	public static final int INVENTORY_SIZE = 13 * 4;
	
	// Konstruktor
	public TileArchitectTable() {
		// Konstruktor der Oberklass TileEntity ausführen
        super();
        // inventory mit neuem Array ItemStack mit INVENTORY_SIZE Menge an Integern(Zahlen) 
        inventory = new ItemStack[INVENTORY_SIZE];
    }
	
	// gibt den Größenwert des Inventars zurück
	@Override
	public int getSizeInventory() {
		//gibt INVENTORY_SIZE zurück
		return INVENTORY_SIZE;
	}
	
	// Methode um Items aus Slots zurückzugeben
	@Override
	public ItemStack getStackInSlot(int i) {
		// gibt den ItemStack in Slot i zurück
		return inventory[i];
	}
	
	// Itemstack in jeweiligen Slot dezimieren
	@Override
	public ItemStack decrStackSize(int slotIndex, int decrementAmount) {
		// itemStack(fürs Zwischenspeichern) wird mit dem Slot in slotIndex überschrieben
		ItemStack itemStack = getStackInSlot(slotIndex);
		// Falls der itemStack existiert(ungleich null ist) :
		if (itemStack != null) {
			// ?
			if (itemStack.stackSize <= decrementAmount) {
				// ?
				setInventorySlotContents(slotIndex, null);
			}
			else {
				// ?
				itemStack = itemStack.splitStack(decrementAmount);
				// Falls itemStack gleich null ist wird nichts abgezogen
				if (itemStack.stackSize == 0) {
					//?
					setInventorySlotContents(slotIndex, null);
	    			}
	    		}
			}
		// gibt den neuen ItemStack zurück
		return itemStack;
	}
	
	// ? 
	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex) {
	// Falls ein Inventar in inventory[slotIndex] existiert:
	if (inventory[slotIndex] != null) {
		// itemStack wird in dem Inventar in inventory[slotindex] zwischengespeichert
		ItemStack itemStack = inventory[slotIndex];
		// inventory[slotIndex] wird gelöscht
		inventory[slotIndex] = null;
		// itemStack wird zurückgegeben
		return itemStack;
	}
	else
		// Sonst wird nichts zurückgegeben
	    return null;
	}
	
	// Items in jeweilige Slots fügen
	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack itemStack) {
		// itemStack wird in inventory[slotIndex] zwischengespeichert
	    inventory[slotIndex] = itemStack;
	    // Falls der itemStack existiert und die Stackgröße kleiner ist als das Limit des Inventars (bei 64 eigentlich nicht möglich):
	    if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
	        // Der Itemstack wird auf passende Größe geändert
	        itemStack.stackSize = this.getInventoryStackLimit();
	    }
	    // Funktion wird aufgerufen, da das Inventar geändert wurde
	    this.onInventoryChanged();
	}
	
	// Gibt den Namen des Inventars zurück
	public String getInvName() {
		// Falls ein eigener Name existiert wird dieser Zurückgegeben sonst wird "container.AM:architectTable" zurückgegeben
		return this.hasCustomName() ? this.getCustomName() : "container.AM:architectTable";
	}
	
	// gibt an wie Goß die einzelnen Stacks sein dürfen
	@Override
	public int getInventoryStackLimit() {
		// Maximale Stackgröße (Standart = 64)
		return 64;
	}
	
	// Zurzeit unnötige Methode, da ich da keinen SInn drin sehe :D
	public void openChest() {
	}

	// Zurzeit unnötige Methode, da ich da keinen SInn drin sehe :D
	public void closeChest() {
	}
	
	// auslesen der Speicherdatei von Minecraft level.dat
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
    	// Ausführen des Konstruktors der Oberklasse
        super.readFromNBT(nbtTagCompound);
       
        // Auslesen der Items in der gespeicherten TileArchitectTable aus dem NBT-Format
        NBTTagList tagList = nbtTagCompound.getTagList("Items");
        // inventory wird als Zwischenspeicher für Items festgelegt, mit der maximalen Anzahl an ItemStacks
        inventory = new ItemStack[this.getSizeInventory()];
        // für i am Start = 0 und i kleiner als die Anzahl der tagCompunds in der tagList : {Programmblock} zähle i hoch (klingt vll ein bisschen blöd aber SCHREIBS BESSER! :D )
        for (int i = 0; i < tagList.tagCount(); ++i) {
        	// tagCompund wird aus der tagList an Stelle i ausgelesen
            NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
            // slotIndex wird aus dem tagCompund ausgelesen (was das & 255 soll weiß ich nicht)
            int slotIndex = tagCompound.getByte("Slot") & 255;
            // Falls der slotIndex größer oder gleich 0 ist und kleiner ist als die Länge des inventars :
            if (slotIndex >= 0 && slotIndex < inventory.length) {
            	// Ein ItemStack wird aus dem tagCompund ausgelesen und in inventory[slotIndex]
                inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
                
            }
        }
        // Die Funktion wird so oft ausgelöst bis i = der Menge der tagCompund's in der tagList ist
    }
    
    // speichern der TileArchitectTable
    public void writeToNBT(NBTTagCompound TagCompound) {
    	// Ausführen des Konstruktors der Oberklasse
        super.writeToNBT(TagCompound);
        
        // Neue tagList erstellen um dort Items zu speichern
        NBTTagList tagList = new NBTTagList();
        // guck nach oben ist fast das gleiche Prinzip man muss nur for-Schleifen verstanden haben
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex) {
        	// Falls der ItemStack in inventory[currentIndex] existiert:
            if (inventory[currentIndex] != null) {
            	//Neues tagCompund anlegen um dort Daten zu speichern
                NBTTagCompound tagCompound = new NBTTagCompound();
                // Die Slot Daten in der tagCompund speichern
                tagCompound.setByte("Slot", (byte) currentIndex);
                // Den Itemstack ind inventory[currentIndex] im tagCompund speichern
                inventory[currentIndex].writeToNBT(tagCompound);
                // Der tagList den gerade erstellten tagCompund hinzufügen
                tagList.appendTag(tagCompound);
            }
        }
        // Dem TagCompund Parameter die tagList und deren "Name" (oder so) hinzufügen
        TagCompound.setTag("Items", tagList);

    }
    
    // Falls ein InventarName existiert
 	public boolean isInvNameLocalized() {
 		// gibt an ob ein eigener Name existiert
 		return this.hasCustomName();
 	}
	 
	// gibt an ob ein eigener Name existiert
	public boolean hasCustomName() {
		// Wenn die Variable costumName existiert und länger ist als 0 Stellen dann true sonst false
		return customName != null && customName.length() > 0;
	}
	 
	// gibt den eigenen Namen zurück
	public String getCustomName() {
		// gibt den eigenen Namen zurück 
		return customName;
	}

	// Methode um den eigenen Namen der TileEntity ändert
	public void setCustomName(String displayName) {
		// überschreibt costumName mit dem Parameter displayName
		customName = displayName;
	}

	// gibt an ob der Spieler diese TileEntity aufrufen kann
	@Override
	public boolean isUseableByPlayer(EntityPlayer player){
		// prüft ob der Spieler nicht zu weit weg ist, um die Kiste zu öffnen
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
		}

	// ob diese Items in den Slot passen
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// Es dürfen alle Items in alle Slots
		return true;
	}
	
	// ? tja keine ahnung wofür die gebraucht wird aber irgendwie wird die noch gebraucht
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString());

        stringBuilder.append("TileArchitectTable Data - ");
        for (int i = 0; i < inventory.length; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }

            if (inventory[i] != null) {
                stringBuilder.append(String.format("inventory[%d]: %s", i, inventory[i].toString()));
            }
            else {
                stringBuilder.append(String.format("inventory[%d]: empty", i));
            }
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
    
}
