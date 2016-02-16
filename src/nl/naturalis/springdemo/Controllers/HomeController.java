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

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    protected static final String VIEW_HOME = "home";

    private static User user = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        logger.info(VIEW_HOME);
        return "redirect:/" + LoginController.VIEW_LOGIN + "/";
    }

    @RequestMapping(value = "/{userId}/", method = RequestMethod.GET)
    public String viewUser(ModelMap model, @PathVariable("userId") String userId) {
        logger.info(VIEW_HOME);
        user = UserDao.getInstance().get(Integer.parseInt(userId));

        if(user != null) {
            model.addAttribute("username", user.getUsername());
        } else {
            return "redirect:/" + LoginController.VIEW_LOGIN + "/";
        }
        return VIEW_HOME;
    }

}
