package com.example.practice4new;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SiteController {
    private Map<Integer, String> phrases = new HashMap<>();
    {
        phrases.put(0, ("Если вам сказали, что ваш поезд ушёл, помните — есть ещё много других видов транспорта."));
        phrases.put(1, ("Мир принадлежит оптимистам, пессимисты — всего лишь зрители."));
        phrases.put(2, ("Запомни эту простую фразу, все будет, но не сразу!"));
        phrases.put(3, ("Если из положения нет выхода, надо поменять положение."));
        phrases.put(4, ("Научись радоваться чужим победам, и они к тебе придут."));
    }
    @GetMapping("/phrases")
    public Collection<String> getPhrases(){
        return phrases.values();
    }
    @GetMapping("/phrases/{id}")
    public String getPhrase(@PathVariable Integer id){
        return phrases.get(id);
    }


}
