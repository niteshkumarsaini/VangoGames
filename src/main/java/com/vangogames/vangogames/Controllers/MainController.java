package com.vangogames.vangogames.Controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.proc.SecurityContext;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.vangogames.vangogames.Config.UserDetailsServiceImpl;
import com.vangogames.vangogames.Dao.UserRepository;
import com.vangogames.vangogames.Entities.FetchUser;
import com.vangogames.vangogames.Entities.Game;
import com.vangogames.vangogames.Entities.User;
import com.vangogames.vangogames.Entities.Userprofile;
import com.vangogames.vangogames.Helpers.Message;

import com.vangogames.vangogames.Service.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Service service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signinusinggoogle")
    public String signInUsingGoogle(@RequestBody String idToken, HttpSession session, Model m,
            HttpServletRequest request) {
        try {

            String username = service.decoderFunction(idToken);
            User CurrentUser = service.getUserByUsername(username);
            System.out.println("called function");
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username,
                    "123456789");
            Authentication authResult = authenticationManager.authenticate(authRequest);
            SecurityContextHolder.getContext().setAuthentication(authResult);
            System.out.println("User Authenticated");
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            // Example of accessing user details
            if (principal instanceof UserDetails) {
                String usern = ((UserDetails) principal).getUsername();
                System.out.println(usern);
                session.setAttribute("CurrentUser", CurrentUser);
                System.out.println("User is Logged in Successfully...");
               
                return "games";

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "error";

    }

    @PostMapping("/gameredirect")
    public String gameRedirect(@RequestBody String data, HttpSession session) {

        try {
            int id = (int) session.getAttribute("ActiveGame");
            User CurrentUser = (User) session.getAttribute("CurrentUser");

            int scores = Integer.parseInt(data);
            if (scores > 39) {

                // Fetching game
                Game gameref = null;
                if (service.getGameById(id, CurrentUser) == null) {
                    Game game = new Game();

                    game.setGame_id(id);
                    game.setScore(10);

                    game.setUser(CurrentUser);
                    List<Game> games = new ArrayList<>();
                    games.add(game);
                    CurrentUser.setGamesList(games);
                    userRepository.save(CurrentUser);

                } else {
                    gameref = service.getGameById(id, CurrentUser);
                    int oldScore = gameref.getScore();
                    gameref.setScore(oldScore + 10);
                    List<Game> CurrentGame = new ArrayList<>();
                    CurrentGame.add(gameref);
                    CurrentUser.setGamesList(CurrentGame);
                    userRepository.save(CurrentUser);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "index";
    }

    @PostMapping("/updateGameId")
    public String updateId(@RequestBody String data, HttpSession session, Principal principal) {

        try {
            session.removeAttribute("ActiveGame");

            session.setAttribute("ActiveGame", Integer.parseInt(data));

            if (session.getAttribute("CurrentUser") == null) {

                String username = principal.getName();
                User CurrentUser = service.getUserByUsername(username);

                session.setAttribute("CurrentUser", CurrentUser);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }

    @GetMapping("/")
    public String home(Model m, HttpSession session) {

        session.setAttribute("status", true);
        return "games";

    }

    @GetMapping("/games")
    public String games() {

        return "games";

    }

    @GetMapping("/register")
    public String register(Model m) {
        try {

            m.addAttribute("User", new User());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Register";

    }

    @GetMapping("/support")
    public String support() {
        return "Support";

    }

    @PostMapping("/completeprofile")
    public String completeProfile(@Valid @ModelAttribute("Userprofile") Userprofile userprofile, BindingResult result,
            Model m, HttpSession session) {

        try {

            if (result.hasErrors()) {
                session.setAttribute("Message", new Message("Please Enter a Valid Details..", "alert-danger"));
                return "completeProfile";
            }
            User CurrentUser = (User) session.getAttribute("CurrentUser");
            // User testingUser = service.getUserByUsername(userprofile.getUsername());

            // if (testingUser != null) {

            // session.removeAttribute("Message");
            // session.setAttribute("Message", new Message(
            // "This Email is already registered. Please try with different one. ",
            // "alert-success"));

            // return "completeProfile";

            // }

            CurrentUser.setProfile(true);
            CurrentUser.setUsername(userprofile.getUsername());
            userprofile.setCheckbox(true);
            userprofile.setEmailNotification(true);
            userprofile.setMobileNotification(true);
            userprofile.setWhatsappNotification(true);

            userprofile.setUser(CurrentUser);
            CurrentUser.setUserprofile(userprofile);

            service.saveUserWithOldValue(CurrentUser);

            // getting data from db
            List<Game> totalgames = service.getGamesByUser(CurrentUser);
            m.addAttribute("TotalActiveGames", totalgames);

            session.setAttribute("Message", new Message("Welcome to dashboard..", "alert-success"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "dashboard";

    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("User") User user, BindingResult result, Model m,
            HttpSession session) {
        try {

            if (result.hasErrors()) {
                session.setAttribute("Message", new Message("Please Enter Valid Details.", "alert-danger"));
                return "Register";
            }
            User testingUser = service.getUserByUsername(user.getUsername());
            if (testingUser != null) {

                session.removeAttribute("Message");
                session.setAttribute("Message", new Message(
                        "This Email is already registered. Please try with different one. ", "alert-success"));
                return "Register";

            }
            service.saveUser(user);
            m.addAttribute("FetchUser", new User());
            session.setAttribute("Message", new Message("You have been successfully registered..", "alert-success"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Login";

    }

    @GetMapping("/login")
    public String login(Model m, HttpSession session) {
        try {

            m.addAttribute("FetchUser", new User());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Login";

    }

    @GetMapping("/dashboard")
    public String mydashboard(Model m, HttpSession session, Principal principal) {
        try {
            String username = principal.getName();
            User CurrentUser = service.getUserByUsername(username);

            if (CurrentUser == null) {

                return "Login";
            }
            session.setAttribute("CurrentUser", CurrentUser);
            if (!CurrentUser.isProfile()) {

                m.addAttribute("Userprofile", new Userprofile());
                session.setAttribute("Message", new Message("Please Complete your profile here", "alert-danger"));
                return "completeProfile";
            }

            List<Game> totalgames = service.getGamesByUser(CurrentUser);
            m.addAttribute("TotalActiveGames", totalgames);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "dashboard";

    }

    // @PostMapping("/dashboard")
    // public String dashboard(@Valid @ModelAttribute("FetchUser") User fetchUser,
    // BindingResult result, Model m,
    // HttpSession session) {

    // return "dashboard";

    // }

    @GetMapping("/logout")
    public String logout(Model m, HttpSession session) {
        try {

            session.removeAttribute("CurrentUser");
            session.removeAttribute("ActiveGame");
            // session.removeAttribute("TotalScores");
            m.addAttribute("FetchUser", new FetchUser());

            session.setAttribute("Message", new Message("You have been logged out successfully..", "alert-primary"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Login";

    }

    @PostMapping("/updateRedirection")
    public String updateRedirection(@RequestBody String data, HttpSession session) {

        try {
            int id = (int) session.getAttribute("ActiveGame");
            User CurrentUser = (User) session.getAttribute("CurrentUser");

            int scores = Integer.parseInt(data);
            if (scores > 39) {

                // Fetching game
                Game gameref = null;
                if (service.getGameById(id, CurrentUser) == null) {
                    Game game = new Game();

                    game.setGame_id(id);
                    game.setScore(10);

                    game.setUser(CurrentUser);
                    List<Game> games = new ArrayList<>();
                    games.add(game);
                    CurrentUser.setGamesList(games);
                    userRepository.save(CurrentUser);

                } else {
                    gameref = service.getGameById(id, CurrentUser);
                    int oldScore = gameref.getScore();
                    gameref.setScore(oldScore + 10);
                    List<Game> CurrentGame = new ArrayList<>();
                    CurrentGame.add(gameref);
                    CurrentUser.setGamesList(CurrentGame);
                    userRepository.save(CurrentUser);

                }

            }
            session.removeAttribute("ActiveGame");

        } catch (Exception e) {
            e.printStackTrace();

        }

        return "index";

    }

}
