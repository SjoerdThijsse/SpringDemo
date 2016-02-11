package nl.naturalis.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    private static final String VIEW_INDEX = "index";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("message", "");
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {
        model.addAttribute("message", "Welcome " + name);
        return VIEW_INDEX;
    }

}
