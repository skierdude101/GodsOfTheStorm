package me.skierdude101;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GodsOfTheStorm extends JavaPlugin{
	
	public Permission playerPermission = new Permission("playerAbilities.allowed");
	
	@Override
	public void onEnable() {
		new BlockListener(this);
		PluginManager pm = getServer().getPluginManager();
		pm.addPermission(playerPermission);
		this.getCommand("addLightningRod").setExecutor(new Commands());
		this.getCommand("addLightningStick").setExecutor(new Commands());
		this.getCommand("addLightningWall").setExecutor(new Commands());
		this.getCommand("addRainStick").setExecutor(new Commands());
		this.getCommand("addFireStaff").setExecutor(new Commands());
		new Recipes();
		Recipes.setRecipes();
	}

	@Override
	public void onDisable() {
		
	}
	
}
