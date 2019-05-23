import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double start_time = 0;
		double end_time = 0;
		double time_duration = 0;
		double total_time_duration = 0;
		int time_ran = 0;
		
		int numOfCities, choice; 
		int source, destination;
		int numOfNonStopFlight = 0;
		int[][] matrixOfEdges = null;
		
		System.out.println("Enter the number of cities:");
		numOfCities = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Select Random/Max/Min number of non-stop flight: ");
		System.out.println("(1) Random number of non-stop flight");
		System.out.println("(2) Max number of non-stop flight");
		System.out.println("(3) Min number of non-stop flight");
		choice = sc.nextInt();
		sc.nextLine();
		
		while (choice < 1 || choice > 3) {
			System.out.println("Invalid choice entered, please entered 1 to 3 only");
			System.out.println("Select Random/Max/Min number of non-stop flight: ");
			System.out.println("(1) Random number of non-stop flight");
			System.out.println("(2) Max number of non-stop flight");
			System.out.println("(3) Min number of non-stop flight");
			choice = sc.nextInt();
			sc.nextLine();
		}
		BFSGraph g = new BFSGraph(numOfCities);
		g.printCities(numOfCities);
		switch (choice) {
		case 1: matrixOfEdges = g.generateRandomMatrixOfEdges();
			break;
		case 2: matrixOfEdges = g.generateMaxMatrixOfEdges();
			break;
		case 3: matrixOfEdges = g.generateMinMatrixOfEdges();
			break;
		default:
				
		}
		for (int i = 0; i < numOfCities; i++) {
			for (int j = 0; j < numOfCities; j++) {
				if (matrixOfEdges[i][j] == 1) {
					g.addEdge(i, j);
					numOfNonStopFlight++;
				} else {
					continue;
				}
			}
		}
		
		numOfNonStopFlight /= 2;
		g.printGraph(true);
		System.out.println("Number of Non-stop flight: " + numOfNonStopFlight);
		
		while (true) {
			System.out.println("\nSelect a city as source: (-1 to terminate)");
			source = sc.nextInt();
			sc.nextLine();

			if (source == -1) {
				break;
			} else if (source > numOfCities - 1) {
				System.out.println("Invalid input entered, please enter from -1 to " + (numOfCities - 1));
				continue;
			}
			System.out.println("\nSelect a city as destination: (-1 to terminate)");
			destination = sc.nextInt();
			if (destination == -1) {
				break;
			} else if (destination > numOfCities - 1) {
				System.out.println("Invalid input entered, please enter from -1 to " + (numOfCities - 1));
				continue;
			}
			sc.nextLine();
			start_time = System.nanoTime();
			g.BFS(source, destination);
			end_time = System.nanoTime();
			time_duration += (end_time - start_time) / 1000000.0;	//Divide by 1,000,000 from nanoseconds to get milliseconds
			
			System.out.println("\nTotal running time: " + (time_duration) + "ms");
			System.out.println("Number of Flights taken to fly from source to destination: " + (g.numFlightsTaken - 1));
			//time_ran++;
			//total_time_duration += time_duration;
		}
		//System.out.println("Total average: " + total_time_duration/time_ran);
		System.out.println("Terminating...");
	}
	
}
	

