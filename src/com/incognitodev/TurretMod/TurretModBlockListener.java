package com.incognitodev.TurretMod;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;

public class TurretModBlockListener implements Listener{
	public TurretModPlugin parent;
	public int turretindex = 0;
    public TurretModBlockListener(TurretModPlugin p)
    {
    	parent = p;
    	parent.getServer().getPluginManager().registerEvents(this,parent);
    }
	@EventHandler
	public void onSignForTurretPlaced(SignChangeEvent e)
	{
		String text = e.getLine(0);
		Player player = e.getPlayer();
		Block sign = e.getBlock();
		if(text.startsWith("tm Turret")){
			if (text.equalsIgnoreCase("tm TurretPistol"))
			{
				if(checkifturret(sign,sign.getWorld(),player, TurretType.PISTOL)){
					parent.log.info("pistol turret created by " + player);
				}
			
			}
		if (text.equalsIgnoreCase("tm TurretMG"))
		{
			if(checkifturret(sign,sign.getWorld(),player, TurretType.MG)){		
				parent.log.info("MG turret created by " + player);
			}
		}
		if (text.equalsIgnoreCase("tm TurretSniper"))
		{
			if(checkifturret(sign,sign.getWorld(),player, TurretType.SNIPER)){
				parent.log.info("Sniper turret created by " + player);
			}
		}
		if (text.equalsIgnoreCase("tm TurretSmg"))
		{
				if(checkifturret(sign,sign.getWorld(),player, TurretType.SMG)){
				parent.log.info("SMG turret created by " + player);
			}
		}
		}
		else if(parent.Turretexists(sign.getLocation())){
			if(!text.startsWith("tmTurret"))
			{
				parent.removeTurret(sign.getLocation());
				parent.log.info("turret removed");
			}
		}
	}
	@EventHandler
	public void onSignForTurretBreak(BlockBreakEvent e)
	{
		Block sign = e.getBlock();
		if(sign.getType()==Material.WALL_SIGN)
		{
			parent.log.info("sign at" + sign.getLocation());
			if(parent.Turretexists(sign.getLocation()))
			{
				TurretModTurret tmt = parent.getTurretAt(sign.getLocation());
				parent.log.info("turret at" +tmt.turretLocation.x);
				World world = sign.getWorld();
				Block head = world.getBlockAt((int)tmt.turretLocation.x,(int)tmt.turretLocation.y,(int)tmt.turretLocation.z);
				Block body = world.getBlockAt((int)tmt.turretLocation.x,(int)tmt.turretLocation.y -1,(int)tmt.turretLocation.z);
				head.breakNaturally();
				body.breakNaturally();
				parent.removeTurret(sign.getLocation());
				parent.log.info("turret removed");
			}
		}
	}
	public boolean checkifturret(Block sign, World world, Player player, TurretType type)
	{
		Block possibleTurret;
		possibleTurret = TurretModTurretFinder.isTurretBehindSign(sign);
		if(possibleTurret != null)
		{
				parent.log.info("possible turret");
				Block secondblock = world.getBlockAt(possibleTurret.getX(), possibleTurret.getY() - 1, possibleTurret.getZ());
				if(secondblock.getType() == Material.WOOD)
				{
					parent.log.info("turret confirmed");
					parent.log.info("turret at " +sign.getX() +" " +sign.getY() +" " +sign.getZ());
					parent.createturret(possibleTurret, player, sign, type);
					return true;
				}
		}
			else
			{
				return false;
			}
		return false;
		
	}
}
