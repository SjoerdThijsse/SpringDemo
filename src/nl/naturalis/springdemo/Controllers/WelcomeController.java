package nl.naturalis.springdemo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/welcome")
public class WelcomeController {

    /*private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    private static final String VIEW_INDEX = "welcome";

    private static final String HENK = "Henk";
    private static final String JAN = "Jan";
    private static final String JAAP = "Jaap";
    private static final String PETER = "Peter";
    private static final String KLAAS = "Klaas";
    private static final String[] names = new String[]{HENK, JAN, JAAP, PETER, KLAAS};

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model, Map<String, String> attributes) {
        logger.info(VIEW_INDEX);
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/buttons", method = RequestMethod.GET)
    public String buttons(@RequestParam String action, ModelMap model) {
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
    public String input(@RequestParam String fname, @RequestParam String lname, ModelMap model) {
        if (fname.isEmpty() || lname.isEmpty()) {
            logger.info("No first or last name entered.");
            // TODO: more error handling.
        } else {
            logger.info(fname + " " + lname);
            model.addAttribute("name", fname + " " + lname + "!");
        }
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/names/{number}", method = RequestMethod.GET)
    public String names(@PathVariable String number, ModelMap model) {
        try {
            int nameNumber = Integer.parseInt(number);
            model.addAttribute("name", names[nameNumber] + "!");
            logger.info(names[nameNumber]);
        } catch (NumberFormatException e) {
            // TODO: more error handling.
            e.printStackTrace();
        }
        return VIEW_INDEX;
    }*/

}
