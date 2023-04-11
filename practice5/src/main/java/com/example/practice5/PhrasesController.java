package com.example.practice5;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PhrasesController {
    private Map<Integer, String> phrases = new HashMap<Integer, String>();

    public PhrasesController() {
        phrases.put(0, ("Если вам сказали, что ваш поезд ушёл, помните — есть ещё много других видов транспорта."));
        phrases.put(1, ("Мир принадлежит оптимистам, пессимисты — всего лишь зрители."));
        phrases.put(2, ("Запомни эту простую фразу, все будет, но не сразу!"));
        phrases.put(3, ("Если из положения нет выхода, надо поменять положение."));
        phrases.put(4, ("Научись радоваться чужим победам, и они к тебе придут."));

    }

    @GetMapping("/phrases")
    public Collection<String> getPhrases() {
        return phrases.values();
    }

    @GetMapping("/phrases/{id}")
    public String getPhrase(@PathVariable Integer id) {
        if (phrases.containsKey(id)) {
            return phrases.get(id);
        } else {
            return "Phrase not found";
        }
    }

    //        1 version ( 1 phrase)
    @PostMapping("/phrase")
    public ResourceIdHolder postPhrase(@RequestBody @Validated String phrase) {
        var resId = new ResourceIdHolder(phrases.size() + 1);
        var resPhrase = new ResourcePhraseHolder(phrase);
        phrases.put(resId.getId(), resPhrase.getPhrase());
        return resId;
    }
    //        2 version ( 1 phrase)
//        in Postman this method does not work
//    @PostMapping("/phrase")
//    public ResourceIdHolder postQuote(@RequestBody ResourcePhraseHolder phrase) {
//        var response = new ResourceIdHolder(phrases.size() + 1);
//        phrases.put(response.getId(), phrase.getPhrase());
//        return response;
//    }



    //        1 version ( many phrases)
    //        in Postman this method does not work
//    @PostMapping("/phrases")
//    public String postPhrase(@RequestBody String[] strings) {
//        int size = phrases.size();
//        if (strings.length != 0) {
//            for (int i = 0; i < strings.length; i++) {
//                phrases.put(size, strings[i]);
//                size++;
//            }
//            return "status Ok";
//        }
//        return "Not Found";
//    }

    //        2 version ( many phrases)
    @PostMapping("/phrases")
    public String postPhrase(@RequestBody ResourcePhraseHolder[] strings) {

        int size = phrases.size();
        if (strings.length != 0) {
            for (int i = 0; i < strings.length; i++) {
                phrases.put(size, strings[i].getPhrase());
                size++;
            }
            return "status Ok";
        }
        return "Not Found";
    }

    @PutMapping("/phrases/{id}")
    public String updatePhrase(@PathVariable Integer id, @RequestBody String phrase) {
        if (phrases.containsKey(id)) {
            phrases.put(id, phrase);
            return "status Ok";
        } else {
            return "Id not found";
        }
    }


    @DeleteMapping("/phrases/{id}")
    public String deletePhrase(@PathVariable Integer id) {
        if (phrases.containsKey(id)) {
            phrases.remove(id);
            return "status Ok";
        } else {
            return "Id not found";
        }
    }

}
