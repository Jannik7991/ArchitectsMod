package Item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSaw extends Item{

	public ItemSaw(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
		setUnlocalizedName("Saw");
		
	}

}
