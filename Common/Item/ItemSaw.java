package Item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * 
 * To-Do: Textur einbasteln :D
 *
 */

public class ItemSaw extends Item{
	// Konstruktor des Items
	public ItemSaw(int par1) {
		// Konstruktor der Oberklasse ausf�hren
		super(par1);
		// Sonstige Werte und Eigenschaften festlegen
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
		setUnlocalizedName("Saw");
		
	}

}
