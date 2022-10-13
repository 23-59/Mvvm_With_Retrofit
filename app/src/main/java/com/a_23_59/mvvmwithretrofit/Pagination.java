package com.a_23_59.mvvmwithretrofit;

public class Pagination{
	private int total;
	private int offset;
	private int limit;
	private int count;

	public int getTotal(){
		return total;
	}

	public int getOffset(){
		return offset;
	}

	public int getLimit(){
		return limit;
	}

	public int getCount(){
		return count;
	}
}
