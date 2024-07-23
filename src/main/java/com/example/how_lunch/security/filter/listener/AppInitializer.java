package com.example.how_lunch.security.filter.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AppInitializer implements HttpSessionListener {
    private static int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session created : " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session destroyed : " + activeSessions);
    }
}
