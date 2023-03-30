package com.example.practice3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
public class GreetingController {
    public String addPhrases(){
        ArrayList<String> list =  new ArrayList<>();
        list.add("Если вам сказали, что ваш поезд ушёл, помните — есть ещё много других видов транспорта.\n" + "\n");
        list.add("Мир принадлежит оптимистам, пессимисты — всего лишь зрители.\n" + "\n");
        list.add("Запомни эту простую фразу, все будет, но не сразу!\n" + "\n");
        list.add("Если из положения нет выхода, надо поменять положение.\n" + "\n");
        list.add("Научись радоваться чужим победам, и они к тебе придут.\n" + "\n" );
        Random rand = new Random();
        String phrase = list.get(rand.nextInt(list.size()));
        return phrase;
    }

    @GetMapping("/greeting")
    public String greeting(){
        return addPhrases();
    }

}
