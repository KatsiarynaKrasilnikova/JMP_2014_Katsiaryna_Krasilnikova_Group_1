package com.epam.cdp.jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by Ilya_Kukushkin on 1/19/2015
 */
public class TopicSendClient {
    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    private static final String DEFAULT_TOPIC = "jms/topic/test";
    private static final String DEFAULT_USERNAME = "test";
    private static final String DEFAULT_PASSWORD = "pass";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private static final String PROVIDER_URL = "remote://localhost:4447";

    TopicConnection conn = null;
    TopicSession session = null;
    Topic topic = null;

    public void setupPubSub()
            throws JMSException, NamingException {

        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
        env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", DEFAULT_USERNAME));
        env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", DEFAULT_PASSWORD));

        Context iniCtx = new InitialContext(env);

        Object tmp = iniCtx.lookup(DEFAULT_CONNECTION_FACTORY);
        TopicConnectionFactory tcf = (TopicConnectionFactory) tmp;
        conn = tcf.createTopicConnection(System.getProperty("username", DEFAULT_USERNAME), System.getProperty("password", DEFAULT_PASSWORD));
        topic = (Topic) iniCtx.lookup(DEFAULT_TOPIC);
        session = conn.createTopicSession(false,
                TopicSession.AUTO_ACKNOWLEDGE);
        conn.start();
    }

    public void sendAsync(CalculatorBean test)
            throws JMSException, NamingException {
        setupPubSub();
        TopicPublisher send = session.createPublisher(topic);
        ObjectMessage om = session.createObjectMessage(test);
        send.publish(om);
        send.close();
    }

    public void stop()
            throws JMSException {
        conn.stop();
        session.close();
        conn.close();
    }
}
