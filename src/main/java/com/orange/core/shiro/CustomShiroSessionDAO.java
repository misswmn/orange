package com.orange.core.shiro;

import com.orange.core.shiro.session.ShiroSessionRepository;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author wangmn
 * @date 2017/8/6
 */
public class CustomShiroSessionDAO extends AbstractSessionDAO {
    @Inject
    private ShiroSessionRepository jedisShiroSessionRepository;

    @Override
    protected Serializable doCreate(Session session) {
        return null;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return null;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {

    }

    @Override
    public void delete(Session session) {

    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }
}