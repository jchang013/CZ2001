

public class HashTableFold {

    public int comparison;
    public int tablesize;
    HashEntry[] table;

    HashTableFold(int tablesize) {
    	this.tablesize = tablesize;
    	table = new HashEntry[tablesize];
        for (int i = 0; i < tablesize; i++)
        	table[i] = null;
    }

    public String get(int key) {
  	  	int hash = foldingMethod(key);
          int initialHash = -1;
          comparison = 1;
          
          while (hash != initialHash
                      && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null
                                 && table[hash].getKey() != key)) {
          	  
          	if (initialHash == -1) 
                      initialHash = hash;
                hash = (hash + 1) % tablesize;
                comparison = comparison + 1;							
          }
          if (table[hash] == null || hash == initialHash)	{	
          	return "-1";
          }
          else	{
          	return table[hash].getValue();		
          }
          
    }
    
    public void put(int key, String value) {
    	int hash = foldingMethod(key);
          int initialHash = -1;
          int indexOfDeletedEntry = -1;
          while (hash != initialHash
                      && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null
                                 && table[hash].getKey() != key)) {
                if (initialHash == -1)
                      initialHash = hash;
                if (table[hash] == DeletedEntry.getUniqueDeletedEntry())
                      indexOfDeletedEntry = hash;
                hash = (hash + 1) % tablesize;
          }
          if ((table[hash] == null || hash == initialHash)
                      && indexOfDeletedEntry != -1)
                table[indexOfDeletedEntry] = new HashEntry(key, value);
          else if (initialHash != hash)
                if (table[hash] != DeletedEntry.getUniqueDeletedEntry()
                           && table[hash] != null && table[hash].getKey() == key)
                      table[hash].setValue(value);
                else
                      table[hash] = new HashEntry(key, value);
          
    }

    public void remove(int key) {
    	int hash = foldingMethod(key);
          int initialHash = -1;
          while (hash != initialHash
                      && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null
                                 && table[hash].getKey() != key)) {
                if (initialHash == -1)
                      initialHash = hash;
                hash = (hash + 1) % tablesize;
          }
          if (hash != initialHash && table[hash] != null)
                table[hash] = DeletedEntry.getUniqueDeletedEntry();
    }
    
    public void printHashTable() {
  	  System.out.println("Hash table:	");
  	  for (int i = 0; i < tablesize; i++) {
  		  if (table[i] != null)
  		  {
  			  System.out.println("Key: " + table[i].getKey() + ", Value: " + table[i].getValue());
  		  }
  	  }
    }
    
    private int foldingMethod(int key) {
		int sum = 0;

		sum += key % 100;
		key /= 100;
		sum += key % 1000;
		key /= 1000;
		sum += key % 1000;
		return sum % tablesize;
	}
}
