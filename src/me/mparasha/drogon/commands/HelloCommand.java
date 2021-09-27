package me.mparasha.drogon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.mparasha.drogon.Main;

public class HelloCommand implements CommandExecutor{
	//private Main plugin;
	
	public HelloCommand(Main plugin) {
		//this.plugin = plugin;
		plugin.getCommand("hello").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Only players may execute this command!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(p.hasPermission("hello.use")) {
			p.sendMessage("Hey!");
			return true;
		}
		else {
			p.sendMessage("You do not have permission to use this command!");
		}
		
		return false;
	}
}
