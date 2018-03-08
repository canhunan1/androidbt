package spr.iotsecurity.sensors;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by jianan on 3/7/18.
 */

public abstract class Sensor {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Sensor(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void generateSensorLog(Context context);

    public void saveLogEntry(SensorLogEntry se, Context context){
        String filename = se.getName() + String.valueOf(se.getId());
        File file = new File(filename);

        OutputStreamWriter outStreamWriter = null;
        FileOutputStream outStream = null;

        file = new File(new File("/sensorlog"), filename);
        try {
            if ( file.exists() == false ){
                file.createNewFile();
            }

            outStream = new FileOutputStream(file, true) ;
            outStreamWriter = new OutputStreamWriter(outStream);

            outStreamWriter.append(se.toString());

            outStreamWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
//    abstract long getTimeStamp();
//
//    abstract String getValue();
}
