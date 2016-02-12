package nl.naturalis.springdemo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sjoerd.thijsse on 12/02/2016.
 */
@RequestMapping(value = "/")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/")
    public String index() {
        return LoginController.VIEW_LOGIN;
    }

}
