package edu.asupoly.ser422.services;

import java.util.List;

// we'll build on this later
public interface BooktownService {
    public List getAuthors();
    public boolean deleteAuthor(int authorId);
    public int createAuthor(String lname, String fname);
}
