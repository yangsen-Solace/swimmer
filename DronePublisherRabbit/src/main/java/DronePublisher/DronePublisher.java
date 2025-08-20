package DronePublisher;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DronePublisher {
	private static volatile boolean isShutdown = false;
	private static final String EXCHANGE_NAME = "topic_CAAS";
	private final static String QUEUE_NAME = "drone";

	@SuppressWarnings("restriction")
	public static void main(String[] args) throws Exception {
		if (args.length < 5) { // Check command line arguments
			System.out.println("Usage: <file-path> <host> <port> <username> <password> [msg-rate]");
			System.exit(-1);
		}
		String filePath = args[0];

		int msg_rate = 1000;
		if (args.length > 5) {
			msg_rate = Integer.parseInt(args[5]);
		}

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(args[1]);
		factory.setPort(Integer.parseInt(args[2]));
		factory.setUsername(args[3]);
		factory.setPassword(args[4]);
		//factory.setCredentialsProvider(new CredentialsProvider());
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String str = "";
		ObjectMapper mapper = new ObjectMapper();

		while (str != null && !isShutdown) {
			str = br.readLine();

			// reached EOF, loop the file again
			if (str == null) {
				br = new BufferedReader(new FileReader(filePath));
				str = br.readLine();
			}
			String s = str.trim();
			Response res = mapper.readValue(s, Response.class);

			// System.out.println(res.message);

			if (res.messageType.compareTo("status response") == 0) {
				MessageBody body = mapper.readValue(res.message, MessageBody.class);
				// System.out.println(body.data.totalCount);
				for (int i = 0; i < body.data.list.size(); i++) {

					DroneTrack trk = new DroneTrack(body.data.list.get(i));
					String msg = trk.toString();
					//System.out.println(msg);
		           
		            // Build BasicProperties with headers
		            AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
		                    .correlationId(trk.AeroscopeID)
		                    .build();
		            
					channel.basicPublish("", QUEUE_NAME, props, msg.getBytes("UTF-8"));
				}
			}

			try {
				Thread.sleep(msg_rate);
			} catch (InterruptedException e) {
				continue;
			}
		}
		br.close();
	}
}
