package eatsheet.Controllers;


import eatsheet.Models.Data.UserDAO;
import eatsheet.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.SecureRandom;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "register")
    public String signup(Model model){

        model.addAttribute("title", "Register to Commence the Query!");
        model.addAttribute(new User());
        return "user/register";
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String userValidate(@ModelAttribute @Valid User newUser,
                               Errors errors, @RequestParam String verify, Model model, HttpServletRequest request){
        if (errors.hasErrors()) {

            model.addAttribute("title", "Register to Commence the Query!");
            return "user/register";
        }

        if (newUser.getPassword().equals(verify)){



            //SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            //////////////////////////////////////
            SecureRandom sr = new SecureRandom();
            byte[] salt = new byte[32];
            sr.nextBytes(salt);
            String strSalt = salt.toString();
            //////////////////////////////////////
            //newUser.setPassword(newUser.getPassword()+ strSalt);
            newUser.setPassword(Integer.toString(newUser.hashCode()));
            //newUser.hashCode();
            userDao.save(newUser);
            //return "redirect:/user";
            HttpSession session = request.getSession(true);   //Gets session object, creates a new session if object doesn't exist
            return "redirect:/user/login";
        }
        model.addAttribute("title", "Register to Commence the Query!");
        model.addAttribute("verError", "Passwords do not match.");
        return "user/register";

    }
    @RequestMapping(value = "login")
    public String login(Model model){

        model.addAttribute("title", "Login to Commence the Query!");
        model.addAttribute(new User());


        return "user/login";
    }
    //////////////////////////////////////////////////////////////////////////




    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginValidate(@ModelAttribute @Valid User newUser, Errors errors, Model model, HttpServletRequest request){


        if (errors.hasErrors()) {

            model.addAttribute("title", "Login to Commence the Query!");

            return "user/login";
        }

        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[32];
        sr.nextBytes(salt);
        String strSalt = salt.toString();

        Iterable<User> users = userDao.findAll();
        for(User aUser: users){
            if(aUser.getName().equals(newUser.getName()) ){
                //newUser.setPassword(newUser.getPassword() + strSalt);
                //if(aUser.getPassword().equals(newUser.getPassword())){

                if(aUser.getPassword().equals(Integer.toString(newUser.hashCode()))){
                    HttpSession session = request.getSession(true);   //Gets session object, creates a new session if object doesn't exist

                    return "redirect:/home";
                }
                else{

                    model.addAttribute("title", "Login to Commence the Query!");
                    model.addAttribute("passwordError", "Incorrect password");
                    return "user/login";
                }
            }

        }
        model.addAttribute("title", "Login to Commence the Query!");
        model.addAttribute("nameError", "Incorrect username");
        return "user/login";

    }

    @RequestMapping(value="logout")
    public String logoutHandler(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.invalidate();

        return "redirect:/user/login";
    }

}
