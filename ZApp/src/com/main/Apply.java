package com.main;

public class Apply {

	public int apply(int x, int y , ICalc op)
	{
		return 	op.calc(x, y);
	}
}
