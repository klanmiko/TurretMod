package com.incognitodev.TurretMod;

public enum TurretType {
	PISTOL(0,0,0),
	MG(0,0,0),
	SMG(0,0,0),
	SNIPER(0,0,0);
	private float turnspeed;
	private float firerate;
	private float maxrange;
	TurretType(float turnspeed, float firerate, float maxrange){
		this.turnspeed = turnspeed;
		this.firerate = firerate;
		this.maxrange=maxrange;
	}
	public float getTurnspeed(){ return turnspeed; }
	public float getFirerate() {
		return firerate;
	}
	public float getMaxrange() {
		return maxrange;
	}
}
