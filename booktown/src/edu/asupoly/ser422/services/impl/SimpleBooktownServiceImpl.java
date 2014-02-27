package edu.asupoly.ser422.services.impl;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import edu.asupoly.ser422.model.Author;
import edu.asupoly.ser422.services.BooktownService;

//A simple impl of interface BooktownService
public class SimpleBooktownServiceImpl implements BooktownService {

	private static final int RETURN_SIZE = 25;

	private final Random __simpleRandom = new Random(System.currentTimeMillis());

	private ArrayList<String> __firstNames = null;
	private ArrayList<String> __lastNames = null;

	private ArrayList<String> initArrayList(String[] args) {
		ArrayList<String> list = new ArrayList<String>(args.length);
		for (int i = 0; i < args.length; i++)
			list.add(args[i]);
		return list;
	}
	// Only instantiated by factory within package scope
	public SimpleBooktownServiceImpl() {
		// read your init properties
		__firstNames = initArrayList(new String[] {"Bob", "Bill", "Sue", "Jenny", "Joe", "Cathleen", "Jodie", "Linda", "James", "Jeff", "Harold", "Jason", "Renee", "Alison", "Nick" });
		__lastNames  = initArrayList(new String[] {"Bush", "Clinton", "Washington", "Jefferson", "Adams", "Madison", "Monroe", "Lincoln", "Roosevelt", "Nixon", "Johnson", "Carter", "Reagan", "Ford", "Kennedy", "Eisenhower", "Truman", "Wilson"});
	}

	// returns a new list of random Authors every time
	public List getAuthors() {
		// return up to RETURN_SIZE.authors
		int rsize = __simpleRandom.nextInt(RETURN_SIZE) + 1;
		List<Author> rval = new ArrayList<Author>(rsize);

		for (int i = 0; i < rsize; i++) {
			rval.add(new Author(__simpleRandom.nextInt(),
					__lastNames.get(__simpleRandom.nextInt(__lastNames.size())),
					__firstNames.get(__simpleRandom.nextInt(__firstNames.size())))
			);
		}
		return rval;
	}

	public int createAuthor(String lname, String fname) {
		__firstNames.add(fname);
		__lastNames.add(lname);
		return 1;
	}

	public boolean deleteAuthor(int authorId) {
		try {
			__firstNames.remove(authorId);
			__lastNames.remove(authorId);
			return true;
		} catch (Exception exc) {
			return false;
		}
	}
}
