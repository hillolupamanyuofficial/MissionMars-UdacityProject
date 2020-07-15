package net.mangalyaan;
//import net.mangalyaan.Item;
import net.mangalyaan.Spaceship;

public class Rocket implements Spaceship{
	
	protected int price;
	protected int rocketWeight;
	protected int weightLimit;
	
	protected int currentWeight; //when rocket is empty
	protected int cargoCarried;
	
	//test constructor
	 
	public Rocket() {
		this.price = 0;
		this.rocketWeight = 0;
		this.weightLimit = 0;
		this.currentWeight = rocketWeight;
	}

	
  //function will be overridden by class which will inherit this class
	
	public boolean launch() {
		return true;
	}


	
	public boolean land() {
		return true;
	}

	
 //the two methods will not and cannot be overridden in the child classes(using final)
	
	public  final boolean canCarry(Item item) {
	    return (this.currentWeight +  item.weight) <= this.weightLimit;
	}
	
	

	public final void carry(Item item) {
		this.currentWeight = this.currentWeight + item.weight; 
		this.cargoCarried = this.currentWeight - this.rocketWeight;
	}
	

}
