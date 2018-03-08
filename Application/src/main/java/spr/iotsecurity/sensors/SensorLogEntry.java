package spr.iotsecurity.sensors;

/**
 * Created by jianan on 3/7/18.
 */

public class SensorLogEntry {
    private long id;
    private String name;
    private String value;
    private long timestamp;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SensorLogEntry(Sensor sensor, String value, long timestamp) {
        this.id = sensor.getId();
        this.name = sensor.getName();
        this.value = value;
        this.timestamp = timestamp;
    }
    public String toString(){
        return String.valueOf(id) + " " + name + " " + value + " " + String.valueOf(timestamp);
    }
}
