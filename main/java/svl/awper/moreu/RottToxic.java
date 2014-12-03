package svl.awper.moreu;

import java.util.Random;

import scala.xml.dtd.impl.WordBerrySethi;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class RottToxic extends ItemFood{
	
	private Random chanse = new Random();
	private int potionnum;

	public RottToxic(int hunger, float saturation, boolean isWolfEated) {
		super(hunger, saturation, isWolfEated);
		// TODO Add a potion effect
		//Potion Effect, Duration, Amplifier, Ambient
	}
	
	protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityPlayer){
		if(!world.isRemote){
			entityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 600, 0));
			potionnum = chanse.nextInt(3);
			switch (potionnum) {
				case 0 :entityPlayer.addPotionEffect(new PotionEffect(Potion.weakness.id, 500, 4));//500
						break;
				case 1 :entityPlayer.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 500, 3));//1200
						break;
				case 2 :entityPlayer.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 500, 3));//600
						break;
			}
		}
	}

}
