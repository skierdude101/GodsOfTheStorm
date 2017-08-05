package me.skierdude101;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{

	public Commands(){
		
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if(cmd.getName().equalsIgnoreCase("addLightningRod") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(player.hasPermission("playerAbilites.allowed")){
				player.getInventory().addItem(Items.lightningRod);
				player.sendMessage("Given Lightning Rod");
			}
			
			return true;
			
		}

		if(cmd.getName().equalsIgnoreCase("addLightningStick") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(player.hasPermission("playerAbilites.allowed")){
				player.getInventory().addItem(Items.lightningStick);
				player.sendMessage("Given Lightning Stick");
			}
			
			return true;
			
		}

		if(cmd.getName().equalsIgnoreCase("addLightningWall") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(player.hasPermission("playerAbilites.allowed")){
				player.getInventory().addItem(Items.lightningWall);
				player.sendMessage("Given Lightning Wall");
			}
			
			return true;
			
		}
		if(cmd.getName().equalsIgnoreCase("addFireStaff") && sender instanceof Player) {
			Player player = (Player) sender;
					
			if(player.hasPermission("playerAbilities.allowed")){
				player.getInventory().addItem(Items.fireStaff);
				player.sendMessage("Given Fire Staff");
			}
			
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("addRainStick") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(player.hasPermission("playerAbilites.allowed")){
				player.getInventory().addItem(Items.rainStick);
				player.sendMessage("Given Rain Stick");
			}
			
			return true;
			
		}
		
		
		else{
			return false;
		}
	}

}
