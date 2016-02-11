package nl.naturalis.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WelcomeController {

    private static final String VIEW_INDEX = "index";

    private static final String HENK = "Henk";
    private static final String JAN = "Jan";

    private final static Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model, Map<String, String> attributes) {
        logger.info("[welcome]");
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/buttons", method = RequestMethod.GET)
    public String handlePost(@RequestParam String action, ModelMap model) {
        Map<String, String> attributes = new HashMap<String, String>();
        if (action.equals(HENK)) {
            attributes.put("name", HENK + "!");
        } else if (action.equals(JAN)) {
            attributes.put("name", JAN + "!");
        } else {
            attributes.put("name", "ERROR");
        }
        model.addAllAttributes(attributes);
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String test(@RequestParam String fname, @RequestParam String lname, ModelMap model) {
        logger.info(fname + " " + lname);
        model.addAttribute("name", fname + " " + lname);
        return VIEW_INDEX;
    }

    /*@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {
        model.addAttribute("message", "Welcome " + name);
        logger.info("[welcomeName] name : {}", name);
        return VIEW_INDEX;
    }*/

}
