package org.example;

public class BookParser implements IBookParser{
    private int numOfpages = 0;
    public BookParser(String book) {
        //expensive parsing operation
        numOfpages = book.length();
    }

    @Override
    public int getNumPages() {
        return numOfpages;
    }
}
