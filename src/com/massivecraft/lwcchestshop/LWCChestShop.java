package com.massivecraft.lwcchestshop;

import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.griefcraft.lwc.LWC;

public class LWCChestShop extends JavaPlugin
{
	private Logger logger = Logger.getLogger("LWC-ChestShop");

	/**
	 * Initialize LWCChestShop
	 */
	public void init()
	{
		LWC.getInstance().getModuleLoader().registerModule(this, new LWCChestShopModule(this));
		log("Hooked into LWC!");
	}

	@Override
	public void onEnable()
	{
		Plugin lwc = getServer().getPluginManager().getPlugin("LWC");

		if (lwc != null)
		{
			init();
		}
		else
		{
			log("Waiting for LWC to be enabled...");
		}
	}

	private void log(String message)
	{
		logger.info("LWC-ChestShop: " + message);
	}
	
}
