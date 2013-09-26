package Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockArchitectsTable extends Block{

	public BlockArchitectsTable(int par1) {
		super(par1, Material.wood);
		setCreativeTab(CreativeTabs.tabDecorations);
		setUnlocalizedName("ArchitectsTable");
	}

}
