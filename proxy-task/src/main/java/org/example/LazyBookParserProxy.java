package org.example;

public class LazyBookParserProxy implements IBookParser{
    private BookParser parser = null;
    private String book = null;
    public LazyBookParserProxy(String book) {
        this.book = book;
    }

    @Override
    public int getNumPages() {
        if(parser == null){
            this.parser = new BookParser(this.book);
        }
        return parser.getNumPages();
    }
}
