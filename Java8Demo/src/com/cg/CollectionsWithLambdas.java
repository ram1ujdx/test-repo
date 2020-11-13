package com.cg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsWithLambdas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//consumer interface
		List<Integer> items=Arrays.asList(7,3,9,2,6,7,4,3,5);
		
		items.forEach(i->System.out.println(i));
		//method reference
		System.out.println("\n------------------\n");
		
		items.forEach(System.out::println);
		//API implementation
		System.out.println("\n------------------\n");
		
		items.stream().filter(i->i%2==0).filter(i->i%3==0).forEach(i->System.out.println(i));
		//function 
		System.out.println("\n------------------\n");
		
		items.stream().filter(i->i%2==0).map(i->i*i).forEach(System.out::println);
		//from the above collection find the sum of squares of even numbers
		System.out.println("\n------------------\n");
		
		int sum=items.stream().filter(i->i%2==0).mapToInt(i->i*i).sum();
		//here sum is a terminal method
		System.out.println("Sum = "+sum);
		System.out.println("\n------------------\n");
		
		int result=items.stream().filter(i->i%2==0).map(i->i*i).reduce(0,(i,j)->i+j);
		//here reduce is a terminal method
		System.out.println("Result = "+result);
		System.out.println("\n------------------\n");
		
		int result2=items.stream().map(i->i*i).filter(i->i%2==0).reduce(0,(i,j)->i+j);
		/*result and result2 take same time to get output
		 here we just reversed the map and filter but both take same time
		 because these are called "LAZY" that whether we wright
		  map or filter it filters first and then map  
		 */
		System.out.println("Second Result = "+result2);
		System.out.println("\n------------------\n");
		
		int result3=items.stream()
				.filter(i->{System.out.println("Filtered - "+i);
				return i%2==0;})
			
				.map(i->{System.out.println("Mapped - "+i);
				return i*i;})
				.findFirst().orElse(0);
		//Filter and Map declaration in different way
		System.out.println("Third Result = "+result3);
		System.out.println("\n------------------\n");
		
		List<Integer> resultedItems=items.stream().filter(i->i%2==0).map(i->i*i).collect(Collectors.toList());
		System.out.println("Resulted Items"+resultedItems);
	}
	

}
