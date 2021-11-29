package com.main;

import java.util.ServiceLoader;

import com.dao.IDao;

import co.entity.User;

public class Test {

	public static void main(String[] args) {
		
		IDao dao;
		dao=getimp("com.dao.imp.DaoImpl")	;
		
		
		User u=new User();
		u.setId(1);
		u.setLog("log");
		u.setPass("pass");
		dao.addUser(u);
		
		User ut = dao.findById(1);
		System.out.println(ut.toString());
	}

	public static IDao getimp(String nom)
	{
		IDao daot=null;
		ServiceLoader<IDao> daos=ServiceLoader.load(IDao.class);
		
		String impl=daos.getClass().getName();
		for (IDao d : daos) {
			System.out.println(d.getClass().getName());
			if(d.getClass().getName().equals(nom))
				daot= d;
		}
		return daot;
		}
}
