# CZ2001

### ===CZ2001 Lab 2 Group 3 Source Code===
Contributors: Chang Jun Hao, Ngui Seng Yang, Chu Zhen Ting, Ang Wan Qi, Deane Looi

===Question===
Given Question: 3. Using open address hashing and linear probing, compare between different hashing functions. 

===Details===
Refer to report

===Source Code===
1. To run the program first open up command prompt in the folder 'CZ2001 Lab 2 Group 3 Soruce Code' by changing directory 
	or opening command prompt from the folder itself
2. Compile the codes using: javac *.java
3. Next run the main.java java using: java main
4. Program will prompt user to enter Data size and Table size, for our testings, we have used 1000 for Table size
	then 250, 500 and 750 for Data size
5. Program will then take phone numbers and names from the files 'numbers.txt' and 'names.txt' from the top
	Example if user entered 500 for data size, the program will take the first 500 names and numbers from the file
6. Data size up to 10,000 is possible but ensure that the Table size is larger than Data size when entering
7. Load factor should show Data size/Table size
8. Program will prompt user to enter a phone number to search, take a phone number from the file 'numbers.txt' and enter
9. Program will show successful search with the two different hashing function with number of key comparison, average CPU time
	and the name of the phone number owner
9. User can test a random phone number that is not stored in the table and the program return a string of '-1' when there is an 
	unsuccesful search along with the number of key comparison and average cpu time
10. User can enter -1 to exit

### ===CZ2001 Lab 3 Group 3 Source Code===
Contributors: Chang Jun Hao, Ngui Seng Yang, Chu Zhen Ting, Ang Wan Qi, Deane Looi

===Project===
Selected Project: Project 3A: Empirical comparison between Insertion Sort and Mergesort

===Details===
Refer to report

===Source Code===
1. To run the program first open up command prompt in the folder 'CZ2001 Lab 3 Group 3 Soruce Code' by changing directory 
	or opening command prompt from the folder itself
2. Compile the codes using: javac *.java
3. Run the main.java java using: java main
4. Program will prompt user to enter array size, for our testings, 
	we have used 1,000, 1,024, 10,000 32,768, 100,000, 524,288, 1,000,000, 1,048,576
5. Simply enter a postive integer of n > 0 and the program will automatically generate an array of integers randomy sorted, an array of integers in ascending
	order and an array of integers in descending order
6. Once arrays are automatically generated, they will automatically be sorted and number of comparisons and running time will be shown
7. If user wish to look at the arrays generated and the arrays after being sorted
	1. First open main.java with any code editor tool
	2. Uncomment line 31, 33, 35, 37, 39, 46, 55, 64, 74, 84 and 94
	3. The line should look something like: printArray(mergesort.desc);
