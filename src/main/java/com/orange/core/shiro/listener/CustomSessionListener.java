package com.orange.core.shiro.listener;

import com.orange.core.shiro.session.ShiroSessionRepository;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import javax.inject.Inject;

public class CustomSessionListener implements SessionListener {
    @Inject
    private ShiroSessionRepository jedisShiroSessionRepository;

    @Override
    public void onStart(Session session) {

    }

    @Override
    public void onStop(Session session) {

    }

    @Override
    public void onExpiration(Session session) {

    }
}
