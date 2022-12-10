package lab13stuff;

import java.util.*;
import java.io.*;

public class lab13 {
	
	ArrayList<Integer> valuesStored = new ArrayList<>();

	public void readData(String filename) {
		
		try {
		
		BufferedReader bR = new BufferedReader(new InputStreamReader (new FileInputStream(filename)));
		String lineRead = bR.readLine();
		while (lineRead != null) {
             Integer intRead = Integer.valueOf(lineRead);
             valuesStored.add(intRead);
             lineRead = bR.readLine();

		}
		
		bR.close();
		
		
		} 
		catch(IOException e) {
			System.out.println("some io exception happened ");
			
		}
		catch(Exception e) {
			System.out.println("some other exception happened ");
		}
		
	}
	
	public long getTotalCount() {
		return valuesStored.stream().count();
	}
	
	public long getOddCount() {
		return valuesStored.stream().filter(x -> x % 2 !=0).count();
 
	}
	
	public long getEvenCount() {
		return valuesStored.stream().filter(x -> x % 2 ==0).count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return valuesStored.stream().filter(x -> (x > 5)).distinct().count();
		
	}
	
	public Integer[] getResult1() {
		return valuesStored.stream().sorted().filter(x -> x % 2 ==0).filter(x -> (x > 5) && (x < 50)).toArray(Integer[]::new);
		
	}
	
	public Integer[] getResult2() {
		return valuesStored.stream().limit(50).map(x -> x * x).map(x -> x * 3).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3() {
		return valuesStored.stream().filter(x -> x % 2 ==1).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
	
}
