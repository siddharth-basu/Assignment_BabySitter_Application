package HelperClasses;

public class FamilyTypes {

    private  String family;

    private static final int BEFORE_TIME_TYPE_A = 11;  //Time Interval
    private static final int TYPE_A_15_RATE = 15; //Rates
    private static final int TYPE_A_20_RATE = 20;//^

    private static final int BEFORE_TIME_TYPE_B = 10; //Time Interval
    private static final int BEFORE_TIME_TYPE_B_MIDNIGHT = 12; //Time Interval
    private static final int TYPE_B_12_RATE = 12; //Rates
    private static final int TYPE_B_8_RATE = 8; //^
    private static final int TYPE_B_16_RATE = 16; //^

    private static final int BEFORE_TIME_TYPE_C = 9; //Time Interval
    private static final int TYPE_C_21_RATE = 21; //Rates
    private static final int TYPE_C_15_RATE = 15; //^

    public FamilyTypes() { // Begin Constructor.
        this.family = null;
    } //Family Type Constructor

    public String getFamily() {
        return family;
    }

    /*Type A family conditionals:
     * $15/hour before 11PM
     * $20/hour after 11PM
     */
    public static Integer TypeAComputation(String beginHour, String beginMinute, String endHour, String endMinute)
    {
        int typeATotalEarned; //Result int of total money earned

        //Parse in the time entries vars of user
        int resultBeginHour = Integer.parseInt(beginHour);
        int resultBeginMinute = Integer.parseInt(beginMinute);
        int resultEndHour = Integer.parseInt(endHour);
        int resultEndMinute = Integer.parseInt(endMinute);

        //Conditionals
        int earnedPrior11PM;
        int earnedPrior4AM;

        if (resultBeginHour < BEFORE_TIME_TYPE_A && resultBeginMinute >= 0 && resultEndMinute > 0)
        {
            earnedPrior11PM = (BEFORE_TIME_TYPE_A - resultBeginHour) * TYPE_A_15_RATE;
            earnedPrior4AM = ((resultEndHour + 1) - BEFORE_TIME_TYPE_A) * TYPE_A_20_RATE;
            typeATotalEarned = earnedPrior11PM + earnedPrior4AM;
            return typeATotalEarned;
        }

        else if (resultBeginHour < BEFORE_TIME_TYPE_A && resultBeginMinute >= 0 && resultEndMinute == 0)
        {
            earnedPrior11PM = (BEFORE_TIME_TYPE_A - resultBeginHour) * TYPE_A_15_RATE;
            earnedPrior4AM = (resultEndHour - BEFORE_TIME_TYPE_A) * TYPE_A_20_RATE;
            typeATotalEarned = earnedPrior11PM + earnedPrior4AM;
            return typeATotalEarned;
        }

        else if (resultBeginHour >= BEFORE_TIME_TYPE_A && resultBeginMinute >= 0 && resultEndMinute >= 0)
        {
            earnedPrior4AM = ((resultEndHour + 1) - resultBeginHour) * TYPE_A_20_RATE;

            typeATotalEarned = earnedPrior4AM;
            return typeATotalEarned;
        }

        else if (resultBeginHour >= BEFORE_TIME_TYPE_A && resultBeginMinute >= 0 && resultEndMinute == 0)
        {
            earnedPrior4AM = (resultEndHour - resultBeginHour) * TYPE_A_20_RATE;
            typeATotalEarned = earnedPrior4AM;
            return typeATotalEarned;
        }

        else return 0;
    }

