package me.skierdude101;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;


/**
 * @author Ryan.Chen19
 *
 */
public class Recipes {
	public static ShapedRecipe getRodRecipe(){
		ShapedRecipe rodRecipe = new ShapedRecipe(Items.lightningRod);
		rodRecipe.shape(" * ", "!*!", "?*?");
		rodRecipe.setIngredient('*', Material.BONE);
		rodRecipe.setIngredient('!', Material.EMERALD);
		rodRecipe.setIngredient('?', Items.lightningStick.getData());
		return rodRecipe;
	}
	
	public static ShapedRecipe getWallRecipe(){
		ShapedRecipe wallRecipe = new ShapedRecipe(Items.lightningWall);
		wallRecipe.shape(" * ", "!*!", "?*?");
		wallRecipe.setIngredient('*', Material.BONE);
		wallRecipe.setIngredient('!', Material.EMERALD_BLOCK);
		wallRecipe.setIngredient('?', Items.lightningRod.getData());
		return wallRecipe;
	}
	
	public static ShapedRecipe getStickRecipe(){
		ShapedRecipe stickRecipe = new ShapedRecipe(Items.lightningStick);
		stickRecipe.shape(" * ","!*!","?*?");
		stickRecipe.setIngredient('*', Material.BONE);
		stickRecipe.setIngredient('!', Material.STICK);
		stickRecipe.setIngredient('?', Material.DIAMOND);
		return stickRecipe;
	}
	
	public static ShapedRecipe getRainRecipe(){
		ShapedRecipe rainRecipe = new ShapedRecipe(Items.rainStick);
		rainRecipe.shape(" * ","!*!","?*?");
		rainRecipe.setIngredient('*', Material.BONE);
		rainRecipe.setIngredient('!', Material.WATER_BUCKET);
		rainRecipe.setIngredient('?', Material.EMERALD_BLOCK);
		return rainRecipe;
	}
	
	public static ShapedRecipe getFireRecipe(){
		ShapedRecipe fireRecipe = new ShapedRecipe(Items.fireStaff);
		fireRecipe.shape(" * ","!*!","?*?");
		fireRecipe.setIngredient('*', Material.BONE);
		fireRecipe.setIngredient('?', Material.LAVA_BUCKET);
		fireRecipe.setIngredient('!', Material.EMERALD_BLOCK);
		return fireRecipe;
	}
	
	public static void setRecipes() {
		Bukkit.addRecipe(getRodRecipe());
		Bukkit.addRecipe(getWallRecipe());
		Bukkit.addRecipe(getStickRecipe());
		Bukkit.addRecipe(getRainRecipe());
		Bukkit.addRecipe(getFireRecipe());	
	}
	

	
}
