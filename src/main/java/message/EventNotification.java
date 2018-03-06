package message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import sunseries.travel.library.message.GsonUTCDateAdapter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class EventNotification implements Serializable {

    @SerializedName("id")
    private String id;              //unique ex."1234"

    @SerializedName("type")
    private String type;            //ex. "new_log"

    @SerializedName("ttid")
    private String ttid;            //ex. "1234567890"

    @SerializedName("origin")
    private String origin;          //ex. "sunseries_gem"

    @SerializedName("datetime")
    private Date datetime;          //ex. "yyyy-MM-dd'T'HH:mm:ssZ"

    @SerializedName("default_language")
    private String defaultLanguage;

    @SerializedName("default_currency")
    private String defaultCurrency;

    @SerializedName("event_data")
    private Map<String, Object> eventData = new HashMap<>();

    @SerializedName("timezone")
    private Date timezone;

    @SerializedName("processing_time")
    private long processingTime;

    @SerializedName("user_id")
    private String userId;

    public Map<String, Object> getEventData() {
        if (eventData == null) {
            eventData = new HashMap<>();
        }
        return eventData;
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    public String toJSONString() {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new GsonUTCDateAdapter())
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .create();
        String jsonString = gson.toJson(this);
        return jsonString;
    }

}
