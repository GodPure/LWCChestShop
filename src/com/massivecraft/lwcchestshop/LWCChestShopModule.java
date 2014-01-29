package com.massivecraft.lwcchestshop;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import com.Acrobot.ChestShop.Plugins.ChestShop;
import com.griefcraft.lwc.LWC;
import com.griefcraft.scripting.JavaModule;
import com.griefcraft.scripting.event.LWCProtectionRegisterEvent;

public class LWCChestShopModule extends JavaModule
{
	/**
	 * The bukkit plugin
	 */
	@SuppressWarnings("unused")
	private LWCChestShop plugin;
	
	/**
	 * The LWC object, set by load ()
	 */
	@SuppressWarnings("unused")
	private LWC lwc;

	public LWCChestShopModule(LWCChestShop plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public void onRegisterProtection(LWCProtectionRegisterEvent event)
	{
		if (isOwner(event.getPlayer(), event.getBlock())) return;
		event.setCancelled(true);
	}
	
	public static boolean isOwner(Player player, Block block)
	{
		return ChestShop.canAccess(player, block);
	}
	
}
