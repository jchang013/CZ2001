import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int tablesize, datasize, input, i, j, sum, parsednumber;
		long start, end, CPUtime = 0;
		String value = null;
		
		System.out.println("Enter Data Size: ");
		datasize = sc.nextInt();
		System.out.println("Enter table size: ");
		tablesize = sc.nextInt();
		
		System.out.println("Load Factor: " + Double.valueOf(datasize)/Double.valueOf(tablesize));
		
		HashTableMod table_Mod = new HashTableMod(tablesize);
		HashTableFold table_Fold = new HashTableFold(tablesize);
		
		File numbersfile = new File("numbers.txt");
		File namesfile = new File("names.txt");
		
		BufferedReader numbr = new BufferedReader(new FileReader(numbersfile));
		BufferedReader namebr = new BufferedReader(new FileReader(namesfile));
		
		String number;
		String name;
		i = 0;
		while (i < datasize)
		{
			number = numbr.readLine();
			name = namebr.readLine();
			parsednumber = Integer.parseInt(number);
			table_Mod.put(parsednumber, name);
			table_Fold.put(parsednumber, name);
			i++;
		}
		
		System.out.println("Enter Phone Number to search(-1 to exit): ");
		input = sc.nextInt();
		while (input != -1)
		{
			i = 0; sum = 0;	
			while (i < 10)	//try 10 times to calculate average cpu time
			{
				start = System.nanoTime();
				value = table_Mod.get(input);
				end = System.nanoTime();
				sum += end - start;
				i++;
			}
			CPUtime = sum / 10;
			System.out.println("Using Mod Table function: ");
			System.out.println("Number belongs to " + value);
			System.out.println("Number of comparison: " + table_Mod.comparison);
			System.out.println("Average CPU time: " + CPUtime + " nanoseconds");
			
			System.out.println();
			
			i = 0; sum = 0;
			while (i < 10)	//try 10 times to calculate average cpu time
			{
				start = System.nanoTime();
				value = table_Fold.get(input);
				end = System.nanoTime();
				sum += end - start;
				i++;
			}
			CPUtime = sum / 10;
			System.out.println("Using Folding Method function: ");
			System.out.println("Number belongs to " + value);
			System.out.println("Number of comparison: " + table_Fold.comparison);
			System.out.println("CPU time: " + CPUtime + " nanoseconds");
			
			System.out.println("Enter Phone Number to search(-1 to exit): ");
			input = sc.nextInt();
		}
		
		System.out.println("Terminating...");
	}

}
