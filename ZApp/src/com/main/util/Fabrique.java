package com.main.util;

import java.util.ServiceLoader;

import com.dao.IQuizDao;

public class Fabrique {

	
	public static IQuizDao getprovider()
	{
		IQuizDao Iquiz;
		Iquiz= ServiceLoader.load(IQuizDao.class).findFirst().get();
		
		return Iquiz;
	}
}
