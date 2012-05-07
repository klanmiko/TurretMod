package com.incognitodev.TurretMod;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TurretModPlugin extends JavaPlugin{
	Logger log;
	TurretModBlockListener tmbl;
	ArrayList<TurretModTurret> turrets = new ArrayList<TurretModTurret>();
	int currentindex = 0;
	public void onEnable(){
		log = this.getLogger();
		log.info("turrets enabled");
		tmbl = new TurretModBlockListener(this);
	}
	public void onDisable(){
		
	}
	public void createturret(Block head, Player owner, Block sign, TurretType type)
	{
		TurretModTurret newturret;
		TurretModLocation heady, signy;
		Location headx = head.getLocation();
		Location signx = sign.getLocation();
		heady = new TurretModLocation(headx.getX(),headx.getY(),headx.getZ());
		signy = new TurretModLocation(signx.getX(),signx.getY(),signx.getZ());
		newturret = new TurretModTurret(owner.getName(),heady,type,signy);
		turrets.add(newturret);
	}
	public boolean Turretexists(Location sign)
	{
		for(int y=0; y<=turrets.size(); y++)
		{
			if (turrets.get(y).signLocation.equals(sign.getX(), sign.getY(), sign.getZ()))
			{
				return true;
			}
		}
		return false;
	}
	public void removeTurret(Location sign)
	{
		for(int i=0; i<=turrets.size(); i++)
		{
			if (turrets.get(i).signLocation.equals(sign.getX(), sign.getY(), sign.getZ()))
			{
				turrets.remove(i);
			}
		}
	}
	public TurretModTurret getTurretAt(Location sign)
	{
			for(int y=0; y<=turrets.size(); y++)
			{
				if (turrets.get(y).signLocation.equals(sign.getX(), sign.getY(), sign.getZ()))
				{
					return turrets.get(y);
				}
			}
			return null;
	}
}
