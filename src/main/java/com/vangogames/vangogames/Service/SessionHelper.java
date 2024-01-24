package com.vangogames.vangogames.Service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {
    public void removeSessionAttribute() {
        try {

            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest().getSession();
            session.removeAttribute("Message");
            System.out.println("Message has been removed successfully..");
            System.out.println(session.getAttribute("Message"));

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
