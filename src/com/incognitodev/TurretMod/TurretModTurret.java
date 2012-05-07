package com.incognitodev.TurretMod;

public class TurretModTurret {
    public String owner;
    public TurretModLocation turretLocation;
    public TurretModLocation signLocation;
    public int Health = 20;
    public TurretType type;
    public TurretModTurret (String player, TurretModLocation topblock, TurretType type, TurretModLocation sign)
    {
    	owner = player;
    	turretLocation = topblock;
    	this.type = type;
    	signLocation = sign;
    }
    public boolean Damage (int damage)
    {
    	this.Health -= damage;
    	if (Health < 0)
    	{
    		return false;
    	}
    	else{
    		return true;
    	}
    }
    public void Heal (int healing)
    {
    	this.Health += healing;
    	if (Health > 20)
    	{
    		Health = 20;
    	}
    }
    
}