    /*Type B family conditionals:
     * $12/hour before 10PM
     * $8/hour between 10PM-12AM
     * $16/hour rest of night
     */
    public static Integer TypeBComputation(String beginHour, String beginMinute, String endHour, String endMinute)
    {
        int typeBTotalEarned; //Result int of total money earned

        //Parse in the time entries vars of user
        int resultBeginHour = Integer.parseInt(beginHour);
        int resultBeginMinute = Integer.parseInt(beginMinute);
        int resultEndHour = Integer.parseInt(endHour);
        int resultEndMinute = Integer.parseInt(endMinute);

        //Conditionals
        int earnedPrior10PM;
        int earnedPriorMidnight;
        int earnedPrior4AM;

        if (resultBeginHour < BEFORE_TIME_TYPE_B && resultBeginMinute >= 0 && resultEndMinute > 0)
        {
            earnedPrior10PM = (BEFORE_TIME_TYPE_B - resultBeginHour) * TYPE_B_12_RATE;
            if (BEFORE_TIME_TYPE_B_MIDNIGHT > resultEndHour)
            {
                earnedPriorMidnight = ((BEFORE_TIME_TYPE_B_MIDNIGHT - resultEndHour) + 1) * TYPE_B_8_RATE;
                typeBTotalEarned = earnedPrior10PM + earnedPriorMidnight;
            }

            else {
                    earnedPriorMidnight = TYPE_B_16_RATE;
                    earnedPrior4AM = ((resultEndHour + 1) - BEFORE_TIME_TYPE_B_MIDNIGHT) * TYPE_B_16_RATE;
                typeBTotalEarned = earnedPrior10PM + earnedPriorMidnight + earnedPrior4AM;
            }
            return typeBTotalEarned;
        }

        else if (resultBeginHour < BEFORE_TIME_TYPE_B && resultBeginMinute >= 0 && resultEndMinute == 0)
        {
                earnedPrior10PM = (BEFORE_TIME_TYPE_B - resultBeginHour) * TYPE_B_12_RATE;
            if (BEFORE_TIME_TYPE_B_MIDNIGHT > resultEndHour)
            {
                    earnedPriorMidnight = (BEFORE_TIME_TYPE_B_MIDNIGHT - resultEndHour) * TYPE_B_8_RATE;
                typeBTotalEarned = earnedPrior10PM + earnedPriorMidnight;
            }

            else {
                    earnedPriorMidnight = TYPE_B_16_RATE;
                    earnedPrior4AM = (resultEndHour - BEFORE_TIME_TYPE_B_MIDNIGHT) * TYPE_B_16_RATE;
                typeBTotalEarned = earnedPrior10PM + earnedPriorMidnight + earnedPrior4AM;
            }
            return typeBTotalEarned;
        }

        else if (resultBeginHour >= BEFORE_TIME_TYPE_B && resultBeginHour < BEFORE_TIME_TYPE_B_MIDNIGHT && resultBeginMinute >= 0 && resultEndMinute > 0)
        {
            if(BEFORE_TIME_TYPE_B_MIDNIGHT > resultBeginHour && BEFORE_TIME_TYPE_B_MIDNIGHT > resultEndHour)
            {
                    earnedPriorMidnight = ((BEFORE_TIME_TYPE_B_MIDNIGHT - resultEndHour) + 1) * TYPE_B_8_RATE;
                typeBTotalEarned = earnedPriorMidnight;
            }

            else {
                    earnedPriorMidnight = (BEFORE_TIME_TYPE_B_MIDNIGHT - resultBeginHour) * TYPE_B_8_RATE;
                    earnedPrior4AM = ((resultEndHour - BEFORE_TIME_TYPE_B_MIDNIGHT) + 1) * TYPE_B_16_RATE;
                typeBTotalEarned = earnedPriorMidnight + earnedPrior4AM;
            }
            return typeBTotalEarned;
        }

        else if (resultBeginHour >= BEFORE_TIME_TYPE_B && resultBeginHour < BEFORE_TIME_TYPE_B_MIDNIGHT && resultBeginMinute >= 0 && resultEndMinute == 0)
        {

            if (BEFORE_TIME_TYPE_B_MIDNIGHT > resultBeginHour && BEFORE_TIME_TYPE_B_MIDNIGHT > resultEndHour)
            {
                    earnedPriorMidnight = (BEFORE_TIME_TYPE_B_MIDNIGHT - resultEndHour) * TYPE_B_8_RATE;
                typeBTotalEarned = earnedPriorMidnight;
            }

            else {
                    earnedPriorMidnight = (BEFORE_TIME_TYPE_B_MIDNIGHT - resultBeginHour) * TYPE_B_8_RATE;
                    earnedPrior4AM = (resultEndHour - BEFORE_TIME_TYPE_B_MIDNIGHT) * TYPE_B_16_RATE;
                typeBTotalEarned = earnedPriorMidnight + earnedPrior4AM;
            }
            return typeBTotalEarned;
        }

        else if (resultBeginHour >= BEFORE_TIME_TYPE_B_MIDNIGHT && resultBeginMinute >= 0 && resultEndMinute > 0)
        {
                earnedPrior4AM = ((resultEndHour - BEFORE_TIME_TYPE_B_MIDNIGHT) + 1) * TYPE_B_16_RATE;
            typeBTotalEarned = earnedPrior4AM;
            return typeBTotalEarned;
        }

        else if (resultBeginHour >= BEFORE_TIME_TYPE_B_MIDNIGHT && resultBeginMinute >= 0 && resultEndMinute == 0)
        {
                earnedPrior4AM = (resultEndHour - BEFORE_TIME_TYPE_B_MIDNIGHT) * TYPE_B_16_RATE;
            typeBTotalEarned = earnedPrior4AM;
            return typeBTotalEarned;
        }

        else return 0;
    }

