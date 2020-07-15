package net.mangalyaan;
//import net.mangalyaan.Item;
//import net.mangalyaan.U1;
//import net.mangalyaan.U2;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimulationAlpha {
	
//	private ArrayList<Item> itemList;
	

	
	
	
	public SimulationAlpha(){
		
	}
	
	
	
	
	
	public ArrayList<Item> loadItems(int phaseNo){
		String phase = "";
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		
		
		
		try {
			
			if(phaseNo == 1) {
				System.out.println("\n~~~ Intializing phase 1 ~~~"); 
				System.out.println("> Entering the Items of \"Phase-1.txt\" into the list");
				phase = "phase-1.txt";
			}
			
			
			else if(phaseNo == 2) {
				System.out.println("\n~~~ Intializing phase 2 ~~~");
				System.out.println("> Entering the Items of \"Phase-2.txt\" into the list");
				phase = "phase-2.txt";
			}
			
			else {
				System.out.println("Alert!! Phase failed....error in naming file!!!");
			}
			
			
			File file = new File(phase);
			Scanner fileScanner = new Scanner(file);
			
			
			
			
			while(fileScanner.hasNextLine()) {
				
				String line = fileScanner.nextLine();
				String[] itemInfo = line.split("=");				
				Item item = new Item(itemInfo[0],Integer.parseInt(itemInfo[1]));
				itemList.add(item);
			
			}
			
            fileScanner.close();
			
		
	}catch(FileNotFoundException ex){
		
		System.out.println("Error With the file name!!");
		ex.printStackTrace();
	}
		
	return itemList;

    }
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Rocket> loadU1(ArrayList<Item> itemList){
		
		ArrayList<Rocket> rocketList = new ArrayList<Rocket>(); 
		Rocket rocket1 = new U1();
		int i = 1;
		
		for(Item cargo1 : itemList) {
			if(rocket1.canCarry(cargo1)) {
			
	
			rocket1.carry(cargo1);
			
			if(itemList.indexOf(cargo1) == (itemList.size() - 1)) {
				rocket1.carry(cargo1);
				rocketList.add(rocket1);

			}
			
			}
			
			else {
				rocketList.add(rocket1);
				i++;
				rocket1 = new U1();
				rocket1.carry(cargo1);
				
				if(itemList.indexOf(cargo1) == (itemList.size()-1)) {
					
					rocketList.add(rocket1);
				}	
			}
		}
		
		int j = 1;
		System.out.println("\nThe Fleet of rockets --->");
		for(Rocket ob : rocketList ) {
			System.out.println("Rocket " +j+"  carries " + ob.currentWeight + " Kg");
			j++;
		}
		return rocketList;
		
		
	}
	
	
	
	
	
	public ArrayList<Rocket> loadU2(ArrayList<Item> itemList){
		ArrayList<Rocket> rocketList = new ArrayList<Rocket>(); 
		Rocket rocket2 = new U2();
		int i = 1;
		
		for(Item cargo2 : itemList) {
			if(rocket2.canCarry(cargo2)) {
			
	
			rocket2.carry(cargo2);
			
			if(itemList.indexOf(cargo2) == (itemList.size() - 1)) {
				rocket2.carry(cargo2);
				rocketList.add(rocket2);

			}
			
			}
			
			else {
				rocketList.add(rocket2);
				i++;
				rocket2 = new U2();
				rocket2.carry(cargo2);
								
				
				if(itemList.indexOf(cargo2) == (itemList.size()-1)) {
				
					rocketList.add(rocket2);
					}	
			}
		}
		
		int j = 1;
		System.out.println("\nThe Fleet of Rockets --->");
		for(Rocket ob : rocketList ) {
			System.out.println("Rocket " +j+"  carries " + ob.currentWeight + " Kg");
			j++;
		}
		return rocketList;
		
		

		
	}

	
	
	
	
	public int runSimulation(ArrayList<Rocket> rocketList) {
		
		int costRocket = 0;
		int i = 1;
		
		for(Rocket rocket:rocketList) {
			
	       boolean launchVar = rocket.launch();
	       boolean landVar = rocket.land();
	       costRocket = costRocket + rocket.price;
			
		while(!(launchVar == true && landVar == true) ) {
			
			System.out.println("\n>Alert!!! Rocket No."+i+" failed");
			System.out.println(">Retrying with a copy rocket !!");
			i++;
			launchVar = rocket.launch();
		    landVar = rocket.land();
		    costRocket = costRocket + rocket.price;
			
		}
		
	}
	
   return costRocket;	
	
}
	
	void idealRocketPhase1(int x,int y) {
		System.out.print("for phase-1 :\t");
		if(x<y) {
			System.out.println("U1");
		}
		else if(y<x){
			System.out.println("U2");
		}
		else {
			System.out.println("Both Rockets have same cost");
		}
	}


	void idealRocketPhase2(int x,int y) {
		System.out.print("for phase-2 :\t");
		if(x<y) {
			System.out.println("U1");
		}
		else if(y<x){
			System.out.println("U2");
		}
		else {
			System.out.println("Both Rockets have same cost");
		}
	}
}