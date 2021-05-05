package Lop_va_Doi_tuong_trong_java.baiTap;

import java.time.LocalDateTime;
import java.util.Date;

public class StopWatch {
    private  long starttime;
    private long endTime;


    public StopWatch() {
        this.starttime= System.currentTimeMillis();
    }

//    public String getStarttime() {
//        return starttime;
//    }

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void stop()  {
        this.endTime= System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return endTime - starttime;
    }

}
