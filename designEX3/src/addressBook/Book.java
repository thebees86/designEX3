package addressBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Book {
	public Map<String,Set<Long>> people = new HashMap<String,Set<Long>>();
	public Map<Long,Set<String>> numbers = new HashMap<Long,Set<String>>();
	
	public Book() {}
	
	//Add one name and multiple corresponding phone numbers
	public void add(String name, long...nums) {
		if(!people.containsKey(name))
			people.put(name, new HashSet<Long>());
		for(long l : nums) {
			people.get(name).add(l);
			if(!numbers.containsKey(l))
				numbers.put(l, new HashSet<String>());
			numbers.get(l).add(name);
		}
	}
	
	//Add one phone number and multiple corresponding names
	public void add(long number, String...names) {
		if(!numbers.containsKey(number))
			numbers.put(number, new HashSet<String>());
		for(String n : names) {
			if(!people.containsKey(n))
				people.put(n, new HashSet<Long>());
			people.get(n).add(number);
			numbers.get(number).add(n);
		}
	}
	
	//Returns all people in alphabetical order, along with their corresponding phone numbers (in no particular order)
	public String getPeople() {
		String out = "";
		for(String n : people.keySet()) {
			for(long l : people.get(n)) {
				out += String.format("%s:\t\t\t%d\n", n,l);
			}
		}
		return out;
	}
	
	//Returns all phone numbers in order, along with corresponding names
	public String getNumbers() {
		String out = "";
		ArrayList<Long> inOrder = new ArrayList<Long>();
		for(long l : numbers.keySet()) {
			inOrder.add(l);
		}
		Collections.sort(inOrder);
		for(long l : inOrder) {
			for(String n : numbers.get(l)) {
				out += String.format("%d\t\t\t%s\n", l,n);
			}
		}
		return out;
	}
	
	public String toString() {
		return getPeople();
	}
}
