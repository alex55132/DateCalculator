
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author alex55132
 */
public class DateCalculator {
    
    public Date Date;

    public String Day;
    public String Month;
    public int MonthValue;
    public String NumberDay;
    public String Year;
    public String TimeZone;

    public String Seconds;
    public String Minutes;
    public String Hours;

    public DateCalculator(Date date) {
        
        this.Date = date;

        String DateString = date.toString();

        //System.out.println(DateString);

        String[] DateSplitted = DateString.split(" ");

        for (int i = 0; i < DateSplitted.length; i++) {
            //System.out.println(i + ". " +DateSplitted[i]);
            switch (i) {
                case 0: {
                    this.Day = DateSplitted[0];
                }
                case 1: {
                    this.Month = DateSplitted[1];
                    
                    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    this.MonthValue = localDate.getMonthValue();
                }
                case 2: {
                    this.NumberDay = DateSplitted[2];
                }
                case 3: {
                    String[] hour = DateSplitted[3].split(":");
                    this.Hours = hour[0];
                    this.Minutes = hour[1];
                    this.Seconds = hour[2];
                }
                case 4: {
                    this.TimeZone = DateSplitted[4];
                }
                case 5: {
                    this.Year = DateSplitted[5];
                }
            }
        }
    }
    
    public DateCalculator() {
        /* EMPTY CONSTRUCTOR FOR USE THE CLASS WITH 
         CUSTOM VALUE CALCULATOR (operateCustomDate()) */
    }

    public String getDay() {
        return this.Day;
    }

    public String getMonth() {
        return this.Month;
    }

    public String getDayNumber() {
        return this.NumberDay;
    }

    public int getNumberMonth() {
        return this.MonthValue;
    }

    public String getCompleteHour() {
        String CompleteHour = this.Hours + ":" + this.Minutes + ":" + this.Seconds;

        return CompleteHour;
    }

    public String getCompleteDay() {
        String CompleteDay = this.Year + "-" + this.Month + "-" + this.NumberDay + " " + this.getCompleteHour();

        return CompleteDay;
    }

    public String getHour() {
        return this.Hours;
    }

    public String getMinute() {
        return this.Minutes;
    }

    public String getSeconds() {
        return this.Seconds;
    }

    public String getTimeZone() {
        return this.TimeZone;
    }

    public String getYear() {
        return this.Year;
    }

    /*
    
    operation: 
            0: +
            1: -
    
    Operate with the current Date
    
    NOTE: FOR BIG LONG VALUES IN MILLISECONDS, USE 
    long milliseconds = Long.parseLong(String number value);
     */
    
    public Date operateCustomDate(int operation, Date date, long milliseconds) {
        long CurrentMs = date.getTime();
        
        long FinalDate;
        
        if (operation == 0) {
            FinalDate = CurrentMs + milliseconds;
            
            Date newDate = new Date(FinalDate);
            
            return newDate;
        } else if (operation == 1) {
            FinalDate = CurrentMs - milliseconds;
            
            Date newDate = new Date(FinalDate);
            
            return newDate;
        } 
        return null;
    }
}
