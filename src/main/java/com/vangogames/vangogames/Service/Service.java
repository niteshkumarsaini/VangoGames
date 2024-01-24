// package com.vangogames.vangogames.Service;

// import java.util.Optional;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Component;

// import com.vangogames.vangogames.Dao.GameRepository;
// import com.vangogames.vangogames.Dao.UserRepository;
// import com.vangogames.vangogames.Entities.Game;
// import com.vangogames.vangogames.Entities.User;
// import java.util.Collections;

// @Component
// public class Service {
//     @Autowired
//     private UserRepository userRepository;

//     @Autowired
//     private PasswordEncoder passwordEncoder;

//     @Autowired
//     private GameRepository gameRepository;

//     public User getUserByUsernameAndPassword(String email, String password) {
//         User user = userRepository.findByUsernameAndPassword(email, password);
//         return user;

//     }

//     public User SaveUser(User user) {
//         String pass = user.getPassword();

//         user.setPassword(passwordEncoder.encode(pass));
//         user.setRole("USER");

//         userRepository.save(user);
//         return user;

//     }

//     public User saveUserwithOldValue(User user) {
//         userRepository.save(user);
//         return user;

//     }

//     public User getUserByUsername(String username) {
//         return userRepository.findByUsername(username);
//     }

//     public Game getGameById(int id, User user) {
//         Optional<Game> optionalGame = gameRepository.findByUser(user);
//         Game mygame = null;
//         List<Game> games = optionalGame.map(Collections::singletonList).orElse(Collections.emptyList());
//         for (Game g : games) {
//             if (g.getGame_id() == id) {
//                 mygame = g;
//                 return mygame;

//             }
//         }

//         return mygame;

//     }

//     public List<Game> getGamesByUser(User user) {
//         Optional<Game> optionalGame = gameRepository.findFirstByUser(user);
//         Game mygame = null;
//         List<Game> games = optionalGame.map(Collections::singletonList).orElse(Collections.emptyList());
//         return games;

//     }

// }

package com.vangogames.vangogames.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vangogames.vangogames.Dao.GameRepository;
import com.vangogames.vangogames.Dao.UserRepository;
import com.vangogames.vangogames.Entities.Game;
import com.vangogames.vangogames.Entities.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class Service {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private GameRepository gameRepository;

    public User getUserByUsernameAndPassword(String email, String password) {
        User user = userRepository.findByUsernameAndPassword(email, password);
        return user;
    }

    public User saveUser(User user) {
        String pass = user.getPassword();
        user.setPassword(passwordEncoder.encode(pass));
        user.setRole("USER");
        userRepository.save(user);
        return user;
    }

    public User saveUserWithOldValue(User user) {
        userRepository.save(user);
        return user;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Game getGameById(int id, User user) {
        try {
            List<Game> games = gameRepository.findAllByUser(user);

            for (Game g : games) {
                if (g.getGame_id() == id) {
                    return g;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Game> getGamesByUser(User user) {
        return gameRepository.findAllByUser(user);
    }
    public String decoderFunction(String encoded){
       
        String str=new String(new StringBuffer(encoded).reverse());
        // System.out.println(str.substring(13,str.length()-17).split("tyeehddkkWEWTTTHHh662387dbbeddjj99")[0]);
String finalS=str.substring(13,str.length()-17).split("tyeehddkkWEWTTTHHh662387dbbeddjj99")[1]+str.substring(13,str.length()-17).split("tyeehddkkWEWTTTHHh662387dbbeddjj99")[0];

        return finalS;

    }
   

    
}
