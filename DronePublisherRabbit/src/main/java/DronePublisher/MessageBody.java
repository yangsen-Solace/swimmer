package DronePublisher;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageBody {
	 @JsonProperty("success")
	 public boolean success;
	 
	 @JsonProperty("message")
	 public MessageCode message;
	 
	 @JsonProperty("data")
	 public MessageData data;
}
