package me.mparasha.drogon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftEnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import me.mparasha.drogon.Main;



public class DrogonCommand implements CommandExecutor{
	//private Main plugin;
	
	public DrogonCommand(Main plugin) {
		//this.plugin = plugin;
		plugin.getCommand("drogon").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Only players may execute this command!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(p.hasPermission("drogon.use")) {
			// IMPLEMENTATION TO RIDE ENDER DRAGON
			World w = Bukkit.getServer().getWorld("World");
			Location l = new Location(w, 0, 100, 0);
	        CraftEnderDragon de = (CraftEnderDragon) w.spawnEntity(l, EntityType.ENDER_DRAGON);
			de.addPassenger(p);
			return true;
		}
		else {
			p.sendMessage("You do not have permission to use this command!");
		}
		
		return false;
	}
}
