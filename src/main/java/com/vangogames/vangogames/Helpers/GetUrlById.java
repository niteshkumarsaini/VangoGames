package com.vangogames.vangogames.Helpers;

import java.util.HashMap;
import com.vangogames.vangogames.Entities.Game;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.vangogames.vangogames.Entities.User;
import com.vangogames.vangogames.Service.Service;

import jakarta.servlet.http.HttpSession;

@Component
public class GetUrlById {
    @Autowired
    private Service service;

    String url[] = {
            "Game_Cover/1.png",
            "Game_Cover/2.png",
            "Game_Cover/3.png",
            "Game_Cover/4.png",
            "Game_Cover/5.png",
            "Game_Cover/6.png",
            "Game_Cover/7.png",
            "Game_Cover/8.png",
            "Game_Cover/9.png",
            "Game_Cover/10.png",
            "Game_Cover/11.png",
            "Game_Cover/12.png",
            "Game_Cover/13.png",
            "Game_Cover/14.png",
            "Game_Cover/15.png",
            "Game_Cover/16.png",
            "Game_Cover/17.png",
            "Game_Cover/18.png",
            "Game_Cover/19.png",
            "Game_Cover/20.png",
            "Game_Cover/21.png",
            "Game_Cover/22.png",
            "Game_Cover/23.png",
            "Game_Cover/24.png",
            "Game_Cover/25.png",
            "Game_Cover/26.png",
            "Game_Cover/27.png",
            "Game_Cover/28.png",
            "Game_Cover/29.png",
            "Game_Cover/30.png",
            "Game_Cover/31.png",
            "Game_Cover/32.png",
            "Game_Cover/33.png",
            "Game_Cover/34.png",

    };

    String nameUrl[] = {
            "Christmas Match 3",
            "Christmas Ballons",
            "Great Air Battles",
            "Super Pongoal",
            "MGFK",
            "Supercars Puzzle",
            "Forest Brothers",
            "Crazy Car",
            "Kindom Defence",
            "Mad Fish",
            "Sahara Invasion",
            "Warriors Vs Evil Spirit",
            "Brick Breaker Unicorn",
            "Grand Commander",
            "JAGO",
            "Pool 8 Ball",
            "Handless Millionnaire",
            "Santa Run",
            "Stack Jump",
            "Happy Halloween",
            "Angry Cat Shot",
            "Fruit Slacher",
            "Stick Monkey",
            "Plumber",
            "Viking Escape",
            "Duck Hunter",
            "Halloween Bubble Shooter",
            "Ninja Run New",
            "Fruit Snake",
            "Tank Defender",
            "Fishing Frenzy",
            "Crazy Runner",
            "Traffic",
            "Girl Dress Up"

    };

    String redirection[] = {
            "/games/game1/index.html",
            "/games/game2/index.html",
            "/games/game3/index.html",
            "/games/game4/index.html",
            "/games/game5/index.html",
            "/games/game6/index.html",
            "/games/game7/index.html",
            "/games/game8/index.html",
            "/games/game9/index.html",
            "/games/game10/index.html",
            "/games/game11/index.html",
            "/games/game12/index.html",
            "/games/game13/index.html",
            "/games/game14/index.html",
            "/games/game15/index.html",
            "/games/game16/index.html",
            "/games/game17/index.html",
            "/games/game18/index.html",
            "/games/game19/index.html",
            "/games/game20/index.html",
            "/games/game21/index.html",
            "/games/game22/index.html",
            "/games/game23/index.html",
            "/games/game24/index.html",
            "/games/game25/index.html",
            "/games/game26/index.html",
            "/games/game27/index.html",
            "/games/game28/index.html",
            "/games/game29/index.html",
            "/games/game30/index.html",
            "/games/game31/index.html",
            "/games/game32/index.html",
            "/games/game33/index.html",
            "/games/game34/index.html"

    };

    public String fetchUrl(int id) {
        return url[id];

    }

    public String getName(int id) {
        return nameUrl[id];
    }

    public int getTotalScores() {
        int total = 0;
        try {

            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest().getSession();
            User CurrentUser = (User) session.getAttribute("CurrentUser");
            List<Game> games = service.getGamesByUser(CurrentUser);
            for (Game game : games) {
                int score = game.getScore();
                total = total + score;

            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public String getGameUrl(int id) {
        return redirection[id];
    }

}
