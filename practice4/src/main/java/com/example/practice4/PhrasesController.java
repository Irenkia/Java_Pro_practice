package com.example.practice4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PhrasesController {
    private final PhraseService phraseService;

    public PhrasesController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping("/phrases")
    public String viewPhrases(Model model) {
        var phrases = phraseService.getAllPhrases();
        model.addAttribute("phrases", phrases);
        return "phrases.html";
    }

    @GetMapping("/phrases/{id}")
    public String phrase(@PathVariable Integer id, Model model) {
        var phrase = phraseService.getPhrase(id);
        model.addAttribute("id", id);
//        return phrase.toString();
        phrase.toString();
        return "phrase.html";
    }
}
