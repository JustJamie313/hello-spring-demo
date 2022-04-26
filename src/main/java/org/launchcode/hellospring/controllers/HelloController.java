package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    private static TreeMap<String,String> translations = new TreeMap<>();

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    public static String createMessage(String name, String language){
        translations.put("English","Hello");
        translations.put("Ukrainian","Привіт");
        translations.put("Greek","γεια σας");
        translations.put("Hebrew","שלום");
        translations.put("Latin","Salve");

        String outputHTML = """
                <html>
                    <style>
                        p{
                            font-size: 24px;
                            color:rgb(127,127,0);
                            text-shadow: 1px 1px rgb(30,127,30);
                        }
                        .name{
                            font-size: 36px;
                            color: rgb(30,127,30);
                            text-shadow: 1px 1px rgb(127,127,0);
                        }
                        .output{
                            background: linear-gradient(rgb(0,0,0),rgb(0,0,100));
                            border-radius: 5%;
                            border: 5px ridge gold;
                            box-shadow: 3px 3px black;
                            width: fit-content;
                            padding: 10px;
                        }
                    </style>
                    <body>
                        <div class='output'>
                            <p>"""+translations.get(language) +", " +
                                "<span class='name'>" + name + "</span>!"+"""
                            </p>
                        <div>
                    </body>
                </html>
                """;
        return outputHTML;
    }
    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, String language) {
        return createMessage(name,language);
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name='language'>" +
                "<option value='English'>English</option>" +
                "<option value='Ukrainian'>Ukrainian</option>" +
                "<option value='Greek'>Greek</option>" +
                "<option value='Hebrew'>Hebrew</option>" +
                "<option value='Latin'>Latin</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
