package me.skierdude101;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;
import org.bukkit.inventory.ItemStack;

public class BlockListener implements Listener{
	
	public BlockListener(GodsOfTheStorm plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onCraftRod(CraftItemEvent e){
		Player player = (Player) e.getWhoClicked();
		player.sendMessage("Crafting Something!");
		player.sendMessage(Recipes.getRodRecipe().getResult().getType().toString());
		player.sendMessage(e.getRecipe().getResult().getType().toString());
		if(e.getRecipe().getResult().getType().equals(Recipes.getRodRecipe().getResult().getType())){
			player.sendMessage("Inventory Test Happened!");
			ItemStack lightningStick = e.getInventory().getMatrix()[6];
			ItemStack lightningStick2 = e.getInventory().getMatrix()[8];
			player.sendMessage("stick happened!");
			if(!lightningStick.equals(null) || lightningStick2.equals(null)){
				if(lightningStick.hasItemMeta() && lightningStick2.hasItemMeta()){
					player.sendMessage("Test Happened!");
					if(lightningStick.getItemMeta().getDisplayName().equals("Lightning Stick") && lightningStick2.getItemMeta().getDisplayName().equals("Lightning Stick")){
						player.sendMessage("Perfect!");
						return;
					}
				}
				e.setCancelled(true);
				e.getInventory().setResult(new ItemStack(Material.AIR));
				e.getInventory().setResult(null);
				e.setResult(null);
				player.sendMessage("Wrong Materials!");
			}
		}
	}
	@EventHandler
	public void onCraftWall(CraftItemEvent e){
		if(e.getRecipe().getResult().getType().equals(Recipes.getWallRecipe().getResult().getType())){
			ItemStack lightningStick = e.getInventory().getMatrix()[6];
			ItemStack lightningStick2 = e.getInventory().getMatrix()[8];
			if(!lightningStick.equals(null) || lightningStick2.equals(null)){
				if(lightningStick.hasItemMeta() && lightningStick2.hasItemMeta()){
					if(lightningStick.getItemMeta().getDisplayName().equals("Lightning Rod") && lightningStick2.getItemMeta().getDisplayName().equals("Lightning Rod")){
						return;
					}
				}
				e.setCancelled(true);
				e.getInventory().setResult(new ItemStack(Material.AIR));
				e.getInventory().setResult(null);
				e.setResult(null);
			}
		}
	}

	@EventHandler
	public void onBlockPlace(PlayerMoveEvent e) {
		
		Player player = e.getPlayer();
		if(!player.hasPermission("playerAbilities.allowed")){
			e.setCancelled(true);
		}
		
	}
	@EventHandler
	public void shortRangeLightning(PlayerInteractEvent e){
		if(e.getClickedBlock()!=null){
			Player player = e.getPlayer();
			if(player.getInventory().getItemInMainHand().isSimilar(Items.lightningStick)){
				Block target = e.getClickedBlock();
				Vector vec = new Vector(target.getX(),target.getY(),target.getZ());
				World pWorld  = player.getWorld();
				player.getWorld().strikeLightning(vec.toLocation(pWorld));
			}
		}
			
		
	}
	
	
	@EventHandler
    public void wallOfLightning (PlayerAnimationEvent e){


         if (e.getAnimationType() == PlayerAnimationType.ARM_SWING) {
        	 Player player = e.getPlayer();
             if (player.getInventory().getItemInMainHand() != null){ 
             if (player.getInventory().getItemInMainHand().isSimilar(Items.lightningWall)){
            	 Location loc = player.getLocation();
                 Vector direction = loc.getDirection();
                 for(double t = 0; t < 100; t+=1){
                	 
                    loc.add(direction);
                    loc.add(0, 1.5, 0);
                    
                    if (loc.getBlock().getType().isSolid()){
                    	player.getWorld().strikeLightning(loc);
                        break;
                    }
                    
                    else {
                       Location land = new Location(player.getWorld(),loc.getX(),player.getWorld().getHighestBlockYAt(loc),loc.getZ());
                       player.getWorld().strikeLightning(land);
                    }         
                    
                    loc.subtract(0, 1.5, 0);
                 }
              }
              }
         }
    }
	
	@EventHandler
    public void singleLightning (PlayerAnimationEvent e){
		if (e.getAnimationType() == PlayerAnimationType.ARM_SWING) {
			Player player = e.getPlayer();

			if (player.getInventory().getItemInMainHand() != null){ 
				if (player.getInventory().getItemInMainHand().isSimilar(Items.lightningRod)){      
					Location loc = player.getLocation();
					Vector direction = loc.getDirection();
					for(double t = 0; t < 100; t+=1){
						
						loc.add(direction);
						loc.add(0, 1.5, 0);
						
						if (loc.getBlock().getType().isSolid()){
							player.getWorld().strikeLightning(loc);
							break;
						}         
						
						loc.subtract(0, 1.5, 0);
					}
					
					Location land = new Location(player.getWorld(),loc.getX(),player.getWorld().getHighestBlockYAt(loc),loc.getZ());
					player.getWorld().strikeLightning(land);
				}
			}
		}
	}
	
	@EventHandler
	public void rainStick(PlayerAnimationEvent e){
		if(e.getAnimationType() == PlayerAnimationType.ARM_SWING){
			Player player = e.getPlayer();
			World world = player.getWorld();
			if(player.getInventory().getItemInMainHand().isSimilar(Items.rainStick) && !world.hasStorm()){
				world.setStorm(true);
			}
			else if(player.getInventory().getItemInMainHand().isSimilar(Items.rainStick) && world.hasStorm()){
				world.setStorm(false);
			}
		}
	}
	
	@EventHandler
	public void fireBall(PlayerAnimationEvent e){
		if(e.getAnimationType()==PlayerAnimationType.ARM_SWING){
			Player player = e.getPlayer();
			//World world = player.getWorld();
			if(player.getInventory().getItemInMainHand()!=null){
				if(player.getInventory().getItemInMainHand().isSimilar(Items.fireStaff)){
					Location loc = player.getLocation();
					Vector direction = loc.getDirection();
					for(double t = 0; t<50;t++){
						
						loc.add(direction);
						loc.add(0,1.5,0);
						player.spawnParticle(Particle.DRIP_LAVA ,loc.getX(),loc.getY(),loc.getZ(),3);
						player.spawnParticle(Particle.EXPLOSION_NORMAL ,loc.getX(),loc.getY(),loc.getZ(),1);
						player.spawnParticle(Particle.FLAME ,loc.getX(),loc.getY(),loc.getZ(),1);
						if(loc.getBlock().getType().isSolid()){
							Block block = loc.getBlock();
							Block riseOne = block.getRelative(0 , 1 , 0);
							riseOne.setType(Material.FIRE);
							break;
						}
						loc.subtract(0,1.5,0);
						
					}
				}
			}
			
		}
	}
}
