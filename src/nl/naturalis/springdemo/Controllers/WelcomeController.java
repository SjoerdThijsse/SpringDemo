package nl.naturalis.springdemo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/welcome")
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    protected static final String VIEW_WELCOME = "welcome";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        logger.info(VIEW_WELCOME);
        return VIEW_WELCOME;
    }

}
