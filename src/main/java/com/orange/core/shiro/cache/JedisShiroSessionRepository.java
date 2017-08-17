package com.orange.core.shiro.cache;

import com.orange.core.common.ServiceCode;
import com.orange.core.common.ServiceException;
import com.orange.core.shiro.session.CustomSessionManager;
import com.orange.core.shiro.session.SessionStatus;
import com.orange.core.shiro.session.ShiroSessionRepository;
import com.orange.core.util.JedisClient;
import com.orange.core.util.LoggerUtils;
import com.orange.core.util.SerializeUtil;
import org.apache.shiro.session.Session;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author wangmn
 * @date 2017/8/6
 */
public class JedisShiroSessionRepository implements ShiroSessionRepository {
    public static final String REDIS_SHIRO_SESSION = "orange-shiro-session:";
    //这里有个小BUG，因为Redis使用序列化后，Key反序列化回来发现前面有一段乱码，解决的办法是存储缓存不序列化
    public static final String REDIS_SHIRO_ALL = "*orange-shiro-session:*";
    private static final int SESSION_VAL_TIME_SPAN = 18_000;
    private static final int DB_INDEX = 1;
    @Inject
    private JedisClient jedisClient;

    @Override
    public void saveSession(Session session) {
        if (session == null) {
            throw new ServiceException(ServiceCode.SESSION_TIMEOUT, "session is empty");
        }
        try {
            byte[] key = SerializeUtil.serialize(buildRedisSessionKey(session.getId()));


            //不存在才添加。
            if (null == session.getAttribute(CustomSessionManager.SESSION_STATUS)) {
                //Session 踢出自存存储。
                SessionStatus sessionStatus = new SessionStatus();
                session.setAttribute(CustomSessionManager.SESSION_STATUS, sessionStatus);
            }

            byte[] value = SerializeUtil.serialize(session);
            long sessionTimeOut = session.getTimeout() / 1000;
            Long expireTime = sessionTimeOut + SESSION_VAL_TIME_SPAN + (5 * 60);
//            jedisClient.selectAndSet(DB_INDEX, key, value, expireTime.intValue());
        } catch (Exception e) {
            LoggerUtils.fmtError(getClass(), e, "save session error，id:[%s]", session.getId());
        }
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

    private String buildRedisSessionKey(Serializable sessionId) {
        return REDIS_SHIRO_SESSION + sessionId;
    }

    public static void main(String[] args) {
        byte[] b = SerializeUtil.serialize("orange-shiro-session:"+"jfd0jf9fl123ljfo");
        System.out.println(new String(b));
    }
}
