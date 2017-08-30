package com.orange.core.shiro.cache;

import com.orange.core.common.ServiceCode;
import com.orange.core.common.ServiceException;
import com.orange.core.shiro.session.CustomSessionManager;
import com.orange.core.shiro.session.SessionStatus;
import com.orange.core.shiro.session.ShiroSessionRepository;
import com.orange.core.util.JedisClient;
import com.orange.core.util.SerializeUtil;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;

@Component
public class JedisShiroSessionRepository implements ShiroSessionRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(JedisShiroSessionRepository.class);
    private static final String REDIS_SHIRO_SESSION = "orange_shiro_session";
    private static final int SESSION_VAL_TIME_SPAN = 18 * 1000;
    @Inject
    private JedisClient jedisClient;

    @Override
    public void saveSession(Session session) {
        if (session == null || session.getId() == null) {
            throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "");
        }
        if (session.getAttribute(CustomSessionManager.SESSION_STATUS) == null) {
            SessionStatus sessionStatus = new SessionStatus();
            session.setAttribute(CustomSessionManager.SESSION_STATUS, sessionStatus);
        }
        byte[] key = SerializeUtil.serialize(buildRedisSessionKey(session.getId()));
        byte[] value = SerializeUtil.serialize(session);
        long sessionTimeout = session.getTimeout() / 1000;
        long expireTime = sessionTimeout + SESSION_VAL_TIME_SPAN + (5 * 60);
        jedisClient.set(key, value, (int) expireTime);
    }

    @Override
    public void deleteSession(Serializable sessionId) {

    }

    @Override
    public Session getSession(Serializable sessionId) {
        byte[] key = SerializeUtil.serialize(buildRedisSessionKey(sessionId));
        byte[] sessionBytes = jedisClient.get(key);
        if (sessionBytes == null) return null;
        return SerializeUtil.deserialize(sessionBytes, Session.class);
    }

    @Override
    public Collection<Session> getAllSessions() {
        return null;
    }

    private String buildRedisSessionKey(Serializable id) {
        return REDIS_SHIRO_SESSION + id;
    }
}
