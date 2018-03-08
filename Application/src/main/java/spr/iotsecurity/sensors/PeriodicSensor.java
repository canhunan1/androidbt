package spr.iotsecurity.sensors;

import android.content.Context;

import java.util.Calendar;

/**
 * Created by jianan on 3/7/18.
 */

public class PeriodicSensor extends Sensor {

    private float period_in_ms;
    private int num_log;

    public PeriodicSensor(float period_in_ms,  int num_log, long id, String name) {
        super(id, name);
    }

    @Override
    public void generateSensorLog(Context context) {
        long timebase = Calendar.getInstance().getTimeInMillis();
        for(int i = 0; i < num_log; i++){
            SensorLogEntry se = new SensorLogEntry(this, /*should be discussed*/String.valueOf(1), (long)(timebase + i * period_in_ms));
            saveLogEntry(se, context);
        }
    }
}
