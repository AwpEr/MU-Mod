package svl.awper.moreu;

import javafx.scene.control.Tab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = "mu", name = "More Uses", version ="1.0")
public class Main {
	
	//Materials
	public static ToolMaterial zombiMaterial = EnumHelper.addToolMaterial("Zombi Material", 0, 500, 30.0F, 1.0F, 7);
	
	//Blocks
	public static Block rottBlock;
	
	//Items
	public static Item rottToxic; 
	
	//Tools
	public static Item zombiPickaxe;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Item/Block init and registering
		//Config Handling
		
		//Blocks
		rottBlock = new RottBlock(Material.clay).setBlockName("BlockRott").setBlockTextureName("mu:blockrott").setHardness(1.5F).setStepSound(Block.soundTypeSnow);
		
		//Items
	    rottToxic = new RottToxic(1, 0.8F, false).setUnlocalizedName("ToxicRott").setCreativeTab(CreativeTabs.tabFood).setTextureName("mu:toxicrott");
	    
	    //Tools
		zombiPickaxe = new ZombiePickaxe(zombiMaterial).setUnlocalizedName("ZombiPickaxe").setCreativeTab(CreativeTabs.tabTools).setTextureName("mu:pickaxezombie");
	    
	    //Registry
		GameRegistry.registerBlock(rottBlock, rottBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(rottToxic, rottToxic.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(zombiPickaxe, zombiPickaxe.getUnlocalizedName().substring(5));

	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		//Proxy, TileEntity, entity, GUI and Packet Registering
		
		//Various leather crafting
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather), new Object[] {rottToxic, Items.water_bucket.setContainerItem(Items.bucket)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 3), new Object[] {rottToxic, rottToxic, rottToxic, Items.water_bucket.setContainerItem(Items.bucket)});
		GameRegistry.addRecipe(new ItemStack(Items.leather, 8), new Object[] {"TTT","TBT","TTT",'T', rottToxic, 'B', Items.water_bucket.setContainerItem(Items.bucket)});
		
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		//
	}
}