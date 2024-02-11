package org.example;

public class Main {
    public static void main(String[] args) {
        IBookParser parser = new LazyBookParserProxy("Java book");
        System.out.println(parser.getNumPages());
    }
}