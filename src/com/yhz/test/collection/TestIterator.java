package com.yhz.test.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class TestIterator {
	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("t1");
		books.add("t2");
		books.add("t3");
		Iterator it = books.iterator();
		while(it.hasNext()){
			String book = (String)it.next();
			if(book.equals("t2")){
				//it.remove();
				books.remove(book);
			}
		}
		System.out.println(books);
	}
}
