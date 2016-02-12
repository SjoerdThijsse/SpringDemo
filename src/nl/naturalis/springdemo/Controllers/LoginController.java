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
    public String index(@RequestParam String username, @RequestParam String password,
                        ModelMap model) {
        if (!username.isEmpty() && !password.isEmpty()) {
            User user = UserDao.getInstance().get(username, password);
            if (user != null) {
                model.addAttribute("username", user.getUsername());
                return WelcomeController.VIEW_WELCOME;
            }
        }
        model.addAttribute("error", "Please check your username and/or password.");
        return VIEW_LOGIN;
    }

}
