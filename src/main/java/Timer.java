import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Timer {
    String diffHoursResult;
    int diffHours;
    String startDate = "";
    String startTime = "";
    String endDate = "";
    String endTime = "";
    String format = "dd/MM/YY hh:mm";
    DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");

    public Timer(String startTime, String startDate, String endDate, String endTime) {
        Listener times = new Listener();
        this.startTime = times.getStartTime();
        this.startDate = times.getStartDate();
        this.endTime = times.getEndTime();
        this.endDate = times.getEndDate();
    }

    public void timeInCall() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);

            Date startDateObj = sdf.parse(startDate + " " + startTime);
            Date endDateObj = sdf.parse(endDate + " " + endTime );

            long diff = endDateObj.getTime() - startDateObj.getTime();

            diffHours = (int) (diff / (60 * 60 * 1000));

            diffHoursResult = crunchifyFormatter.format(diffHours);


        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public String getDiffHoursResult() {
        return diffHoursResult;
    }
}
