package com.alik.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {


    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) Integer a,
                             @RequestParam(value = "b", required = false) Integer b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        model.addAttribute("result", a + " " + symbol(action) + " " + b + " = " + calc(a, b, action));
        return "first/calculator";
    }


    @GetMapping("/goodbye")
    public String goodBuyPage() {
        return "first/goodbye";
    }


    private String calc(Integer a, Integer b, String s) {
        int result = 0;
        double divisionResult=0.0;
        try {
            switch (s) {
                case "addition":
                    result = (a + b);
                    break;
                case "subtraction":
                    result = a - b;
                    break;
                case "multiplication":
                    result = a * b;
                    break;
                case "division":
                    divisionResult = (double) a / b;
                    return Double.toString(divisionResult);
            }
        }catch (Exception e){
            return "You did something wrong";
        }
        return Integer.toString(result);
    }

    private String symbol(String strr){
        String symbol ="";
        try {
            if (strr.equals("addition")) {
                symbol="+";
            } else if (strr.equals("subtraction")) {
                symbol="-";
            } else if (strr.equals("multiplication")) {
                symbol="*";
            } else if (strr.equals("division")) {
                symbol="/";
            }
        }catch (Exception e){
            return "You did something wrong";
        }
        return symbol;
    }
}
