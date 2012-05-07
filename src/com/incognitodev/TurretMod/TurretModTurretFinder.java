package com.incognitodev.TurretMod;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;

public class TurretModTurretFinder {
	public static Block isTurretBehindSign(Block sign)
	{
	Block possibleturret;
	BlockFace faces[] = {BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST};
	for(BlockFace bf : faces)
	{
		possibleturret = sign.getRelative(bf, -1);
		if(possibleturret.getType() == Material.WOOD)
		{
			return possibleturret;
		}
		else
		{
		}
	}
	return null;
	}
	public static String isSignInFrontTurret(Block Turret, World world)
	{
		Sign possibleSign;
		BlockFace faces[] = {BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST};
		for(BlockFace bf : faces)
		{
			possibleSign = (Sign) Turret.getRelative(bf, 1);
			if(possibleSign.getType() == Material.WALL_SIGN)
			{
				if(possibleSign.getLine(1).startsWith("tm Turret"))
				{
					return possibleSign.getLine(1);
				}
			}
			else{
				return null;
			}
		}
		return null;
	}
}
