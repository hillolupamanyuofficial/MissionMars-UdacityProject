package net.mangalyaan;
import java.util.Random;
//import net.mangalyaan.Item;

public class U2 extends Rocket {
	public U2() {
		this.price = 120;   //this is in millions
		this.rocketWeight = 18000;  // this is in tons
		this.weightLimit = 29000;   // this is in tons
		this.currentWeight = this.rocketWeight;
	}
	
	
	
	
	
	Random random = new Random();
 	
	
	
	
	
	public boolean launch() {
		boolean canLaunch = true;
		int probOfFailure = Math.round(4 * (this.currentWeight / this.weightLimit)); //try to get more accurate value
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
		int probOfFailure = Math.round(8 * (this.currentWeight/this.weightLimit)); //try to find approx more properly
		int randomNo = (random.nextInt(100)+1);
		
		if(randomNo <= probOfFailure) {
			canLand = false;
		}
		return canLand;
	}
	
	
}
