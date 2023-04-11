package com.example.practice5;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Objects;

@Data
public class ResourcePhraseHolder {
    /*
    * With Lombok
    * */
    @Size(max = 20, message = "Size should be max 20 chars")
    private String phrase;
    /*
     * With Lombok
     * */
    public ResourcePhraseHolder(String phrase) {
        this.phrase = phrase;
    }
    /*
     * With Lombok
     * */
    public ResourcePhraseHolder() {
    }
/*
* Java Vanilla without Lombok
* */
//    public String getPhrase() {
//        return phrase;
//    }
    /*
     * Java Vanilla without Lombok
     * */
//    public void setPhrase(String phrase) {
//        this.phrase = phrase;
//    }
    /*
     * Java Vanilla without Lombok
     * */
//    @Override
//    public String toString() {
//        return "ResourcePhraseHolder{" +
//                "phrase='" + phrase + '\'' +
//                '}';
//    }
    /*
     * Java Vanilla without Lombok
     * */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof ResourcePhraseHolder that)) return false;
//        return Objects.equals(getPhrase(), that.getPhrase());
//    }
    /*
     * Java Vanilla without Lombok
     * */
//    @Override
//    public int hashCode() {
//        return Objects.hash(getPhrase());
//    }
}
