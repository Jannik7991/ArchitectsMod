package Item;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemFireStick extends Item {
	
	public static Random rand;
	
	public ItemFireStick(int par1) {
		super(par1);
		setPotionEffect("regeneration");
		setMaxStackSize(1);
	}

	@Override
	public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count)
    {
		
			if (player.experienceLevel > 160) {
			
				if (player.getHealth() != 20) {
				
					player.addExperienceLevel(-160);
					player.heal(20);
				
				}
				else {
				
					player.addChatMessage("Player already at full health");
			
				}
			
			}
			else {
			
				player.addChatMessage("Not enough Mana");
			}
    }
	
}
