package HelperClasses;

public class SitterScheduleTime {

    private String name; //Name of the sitter

    // Starting and Ending Ante Meridiem and Post Meridiem Intervals (AM/PM)
    private static final int BEGINPM = 0;
    private static final int BEGINAM =  12;

    private static final int ENDPM  = 0;
    private static final int ENDAM =  12;

    public static String SitterStartingHour(Integer beginMeridiem, Integer beginHour)
    {
        if(beginMeridiem == 0 && beginMeridiem >= 0 && beginHour <= 11)
        {
            if((BEGINPM + beginHour) < 5)
                return "Incorrect Entry. Try Again.";

            else
           {
                beginHour += BEGINPM;
                return beginHour.toString();
            }
        }

        else if (beginMeridiem == 1 && beginHour >= 0 && beginHour <= 11)
        {
            if((BEGINAM + beginHour) > 16)
                return "Incorrect Entry. Try Again." ;

            else
           {
                beginHour += BEGINAM;
                return beginHour.toString();
            }
        }
        else return "Incorrect Entry. Try Again.";

    }

    public static String SitterStartingMinute(Integer beginMin)
    {
        if(beginMin >= 0 && beginMin < 60)
        {
            String beginMinute = String.format("%02d", beginMin);
            return beginMinute.toString();
        }
        else return "Incorrect Entry. Try Again.";
    }

    public static String SitterEndingHour(Integer endMeridiem, Integer endHour)
    {
        if(endMeridiem == 0 && endHour >= 0 && endHour <= 11)
        {
            if((ENDPM + endHour) < 5)
                return "Incorrect Entry. Error. Try again.";

            else
           {
                endHour += ENDPM;
                return endHour.toString();
            }
        }

        else if(endMeridiem == 1 && endHour >= 0 && endHour <= 11)
        {
            if((ENDAM + endHour) > 16)
                return "Incorrect Entry. Error. Try again.";

            else
           {
                endHour += ENDAM;
                return endHour.toString();
            }
        }
        else return "Incorrect Entry. Error. Try again." ;
    }

    public static String SitterEndingMinute(Integer endMinute) {
        if(endMinute >= 0 && endMinute < 60)
        {
            String endMin = String.format("%02d", endMinute);
            return endMin.toString();
        }
        else return "Incorrect Entry. Try Again." ;
    }

    public static String SitterTotalMinutesSitting(String beginHR, String beginMin, String endingHour, String endingMinute)
    {
        int beginHour = Integer.parseInt(beginHR);
        int beginMinute = Integer.parseInt(beginMin);
        int endHour = Integer.parseInt(endingHour);
        int endMin = Integer.parseInt(endingMinute);

        Integer totalBeginMinutes = (beginHour * 60) + beginMinute;
        Integer totalEndMinutes = (endHour * 60) + endMin;
        Integer totalMinutes = totalEndMinutes - totalBeginMinutes;

        if(totalEndMinutes <= totalBeginMinutes)
            return "Incorrect Entry Error. Try again." ;

        else if (totalMinutes < 60)
            return "Incorrect Entry Error. Try again.";

        else return totalMinutes.toString();

    }
}

