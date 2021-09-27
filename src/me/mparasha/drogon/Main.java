package me.mparasha.drogon;

import org.bukkit.plugin.java.JavaPlugin;

import me.mparasha.drogon.commands.DrogonCommand;
import me.mparasha.drogon.commands.HelloCommand;

public class Main extends JavaPlugin {
	@Override
	public void onEnable(){
		new HelloCommand(this);
		new DrogonCommand(this);
	}
}
