package com.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Configuration
public class SessionListener implements HttpSessionListener {

    @Value("${server.servlet.session.timeout}")
    private String sessionTimeout;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        if(sessionTimeout.endsWith("s")) {
            se.getSession().setMaxInactiveInterval(Integer.parseInt(sessionTimeout.substring(0, sessionTimeout.length()-1)));
        }
        else {
            // for minutes
            se.getSession().setMaxInactiveInterval(60 * Integer.parseInt(sessionTimeout.substring(0, sessionTimeout.length()-1)));
        }
    }
}
