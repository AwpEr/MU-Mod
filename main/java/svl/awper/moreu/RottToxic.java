package svl.awper.moreu;

import scala.xml.dtd.impl.WordBerrySethi;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class RottToxic extends ItemFood{

	public RottToxic(int hunger, float saturation, boolean isWolfEated) {
		super(hunger, saturation, isWolfEated);
		// TODO Add a potion effect
	}
	
	protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityPlayer){
		entityPlayer.addPotionEffect(new PotionEffect(Potion.weakness.id, 500, 4)); //Potion Effect, Duration, Amplifier, Ambient
		entityPlayer.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 1200, 2)); //Potion Effect, Duration, Amplifier, Ambient
		entityPlayer.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 2)); //Potion Effect, Duration, Amplifier, Ambient
	}

}
