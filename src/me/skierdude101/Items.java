package me.skierdude101;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
	
	//Lightning Items
	public static ItemStack lightningRod = new ItemStack(Material.BONE);
	public static ItemStack lightningWall = new ItemStack(Material.BONE);
	public static ItemStack lightningStick = new ItemStack(Material.BONE);
	
	
	//Weather Items
	public static ItemStack rainStick = new ItemStack(Material.BONE);
	
	//Fire Items
	public static ItemStack fireStaff = new ItemStack(Material.BONE);
	
	static{
		ItemMeta rodMeta = lightningRod.getItemMeta();
		ItemMeta wallMeta = lightningWall.getItemMeta();
		ItemMeta stickMeta = lightningStick.getItemMeta();
		ItemMeta rainMeta = rainStick.getItemMeta();
		ItemMeta fireMeta = fireStaff.getItemMeta();
		
		rodMeta.setDisplayName("Lightning Rod");
		wallMeta.setDisplayName("Lightning Wall");
		stickMeta.setDisplayName("Lightning Stick");
		rainMeta.setDisplayName("Rain Stick");
		fireMeta.setDisplayName("Fire Staff");
		
		lightningRod.setItemMeta(rodMeta);
		lightningWall.setItemMeta(wallMeta);
		lightningStick.setItemMeta(stickMeta);
		rainStick.setItemMeta(rainMeta);
		fireStaff.setItemMeta(fireMeta);
	}

	
}
