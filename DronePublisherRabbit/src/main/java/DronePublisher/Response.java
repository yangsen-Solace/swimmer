package DronePublisher;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	@JsonProperty("message.type")
	public String messageType;
	
	@JsonProperty("@timestamp")
	private Date timestamp;
	@JsonProperty("message")
	public String message;

	
//	@JsonCreator
//	public Response(
//	    @JsonProperty(value = "message.type", required = true) String key1,
//	    @JsonProperty(value = "@timestamp", required = true) Date key2,
//	    @JsonProperty(value = "message", required = true) String key3) {
//	    this.messageType = key1;
//	    this.timestamp = key2;
//	    this.message = key3;
//	}
	

}
