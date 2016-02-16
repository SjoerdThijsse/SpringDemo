package nl.naturalis.springdemo.Controllers;

import nl.naturalis.springdemo.DatabaseControllers.UserDao;
import nl.naturalis.springdemo.Models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    protected static final String VIEW_HOME = "home";

    private static User user = null;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        logger.info(VIEW_HOME);
        return "redirect:/" + LoginController.VIEW_LOGIN + "/";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String viewUser(ModelMap model, @PathVariable("userId") String userId) {
        logger.info(VIEW_HOME);
        user = UserDao.getInstance().get(Integer.parseInt(userId));

        if (user != null) {
            model.addAttribute("userId", userId);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("password", user.getPassword());
            model.addAttribute("email", user.getEmail());
        } else {
            return "redirect:/" + LoginController.VIEW_LOGIN + "/";
        }
        return VIEW_HOME;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public String updateUser(ModelMap model, @PathVariable("userId") String userId, @RequestParam String username,
                             @RequestParam String password, @RequestParam String passwordAgain, @RequestParam String email) {
        if (password.equals(passwordAgain)) {
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            UserDao.getInstance().update(user);
            logger.info(user.toString());

            model.addAttribute("error", "User succesfully changed.");
        } else {
            model.addAttribute("error", "Passwords do not match!");
        }

        return viewUser(model, userId);
    }

}
