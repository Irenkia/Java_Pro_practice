package com.example.practice4;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PhraseService {
    private Map<Integer, Phrase> phrases = new HashMap<>();

    public PhraseService() {
        phrases.put(0, new Phrase("Если вам сказали, что ваш поезд ушёл, помните — есть ещё много других видов транспорта."));
        phrases.put(1, new Phrase("Мир принадлежит оптимистам, пессимисты — всего лишь зрители."));
        phrases.put(2, new Phrase("Запомни эту простую фразу, все будет, но не сразу!"));
        phrases.put(3, new Phrase("Если из положения нет выхода, надо поменять положение."));
        phrases.put(4, new Phrase("Научись радоваться чужим победам, и они к тебе придут."));
    }

    public void addPhrase(Phrase phrase) {
        phrases.put(phrases.size() + 1, phrase);
    }

    public Phrase getPhrase(Integer id) {
        Phrase mistake = new Phrase("Phrase not found");
        boolean check = phrases.containsKey(id);
        if (check) {
            return phrases.get(id);
        } else {
            return mistake;
        }
    }

    public Collection<Phrase> getAllPhrases() {
        return phrases.values();
    }

}
