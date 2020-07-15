package net.mangalyaan;
import java.util.ArrayList;

//import net.mangalyaan.*;

public class Main {

	public static void main(String[] args) {
		SimulationAlpha simulation = new SimulationAlpha();
		System.out.println(" --------------------------------");
		System.out.println("| WELCOME TO MISSION MANGAL _/\\_ |");
		System.out.println(" --------------------------------");

		ArrayList<Item> itemsListPhase1 = simulation.loadItems(1); //creating ArrayList for phase-1
		ArrayList<Item> itemsListPhase2 = simulation.loadItems(2); //creating ArrayList for phase-2
		
		
		System.out.println("\nFOR \"U1\" TYPE ROCKETS");
		System.out.println("---------------------");
		
		System.out.println("\nLoading Rockets with PHASE-1 items");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		ArrayList<Rocket> rocketListphase1U1 = simulation.loadU1(itemsListPhase1);
		System.out.println("\n>> Initializing Simulation Rockets for PHASE-1 ");
		int phaseOneCostU1 = simulation.runSimulation(rocketListphase1U1);
		System.out.println("\n>> Total cost of U1 type Rockets for first phase = $ " + phaseOneCostU1 + " millions ");
		

		System.out.println("\nLoading Rockets with PHASE-2 items");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		ArrayList<Rocket> rocketListphase2U1 = simulation.loadU1(itemsListPhase2);
		System.out.println("\n>> Initializing Simulation for U1 type rockets for PHASE-2 ");
		int phaseTwoCostU1 = simulation.runSimulation(rocketListphase2U1);
		System.out.println("\n>> Toal cost of U1 type rockets for second phase = $ " + phaseTwoCostU1 + "millions ");
		
		
		System.out.println("\nFOR \"U2\" TYPE ROCKETS");
		System.out.println("---------------------");
		
		
		System.out.println("\nLoading Rockets with PHASE-1 items");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		ArrayList<Rocket> rocketListphase1U2 = simulation.loadU2(itemsListPhase1);
		System.out.println("\n>>Initializing Simulation for Rockets for PHASE-1 ");
		int phaseOneCostU2 = simulation.runSimulation(rocketListphase1U2);
		System.out.println("\n>> Total Cost of U2 type Rockets for first phase = $ " + phaseOneCostU2 + " million");
		
		
		System.out.println("\nLoading Rockets with PHASE-2 items");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		ArrayList<Rocket> rocketListphase2U2 = simulation.loadU2(itemsListPhase2);
		System.out.println("\n>>Initializing Simulation for U2 type rockets for PHASE-2 ");
		int phaseTwoCostU2 = simulation.runSimulation(rocketListphase2U2);
		System.out.println("\n>> Total cost of U2 type Rockets for second phase = $ " + phaseTwoCostU2 + " million");
		
		System.out.println("\n -------------------");
		System.out.println("| END OF SIMULATION |");
		System.out.println(" -------------------");
		
		System.out.println("\nTotal budget for both phases using U1 fleet of Rockets = $ " + (phaseOneCostU1+phaseTwoCostU1)+ " Million" );
		System.out.println("\nTotal budget for both phases using U2  fleet of Rockets= $ " + (phaseOneCostU2+phaseTwoCostU2)+ " Million" );
		
		System.out.println("\n");
	   System.out.println("\nIdeal type of Rocket for - ");
	   simulation.idealRocketPhase1(phaseOneCostU1,phaseOneCostU2);
	   simulation.idealRocketPhase2(phaseTwoCostU1,phaseTwoCostU2);
	}

}
