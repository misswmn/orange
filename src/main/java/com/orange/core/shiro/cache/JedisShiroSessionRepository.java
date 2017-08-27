package com.orange.core.shiro.cache;

import com.orange.core.shiro.session.ShiroSessionRepository;
import com.orange.core.util.JedisClient;
import org.apache.shiro.session.Session;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;

public class JedisShiroSessionRepository implements ShiroSessionRepository {
    @Inject
    private JedisClient jedisClient;

    @Override
    public void saveSession(Session session) {

    }

    @Override
    public void deleteSession(Serializable sessionId) {

    }

    @Override
    public Session getSession(Serializable sessionId) {
        return null;
    }

    @Override
    public Collection<Session> getAllSessions() {
        return null;
    }
}
