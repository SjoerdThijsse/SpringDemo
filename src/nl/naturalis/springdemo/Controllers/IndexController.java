package nl.naturalis.springdemo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by sjoerd.thijsse on 11/02/2016.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private static final String VIEW_INDEX = "index";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model, Map<String, String> attributes) {
        logger.info("index");
        return VIEW_INDEX;
    }

}
