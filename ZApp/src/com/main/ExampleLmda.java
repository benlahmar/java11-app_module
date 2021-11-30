package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import co.entity.User;

public class ExampleLmda {

	public static void main(String[] args) {
		
		ICalc add= (int x, int y)->x+y;
		ICalc sous = (x,y)->x-y;
		
		add.apply(55,7);
		
		
		Function<Integer, Integer> mult= x->x*2;
		Function<Integer, Integer> div= x->x/2;
		
			int x1=		mult.compose(div).compose(mult).apply(5); //(fog(x))
			
			int x2= mult.andThen(div).apply(5);
			
		System.out.println(x1);
		
		System.out.println(x2);
		
		Function<User, String> gg= x-> {  return "majeur";};
		System.out.println(gg.apply(new User()));
		
		
		Predicate<String> passchecklen= x->{
			if(x.length()<4)
				return false;
			else
				return true;
		};
		
		Predicate<String> isalphanum = x->{
			boolean c=false;
			boolean n=false;
			for(int i=0;i<x.length();i++) {
				if(Character.isDigit(x.charAt(i)))
					n=true;
				if(Character.isAlphabetic(x.charAt(i)))
					c=true;
			}
			return (c && n);
		};
		
		Predicate<String> res = isalphanum.and(passchecklen);
		
		Function<String, String> pass= x->{
			if(res.test(x))
				return "fort";
			else
				return "faible";
		};
		
		
		System.out.println(pass.apply("bonjour14"));
		List<String> ls=new ArrayList<>();
		for(int i=0;i<100;i++)
			ls.add("ele"+i);
		
		  
		 long dd = ls.stream()
				
				.map(x->x.length())
				
				.count();
		
		
		
		
//		Apply aa=new Apply();
//		
//		int s=aa.apply(44, 20, add);
//		int ss=aa.apply(44, 20, sous);
//		System.out.println("add :"+s);
//		System.out.println("sous :"+ss);
		
	}
}
