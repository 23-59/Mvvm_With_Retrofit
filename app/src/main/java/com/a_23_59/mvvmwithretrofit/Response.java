package com.a_23_59.mvvmwithretrofit;

import java.util.List;

public class Response{
	private Pagination pagination;
	private List<DataItem> data;

	public Pagination getPagination(){
		return pagination;
	}

	public List<DataItem> getData(){
		return data;
	}
}