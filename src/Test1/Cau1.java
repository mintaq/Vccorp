package Test1;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;
import java.util.stream.*;

public class Cau1 {
	    public static Set<Integer> timTapHop(Set<Integer> a, Set<Integer> b) { 
	        Set<Integer> taphop = new HashSet<>(); 

	        Collections.addAll(taphop, a.toArray(new Integer[0])); 
	        Collections.addAll(taphop, b.toArray(new Integer[0])); 
	  
	        return taphop; 
	    } 
	    
	    public static Set<Integer> timTapGiao(Set<Integer> a, Set<Integer> b) {
	    	Set<Integer> tapgiao = new HashSet<Integer>(a);
	    	
	    	tapgiao.retainAll(b);
	    	
	    	return tapgiao;
	    }
	  
	    public static void main(String[] args) { 	    	
	        Set<Integer> a = new HashSet<Integer>(); 
	        Set<Integer> b = new HashSet<Integer>(); 
	  
	        ThreadLocalRandom.current().ints(0, 400000).distinct().limit(200000).forEach(a::add);
	        ThreadLocalRandom.current().ints(0, 400000).distinct().limit(200000).forEach(b::add);
	  
	        System.out.println("Set a: " + a); 
	        System.out.println("Set b: " + b); 
	  
	        System.out.println("Tap hop: " + timTapHop(a, b)); 
	        System.out.println("Tap giao" + timTapGiao(a, b));
	    } 	
}
