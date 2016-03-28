package test;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class ActiveMQTest {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Test
	public void test() {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createMessage();
				message.setStringProperty("name", "test");
				message.setStringProperty("content", "i am a message !");
				return message;
			}
		});
	}
	
	@Test
	public void testTextMessage() {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("i am a text message !");
			}
		});
	}
	
	@Test
	public void testMapMessage() {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				MapMessage message = session.createMapMessage();
				message.setString("name", "test");
				message.setString("content", "i am a map message !");
				return message;
			}
		});
	}
	
	@Test
	public void testMessages() {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("i am a message 1 !");
			}
		});
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("i am a message 2 !");
			}
		});
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("i am a message 3 !");
			}
		});
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("i am a message 4 !");
			}
		});
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("i am a message 5 !");
			}
		});
	}
}
