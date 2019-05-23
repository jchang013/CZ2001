

public class HashEntry {
	 private int key;
     private String value;

     HashEntry(int key, String value) {
           this.key = key;
           this.value = value;
     }

     public String getValue() {
           return value;
     }

     public void setValue(String value) {
           this.value = value;
     }

     public int getKey() {
           return key;
     }
}
