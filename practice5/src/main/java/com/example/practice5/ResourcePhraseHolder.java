package com.example.practice5;

import jakarta.validation.constraints.Size;

public class ResourcePhraseHolder {
    @Size(max = 20, message = "Size should be max 20 chars")
    private String phrase;

    public ResourcePhraseHolder(String phrase) {
        this.phrase = phrase;
    }

    public ResourcePhraseHolder() {
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String toString() {
        return "ResourcePhraseHolder{" +
                "phrase='" + phrase + '\'' +
                '}';
    }

}
