package svl.awper.moreu;

import javafx.scene.control.Tab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = "mu", name = "More Uses", version ="1.0")
public class Main {
	
	public static Block rottBlock;
	public static Item rottToxic; 

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Item/Block init and regestering
		//Config Handlings
		
		rottBlock = new RottBlock(Material.clay).setBlockName("BlockRott").setBlockTextureName("mu:blockrott").setHardness(1.5F).setStepSound(Block.soundTypeSnow);
	    rottToxic = new RottToxic(1, 0.8F, false).setUnlocalizedName("ToxicRott").setCreativeTab(CreativeTabs.tabFood).setTextureName("mu:toxicrott");
		
		GameRegistry.registerBlock(rottBlock, rottBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(rottToxic, rottToxic.getUnlocalizedName().substring(5));

	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		//Proxy, TileEntity, entity, GUI and Packet Registering

		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		//
	}
}