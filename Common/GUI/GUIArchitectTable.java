package GUI;

import lib.reference;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Inventory.ContainerArchitectTable;
import Tile.TileArchitectTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.StatCollector;

/**
 * 
 * To-Do: Kommentare beenden und ResourceLocation Korigieren
 *
 */

// Nur der Client braucht den Gui darzustellen (macht auch sonst keinen Sinn) 
@SideOnly(Side.CLIENT)
public class GUIArchitectTable extends GuiContainer{
	// lokales tileArchitectTable erstellen
	private TileArchitectTable tileArchitectTable;
	
	//Konstruktor des Gui's
	public GUIArchitectTable(InventoryPlayer inventoryPlayer, TileArchitectTable AtileArchitectTable) {
		// Konstruktor der Oberklasse ausführen mit dem ContainerArchitectTable
		super(new ContainerArchitectTable(inventoryPlayer, AtileArchitectTable));
		// lokale tileArchitectTable wird mit dem Parameter AtileArchitectTable
		tileArchitectTable = AtileArchitectTable;
		// Höhe und Breite der GUI festlegen
		xSize = 248;
        ySize = 186;

        

	}

	// den Hintergrund des Gui zeichnen
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		// Zwei notwendige Funktionen die ich noch nicht ganz verstanden habe also ?
		fontRenderer.drawString("Architect Table", 8, 6, 4210752);		
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 44, ySize - 96 + 2, 4210752);
    }
	
	// Vordergrund der Gui zeichnen
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		// Notwendige Funktion, die ich noch nicht ganz verstanden habe also ?
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		// Dem Minecraft Textur Manager die ResourceLocation der Gui mitteilen
        this.mc.getTextureManager().bindTexture(reference.GUI_ARCHITECT_TABLE);
        // Oben links und rechts des GUI's festlegen
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        // Rechteck für Gui zeichnen
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
		
	}

}
