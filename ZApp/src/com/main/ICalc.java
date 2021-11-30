package com.main;

@FunctionalInterface
public interface ICalc {

	public int calc(int x, int y);
	
	
	public default int apply(int x, int y)
	{
		return 	calc(x, y);
	}
}
