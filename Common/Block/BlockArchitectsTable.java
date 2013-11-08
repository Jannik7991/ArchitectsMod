package Block;

import lib.reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Mod.ArchitectsMod;
import Tile.TileArchitectTable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

/**
 * 
 * To-Do: Kommentare beenden und Texturen einbinden
 *
 */

public class BlockArchitectsTable extends BlockContainer{

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
	        this.blockIcon = par1IconRegister.registerIcon(reference.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	// Konstruktor des Blocks
	public BlockArchitectsTable(int par1) {
		// Ausführen des Konstruktors der Oberklasse
		super(par1, Material.wood);
		// CreativeTab des Blocks festlegen
		setCreativeTab(CreativeTabs.tabDecorations);
		// UnlocalizedName festlegen (Keine Ahnung wofür der später noch gebraucht wird. Könnte aber hilfreich sein
		setUnlocalizedName("ArchitectsTable");
	}
	
	// TileEntity des Blocks erstellen, zum Speichern des Inventars
	@Override
	public TileEntity createNewTileEntity(World world) {
		// Erstellen der TileArchitectTable
		TileArchitectTable Tile = new TileArchitectTable();
		// Zurückgeben der TileArchitectTable Tile
		return Tile;
	}

	// Wird aufgerufen wenn der Spieler den Block mit Rechtsklick auswählt
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		// Neue TileEntity erstellen
		this.createNewTileEntity(par1World);
		
		//Falls Spieler Shift drückt soll nichts weiter passieren
		if (par5EntityPlayer.isSneaking()) {
			return false;
		} 
		//Für den Fall das dem Öffnen nicht im Weg steht soll der GUI geöffnet werden
		else {
			// Dem Spieler einen Gui öffnen lassen mit den Parametern(Hauptklassenobjekt (keine Ahnung warum aber nötig), GuiId, x, y, z Koordinaten)		
			par5EntityPlayer.openGui(ArchitectsMod.instance, 0, par1World, par2, par3, par4);
			// Nötiger Rückgabewert der dem Spieler sagt, das der Rechtsklick erfolgreich war (oder so ähnlich)	
			return true;		
				
		}		
		
	}
	
	// Wird ausgelöst sobald der Block gesetzt wird
	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack) {
		// Falls der Block einen speziellen Namen hat
        if (itemStack.hasDisplayName()) {
        	// CostumName des TileArchitectTable's durch speziellen Namen ersetzen ( was genau das soll weiß ich nicht )
            ((TileArchitectTable) world.getBlockTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
        }
        // Hauptgrund warum die Funktion wichtig ist: Die TileEntity des Blocks wird erstellt
        this.createNewTileEntity(world);

    }
	
}
