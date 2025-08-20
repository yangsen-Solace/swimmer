package DronePublisher;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageData {
	 @JsonProperty("totalCount")
	 public int totalCount;
	 
	 @JsonProperty("list")
	 public List<Track> list;
}
