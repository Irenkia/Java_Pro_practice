package com.example.practice5new;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    private int id = 10;
    private Map<Integer,String> quotes = new HashMap<>();
    @PostConstruct
    void setUp(){
        quotes.put(0,"Тепер, коли ми навчилися літати у повітрі, як птахи, плавати під водою, як риби, \n" +
                " нам не вистачає тільки одного: навчитися жити на землі, як люди.\n");
        quotes.put(1,"Не чекай, що стане легше, простіше, краще. Не стане. Труднощі будуть завжди.\n " +
                "Вчися бути щасливим прямо зараз. Інакше не встигнеш.\n"  +
                "Біль іноді йде, але думки-то залишаються.\n");
        quotes.put(2, "Якщо під музику не танцюють – це не музика\n");
        quotes.put(3,"– Скажіть, Дрісом, як ви думаєте, чому людей тягне до мистецтва?\n" +
                "– Може, тому що це прибутково?\n" +
                "– Ні, це єдиний спосіб залишити слід на землі.\n");
        quotes.put(4,"Прокласти свій шлях майже неможливо, якщо ступати весь час по чужих слідах.\n");
        quotes.put(5,"Наш припис призвів до того, що ми вкрали в дітей саме те, що допоможе їм стати сильними, — складнощі.\n");
        quotes.put(6,"Ідеальний чоловік - це чоловік, що вважає, що у нього ідеальна дружина. \n");
        quotes.put(7,"Життя - це не пошук себе. Життя - це створення себе. \n");
        quotes.put(8,"Люди, які вміють веселитися, не мають грошей, а люди, які мають гроші, не вміють веселитися. \n");
        quotes.put(9,"Людина - як цегла: обпалюючись, твердне.\n");

        quotes.put(10, "Please, enter the parametr = number from 0 to 9 to read the different texts");
    }
//  1 - version ( 1 quote from id)
//    @GetMapping("/quote")
//    public String gerQuote(HttpServletRequest request){
//        var id = Integer.parseInt(request.getParameter("id"));
//        return quotes.get(id);
//    }
//  2 - version  ( 1 quote from id)
//    @GetMapping("/quote")
//    public String gerQuote(@RequestParam("id") Integer id){
//        return quotes.get(id);
//    }
//  3 - version  ( 1 quote from id)
    @GetMapping("/quotes/{id}")
    public String getQuote(@PathVariable Integer id) {
        return quotes.get(id);
    }

    //  1 - version  ( all quotes)
//    @GetMapping("/quotes")
//    public Map<Integer,String> getQuotes() {
//        return quotes;
//    }
    //  2 - version  ( all quotes)
    @GetMapping("/quotes")
    public Collection<String> getQuotes() {
        return quotes.values();
    }

    //  1 - version  ( post 1 quote)
//    @PostMapping("/quotes")
//    public void postQuote(@RequestBody String quote) {
//        quotes.put(quotes.size() + 1, quote);
//    }
    //  2 - version  ( post 1 quote)
//     @PostMapping("/quotes")
//    public void postQuote(@RequestBody Quote quote) {
//        quotes.put(quotes.size() + 1, quote.getQuote());
//    }
    //  3 - version  ( post 1 quote)
//    @PostMapping("/quotes")
//    public ResourceIdHolder postQuote(@RequestBody @Validated Quote quote) {
//        var response = new ResourceIdHolder(++id);
//        quotes.put(response.getId(), quote.getQuote());
//        return response;
//    }
    //  4 - version  ( post 1 quote)
    @PostMapping("/quotes")
    public ResourceIdHolder postQuote(@RequestBody @Validated String quote) {
        var response = new ResourceIdHolder(++id);
        quotes.put(response.getId(), quote);
        return response;
    }

}
