package nl.naturalis.springdemo.Controllers;

import nl.naturalis.springdemo.DatabaseControllers.UserDao;
import nl.naturalis.springdemo.Models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sjoerd.thijsse on 11/02/2016.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    protected static final String VIEW_LOGIN = "login";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {
        logger.info(VIEW_LOGIN);
        return VIEW_LOGIN;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, ModelMap model) {
        if(username.isEmpty() || password.isEmpty()) {
            badLogin(model, "error", "Incorrect username or password.");
        } else {
            User loggedIn = UserDao.getInstance().get(username, password);
            if(loggedIn != null) {
                // Go to welcome page.
                okLogin();
            } else {
                badLogin(model, "error", "Incorrect username or password.");
            }
        }
        return VIEW_LOGIN;
    }

    // Could be a generic method for handeling errors with a <label> tag.
    private void badLogin(ModelMap model, String key, String value) {
        model.addAttribute(key, value);
        logger.info(value);
    }

    private void okLogin() {
        // TODO: Go to welcome page.
        logger.info("Ok");
    }

}
