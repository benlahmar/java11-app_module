package com.main;

import java.util.List;
import java.util.ServiceLoader;

import com.dao.IQuizDao;
import com.entities.Quiz;

public class AppQuiz {

	static IQuizDao Iquiz;
	public static IQuizDao getprovider()
	{
		Iquiz= ServiceLoader.load(IQuizDao.class).findFirst().get();
		
		return Iquiz;
	}
	
	
	public static void main(String[] args) {
		 System.out.println("**************");
		 Iquiz=getprovider();
		 System.out.println("**************");
		 List<Quiz> data = Iquiz.loadData();
		 //List<Quiz> data = Iquiz.all();
		 System.out.println(data.get(0).getQuestions().size());
	}
	
}
