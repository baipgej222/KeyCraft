package com.KanbeKotori.KeyCraft.Event;

import com.KanbeKotori.KeyCraft.KeyCraft;
import com.KanbeKotori.KeyCraft.Helper.MainHelper;
import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class SubscribeShakingSwordUsing {
	
	private MainHelper mainhelper = new MainHelper();
	private RewriteHelper rwhelper = new RewriteHelper();
	
	@SubscribeEvent
	public void ShakingSword_Recycle(PlayerTickEvent event) {
		String name = mainhelper.getName();
		EntityPlayer player = mainhelper.getPlayerSv(name);
		ItemStack itemstacks[] = new ItemStack[36];
		ItemStack held = player.getHeldItem();
		
		for (int i=0; i<36; i++) {
			if ((itemstacks[i] = player.inventory.mainInventory[i]) != null) {
				if (itemstacks[i].getItem() == KeyCraft.PointShakingSword) {
					if (held != itemstacks[i]) {
						player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.useshakingsword")));
			            player.inventory.mainInventory[i] = new ItemStack(Items.iron_sword, rwhelper.getShakingSwordDamage(player));
					}
				}	
			}
		}
		
	}
	
	@SubscribeEvent
    public void usedShakingSword(EventOnShakingSwordUse event)
    {
		String name = mainhelper.getName();
		EntityPlayer player = mainhelper.getPlayerSv(name);
		ItemStack itemstacks[] = new ItemStack[36];
		ItemStack held = player.getHeldItem();
		for (int i=0; i<36; i++) {
			if ((itemstacks[i] = player.inventory.mainInventory[i]) != null) {
				if (itemstacks[i].getItem() == KeyCraft.PointShakingSword) {
					player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("keycraft.prompt.useshakingsword")));
			        player.inventory.mainInventory[i] = new ItemStack(Items.iron_sword, 1, rwhelper.getShakingSwordDamage(player));
				}	
			}
		}
    }

}
