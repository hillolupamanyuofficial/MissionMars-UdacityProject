package net.mangalyaan;
//import net.mangalyaan.Item;
import java.util.Random;
import java.lang.Math;

public class U1 extends Rocket {
	
	public U1() {
		this.price = 100;   //this is in millions
		this.rocketWeight = 10000;  // this is in tons
		this.weightLimit = 18000;   // this is in tons
		this.currentWeight = this.rocketWeight;
	}
	
	
	
	
	Random random = new Random();
	
	
	
	
 	
	public boolean launch() {
		boolean canLaunch = true;
		int probOfFailure = Math.round(5 * this.currentWeight / this.weightLimit); //try to get more accurate value
		//System.out.println("The probability of failure is : " + probOfFailure);
		
		int randomNo = (random.nextInt(100) +1) ;
		//System.out.println("Random no is :"+ randomNo);
		if(randomNo <= probOfFailure) {
			canLaunch = false;
		}
		return canLaunch;
	}
	
	
	
	
	
	
	public boolean land() {
		boolean canLand = true;
		int probOfFailure = Math.round(1 * this.currentWeight/this.weightLimit); //try to find approx more properly
		int randomNo = (random.nextInt(100)+1);
		
		if(randomNo <= probOfFailure) {
			canLand = false;
		}
		return canLand;
	}
	
	

}