    /*Type C family conditionals:
     * $21/hour before 9PM
     * $15/hour rest of the night
     */
    public static Integer TypeCComputation(String beginHour, String beginMinute, String endHour, String endMinute)
    {
        int typeCTotalEarned; //Result int of total money earned

        //Parse in the time entries vars of user
        int resultBeginHour = Integer.parseInt(beginHour);
        int resultBeginMinute = Integer.parseInt(beginMinute);
        int resultEndHour = Integer.parseInt(endHour);
        int resultEndMinute = Integer.parseInt(endMinute);

        int earnedPrior9PM;
        int earnedPrior4AM;


        if (resultBeginHour < BEFORE_TIME_TYPE_C && resultBeginMinute >= 0 && resultEndMinute > 0)
        {
            earnedPrior9PM = (BEFORE_TIME_TYPE_C - resultBeginHour) * TYPE_C_21_RATE;
            earnedPrior4AM = ((resultEndHour + 1) - BEFORE_TIME_TYPE_C) * TYPE_C_15_RATE;
            typeCTotalEarned = earnedPrior9PM + earnedPrior4AM;
            return typeCTotalEarned;
        }

        else if (resultBeginHour < BEFORE_TIME_TYPE_C && resultBeginMinute >= 0 && resultEndMinute == 0)
        {
            earnedPrior9PM = (BEFORE_TIME_TYPE_C - resultBeginHour) * TYPE_C_21_RATE;
            earnedPrior4AM = (resultEndHour - BEFORE_TIME_TYPE_C) * TYPE_C_15_RATE;
            typeCTotalEarned = earnedPrior9PM + earnedPrior4AM;
            return typeCTotalEarned;
        }

        else if (resultBeginHour >= BEFORE_TIME_TYPE_C && resultBeginMinute >= 0 && resultEndMinute > 0)
        {
            earnedPrior4AM = ((resultEndHour + 1) - resultBeginHour) * TYPE_C_15_RATE;
            typeCTotalEarned = earnedPrior4AM;
            return typeCTotalEarned;
        }

        else if (resultBeginHour >= BEFORE_TIME_TYPE_C && resultBeginMinute >= 0 && resultEndMinute == 0)
        {
            earnedPrior4AM = (resultEndHour - resultBeginHour) * TYPE_C_15_RATE;
            typeCTotalEarned = earnedPrior4AM;
            return typeCTotalEarned;
        }

        else return 0;

    }
}
