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
@RequestMapping(value = "/register")
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    protected static final String VIEW_REGISTER = "register";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {
        logger.info(VIEW_REGISTER);
        return VIEW_REGISTER;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String register(@RequestParam String username, @RequestParam String password,
                           @RequestParam String passwordAgain, @RequestParam String email, ModelMap model) {
        if (username.isEmpty() || password.isEmpty() || passwordAgain.isEmpty() || email.isEmpty()) {
            badRegister(model, "error", "Some field(s) are not filled.");
        } else {
            if(password.equals(passwordAgain)) {
                return okRegister(model, username, password, email);
            } else {
                badRegister(model, "error", "Passwords don't match!");
            }
        }
        return VIEW_REGISTER;
    }

    private void badRegister(ModelMap model, String key, String value) {
        model.addAttribute(key, value);
        logger.info(value);
    }

    private String okRegister(ModelMap model, String username, String password, String email) {
        User user = new User(username, password, email);
        int rows = UserDao.getInstance().insert(user);
        if(rows > 0) {
            logger.info(Integer.toString(rows));
            return "success_register";
        } else {
            badRegister(model, "error", "Error username '" + username + "' already exists.");
        }
        return VIEW_REGISTER;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String back() {
        logger.info(LoginController.VIEW_LOGIN);
        return LoginController.VIEW_LOGIN;
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String successful() {
        return back();
    }

}
