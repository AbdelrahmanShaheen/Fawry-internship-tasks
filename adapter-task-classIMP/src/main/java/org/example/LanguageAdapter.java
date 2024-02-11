package org.example;

public class LanguageAdapter extends EnglishSpeakerImpl implements ArabicSpeaker{
    public void arabicGreeting() {
        greeting();
    }
}
