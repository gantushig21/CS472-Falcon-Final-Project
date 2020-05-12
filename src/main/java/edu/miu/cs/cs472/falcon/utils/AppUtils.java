package edu.miu.cs.cs472.falcon.utils;

import edu.miu.cs.cs472.falcon.model.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AppUtils {
    private static int REDIRECT_ID = 0;

    private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
    private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();

    public static void storeLoggedUser(HttpSession session, User loggedUser) {
        session.setAttribute("loggedUser", loggedUser);
    }

    public static User getLoggedUser(HttpSession session) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        return loggedUser;
    }

}

