import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BFSGraph {
	private int numOfVertices;
	private ArrayList<Integer>[] vertexList;
	public int numFlightsTaken = 0;
	
	// A total of 110 Cities
	List<String> cityNames = Arrays.asList("Kabul","Adelaide","Brisbane","Cairns","Canberra","Darwin","Melbourne",
			"Perth","Sydney","Vienna","Manama","Dhaka","Brussels","São Paulo","Bandar Seri Begawan","Montreal","Toronto",
			"Vancouver","Beijing","Guangzhou","Hangzhou","Nanjing","Shanghai","Shenzhen","Copenhagen","Cairo","Paris",
			"Berlin","Düsseldorf","Frankfurt","Munich","Athens","Hong Kong","Ahmedabad","Amritsar","Bengaluru","Chennai",
			"Delhi","Hyderabad","Kochi","Kolkata","Mumbai","Denpasar","Jakarta","Medan","Palembang","Pekanbaru","Surabaya",
			"Tehran","Milan","Rome","Fukuoka","Hiroshima","Nagoya","Osaka","Sapporo","Sendai","Tokyo","Kuwait City","Macau",
			"Penang","Kota Kinabalu","Kuala Lumpur","Kuching","Malé","Valletta","Port Louis","Yangon","Kathmandu","Amsterdam",
			"Auckland","Christchurch","Wellington","Karachi","Lahore","Cebu","Manila","Moscow","Jeddah","Riyadh","Singapore",
			"Cape Town","Durban","Johannesburg","Busan","Seoul","Barcelona","Madrid","Colombo","Stockholm","Zürich","Kaohsiung",
			"Taipei","Bangkok","Istanbul","Dubai","Abu Dhabi","London","Manchester","Chicago","Honolulu","Houston","Las Vegas",
			"Los Angeles","Newark","New York City","San Francisco","Seattle","Washington, D.C.","Hanoi");
	
	public BFSGraph(int numOfCities) {
		//Constructor
		this.numOfVertices = numOfCities;
		vertexList = new ArrayList[numOfCities];
		for (int i = 0; i < numOfVertices; i++) {
			vertexList[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int firstVertex, int secondVertex) {
		vertexList[firstVertex].add(secondVertex);
	}
	
	public void printGraph() {
		System.out.println("\nNow printing Graph:\n");
		for (int i = 0; i < vertexList.length; i++) {
			System.out.format("[%2d]: %20s -->", i, cityNames.get(i)); // Prints the city name of the vertex
			for (Integer cityIndex : vertexList[i]) {
				System.out.format(" [%2s - %s]", cityIndex, cityNames.get(cityIndex)); // Prints adjacent cities
			}
			System.out.println();
		}
	}
	
	public void printGraph(boolean adjacencyLists) {
		if (adjacencyLists == true) {
			System.out.println("\nArray of Adjacency Lists:\n");
			for (int i = 0; i < vertexList.length; i++) {
				System.out.format("[%2d]: %20s -->", i, cityNames.get(i)); // Prints the city name of the vertex
				for (Integer cityIndex : vertexList[i]) {
					System.out.format(" [%2s]", cityIndex, cityNames.get(cityIndex)); // Prints adjacent cities
				}
				System.out.println();
			}
		} else {
			printGraph();
		}
	}
	
	public void printCities() {
		System.out.println("\nNow printing list of cities:\n");
		for (int i = 0; i < cityNames.size(); i++) {
			System.out.format("[%2d]: %s\n", i, cityNames.get(i));
		}
		System.out.println();
	}
	
	public void printCities(int sizeOfGraph) {
		System.out.println("\nList of cities:\n");
		for (int i = 0; i < sizeOfGraph; i++) {
			System.out.format("[%2d]: %s\n", i, cityNames.get(i));
		}
		System.out.println();
	}
	
	public int[][] generateRandomMatrixOfEdges() {			
		//Randomly generates matrix of edges
		int[][] matrixToBeGenerated = new int[numOfVertices][numOfVertices];
		Random rand = new Random();

		for (int i = 0; i < numOfVertices; i++) {
			for (int j = 0; j < numOfVertices; j++) {
				matrixToBeGenerated[i][j] = rand.nextInt(2);
			}
		}

		for (int i = 0; i < numOfVertices; i++) {
			for (int j = 0; j < i; j++) {
				// Diagonal Matrix
				matrixToBeGenerated[j][i] = matrixToBeGenerated[i][j];
			}
			matrixToBeGenerated[i][i] = 0; 								//Remove self-edges
		}
		printAdjacencyMatrix(matrixToBeGenerated);
		return matrixToBeGenerated;
	}
	
	public int[][] generateMaxMatrixOfEdges() {				
		//Generates maximum possible edges from given city size: (n(n-1))/2 edges
		int[][] matrixToBeGenerated = new int[numOfVertices][numOfVertices];
		
		for (int i = 0; i < numOfVertices; i++) {
			for (int j = 0; j < numOfVertices; j++) {
				matrixToBeGenerated[i][j] = 1;				//Makes the whole matrix to be filled with 1
			}
		}
		for (int i = 0; i < numOfVertices; i++) {
			for (int j = 0; j < i; j++) {
				matrixToBeGenerated[i][i] = 0; 				//Remove self-edges
			}
		}
		matrixToBeGenerated[0][0] = 0;
		printAdjacencyMatrix(matrixToBeGenerated);
		return matrixToBeGenerated;	
	}
	
	public int[][] generateMinMatrixOfEdges() {
		//Generates minimum possible edges from given city size: n edges
		int[][] matrixToBeGenerated = new int[numOfVertices][numOfVertices];
		for (int a = 0; a < numOfVertices - 1; a++) {
			matrixToBeGenerated[a][a+1] = 1;
			matrixToBeGenerated[a+1][a] = 1;
		}
		//matrixToBeGenerated[0][numOfVertices-1] = 1;
		//matrixToBeGenerated[numOfVertices-1][0] = 1;
		printAdjacencyMatrix(matrixToBeGenerated);
		return matrixToBeGenerated;	
	}
	
	public void printAdjacencyMatrix(int[][] matrixGenerated) {
		System.out.println("\nAdjacency Matrix Representation:\n");
		for (int a = 0; a < numOfVertices; a++) {
			for (int b = 0; b < numOfVertices; b++) {
				System.out.format("[%d]", matrixGenerated[a][b]);
			}
			System.out.println();
		}
	}
	
	public void BFS(int sourceVertex, int destinationVertex) {

		boolean shortestPathFound = false;			//Initially false
		boolean visitedVertices[] = new boolean[numOfVertices];

		LinkedList<Integer> queue = new LinkedList<Integer>();	// Queue for BFS Algorithm
		Map<Integer, Integer> previousVertices = new HashMap<Integer, Integer>();

		visitedVertices[sourceVertex] = true;
		queue.add(sourceVertex);

		int currentVertex = sourceVertex;
		while (queue.size() != 0) {
			if (currentVertex == destinationVertex) {
				shortestPathFound = true;
				break;
			}
			currentVertex = queue.poll();
			Iterator<Integer> iter = vertexList[currentVertex].listIterator();
			while (iter.hasNext()) {
				Integer adjVertex = iter.next();
				if (visitedVertices[adjVertex] == false) {
					visitedVertices[adjVertex] = true;
					queue.add(adjVertex);
					previousVertices.put(adjVertex, currentVertex);
					if (adjVertex == destinationVertex) {
						currentVertex = adjVertex;
						shortestPathFound = true;
						break;
					}
				}
			}
		}

		if (shortestPathFound) {
			ArrayList<Integer> pathToTrace = new ArrayList<Integer>();
			Integer cityToTrace = currentVertex;
			while (cityToTrace != null) {
				pathToTrace.add(cityToTrace);
				cityToTrace = previousVertices.get(cityToTrace);
			}
			Collections.reverse(pathToTrace);
			System.out.println("\nShortest Path from Source to Destination:\n");
			numFlightsTaken = 0;
			for (Integer cityIndex : pathToTrace) {
				System.out.format("%2d : %s\n", cityIndex, cityNames.get(cityIndex));
				numFlightsTaken++;
			}
		} else {
			System.out.println("\nPath not found\n");
		}
	}
}
