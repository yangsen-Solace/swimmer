package DronePublisher;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DroneTrack {
	 public String AeroscopeID;
	
	 public String ListenerID;
	 
	 public String RemarkInfo;
	
	 public String Soc;

	 public double Latitude;

	 public double Longitude;

	 public int RunTime;

	 public long Timestamp;

	 public int Version;

	 public int StatusCode;
	 
	 public DroneTrack(Track trk) {
		 this.AeroscopeID = trk.aeroscopeID;
		 this.ListenerID = trk.listenerID;
		 this.RemarkInfo = trk.remarkInfo;
		 this.Soc = trk.soc;
		 this.Latitude = trk.latitude;
		 this.Longitude = trk.longitude;
		 this.RunTime = trk.runTime;
		 this.Timestamp = trk.timestamp;
		 this.Version = trk.version;
		 this.StatusCode = trk.statusCode;
	 }
	 
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
