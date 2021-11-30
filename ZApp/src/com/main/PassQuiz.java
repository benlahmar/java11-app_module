package com.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.dao.IQuizDao;
import com.entities.Question;
import com.entities.Quiz;
import com.main.util.Fabrique;

public class PassQuiz {

	IQuizDao iquiz;
	
	public PassQuiz() {
		iquiz=Fabrique.getprovider();
	}

	/**
	 * liste des quiz dont le nombre des question> nb
	 * @param nb
	 * @return
	 */
	public List<Quiz> getquizgreat(int nb)
	{
		return iquiz.all().stream()
			.filter(x-> x.getQuestions().size()>nb)
			.collect(Collectors.toList());
	}
	
	/**
	 * Dont le nombre des reponses depasse pas y
	 * @param nb
	 * @return
	 */
	public Set<Quiz> getquizless(int nb)
	{
		
	Predicate<? super Question> pr2= y->y.getReponses().size()<nb;
	
	Predicate<? super Quiz> pr1=x->x.getQuestions().stream()
				.allMatch(pr2);
			
		return iquiz.all().stream()
			.filter(pr1).collect(Collectors.toSet());
					
	}
	
	public void  passer(int idq)
	{
		Quiz q = iquiz.all().stream().filter(x->x.getId()==idq).findFirst().get();
		String choix="";
		int i=0;
		Scanner sc=new Scanner(System.in);
		Map<Integer, Integer> resps=new HashMap<>();
		while(!choix.equals("quit"))
		{
			Question qt = q.getQuestions().get(i);
			System.out.println(qt.getText());
			System.out.println("************");
			qt.getReponses().forEach(x->System.out.println(x.getId()+" : "+x.getRep()));
			System.out.println("entrer la reponse:");
			int r=sc.nextInt();
			qt.setIsselected(true);
			qt.getReponses().stream().filter(x->x.getId()==r)
				.findFirst().get().setIsanswered(true);
			
		}
		
	}
	
	
	
	public Map<Integer, Integer>  passer2(int idq)
	{
		Quiz q = iquiz.all().stream().filter(x->x.getId()==idq).findFirst().get();
		String choix="";
		int i=0;
		Scanner sc=new Scanner(System.in);
		Map<Integer, Integer> resps=new HashMap<>();
		while(!choix.equals("quit"))
		{
			Question qt = q.getQuestions().get(i);
			System.out.println(qt.getText());
			System.out.println("************");
			qt.getReponses().forEach(x->System.out.println(x.getId()+" : "+x.getRep()));
			System.out.println("entrer la reponse:");
			int r=sc.nextInt();
			resps.put(qt.getId(), r);
			
		}
		return resps;
	}
	
	
	public void incorrect()
	{
		//reponse istrue    la reponse
	}
}
