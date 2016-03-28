package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JMSListener implements MessageListener {

	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private Random random = new Random();

	public void onMessage(Message message) {
		try {
			Date beginDate = new Date();
			Thread.sleep(random.nextInt(5) * 1000);
			Date endDate = new Date();
			System.out.println();
			System.out.println("--------------------" + dateFormat.format(beginDate) + "  " + Thread.currentThread());
			handleMessage(message);
			System.out.println("--------------------" + dateFormat.format(endDate) + "--------------------");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void handleMessage(Message message) throws Exception {
		if (message instanceof MapMessage) {
			MapMessage mapMessage = (MapMessage) message;
			Enumeration<String> mapNames = mapMessage.getMapNames();
			StringBuilder buf = new StringBuilder("ActiveMQ收到了消息: ");
			while (mapNames.hasMoreElements()) {
				String mapName = mapNames.nextElement();
				String mapValue = mapMessage.getString(mapName);
				buf.append(mapName + "=" + mapValue + ", ");
			}
			int lastSeparatorIndex = buf.lastIndexOf(",");
			if (lastSeparatorIndex > -1)
				buf.replace(lastSeparatorIndex, lastSeparatorIndex + 2, "");
			System.out.println(buf.toString());
		} else if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			System.out.println("ActiveMQ收到了消息: " + textMessage.getText());
		} else {
			Enumeration<String> mapNames = message.getPropertyNames();
			StringBuilder buf = new StringBuilder("ActiveMQ收到了消息: ");
			while (mapNames.hasMoreElements()) {
				String mapName = mapNames.nextElement();
				String mapValue = message.getStringProperty(mapName);
				buf.append(mapName + "=" + mapValue + ", ");
			}
			int lastSeparatorIndex = buf.lastIndexOf(",");
			if (lastSeparatorIndex > -1)
				buf.replace(lastSeparatorIndex, lastSeparatorIndex + 2, "");
			System.out.println(buf.toString());
		}
	}

}
