package org.example;

public class Main {
    public static void main(String[] args) {
        ArabicSpeaker arabicSpeaker = new LanguageAdapter();

        // the translator or the adaptor
        EnglishSpeaker englishSpeaker = new EnglishSpeakerImpl();

        //first one talk
        englishSpeaker.greeting();

        //second one talk
        arabicSpeaker.arabicGreeting();
    }
}