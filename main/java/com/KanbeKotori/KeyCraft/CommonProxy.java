/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * 本作品版权由Nulla开发组所有。
 * Developed by Kanbe-Kotori & xfgryujk.
 * 本作品由 Kanbe-Kotori & xfgryujk 合作开发。
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package com.kanbekotori.keycraft;

import com.kanbekotori.keycraft.*;
import com.kanbekotori.keycraft.helper.MainHelper;
import com.kanbekotori.keycraft.items.*;
import com.kanbekotori.keycraft.network.RewriteNetwork;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		
	}
	 
	public void init(FMLInitializationEvent event) {
		// 注册网络事件
		FMLCommonHandler.instance().bus().register(new RewriteNetwork.SendSyncPacket());
		RewriteNetwork.rewriteChannel = NetworkRegistry.INSTANCE.newEventDrivenChannel(RewriteNetwork.REWRITE_CHANNEL);
		RewriteNetwork.rewriteChannel.register(new RewriteNetwork());
	}
	 
	public void postInit(FMLPostInitializationEvent event) {

	}
	
}
