package Week1.Test1;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
	  
	        ThreadLocalRandom.current().ints(0, 350000).distinct().limit(200000).forEach(a::add);
	        ThreadLocalRandom.current().ints(0, 350000).distinct().limit(200000).forEach(b::add);
	  
	        System.out.println("Set a: " + a.size()); 
	        System.out.println("Set b: " + b.size()); 
	  
	        System.out.println("Tap hop: " + timTapHop(a, b).size()); 
	        System.out.println("Tap giao: " + timTapGiao(a, b).size());
	    } 	
}
