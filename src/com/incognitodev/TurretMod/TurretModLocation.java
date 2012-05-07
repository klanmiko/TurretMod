package com.incognitodev.TurretMod;

public class TurretModLocation {
   public double x;
   public double y;
   public double z;
   public TurretModLocation(double x, double y, double z)
   {
	   this.x = x;
	   this.y = y;
	   this.z = z;
   }
   public boolean equals (double x, double y, double z)
   {
	   if(this.x == x & this.y == y & this.z == z)
	   {
		   return true;
	   }
	   else{
		   return false;
	   }
   }
}
