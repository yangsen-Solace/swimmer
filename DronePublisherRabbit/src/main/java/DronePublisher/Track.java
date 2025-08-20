package DronePublisher;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Track {
	 @JsonProperty("aeroscopeID")
	 public String aeroscopeID;
	
	 @JsonProperty("listenerID")
	 public String listenerID;
	 @JsonProperty("remarkInfo")
	 public String remarkInfo;
	 @JsonProperty("soc")
	 public String soc;
	 @JsonProperty("latitude")
	 public double latitude;
	 @JsonProperty("longitude")
	 public double longitude;
	 @JsonProperty("runTime")
	 public int runTime;
	 @JsonProperty("timestamp")
	 public long timestamp;
	 @JsonProperty("version")
	 public int version;
	 @JsonProperty("statusCode")
	 public int statusCode;
	 
	 public String toString() {
		 ObjectMapper mapper = new ObjectMapper();
	     try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	 }
}
