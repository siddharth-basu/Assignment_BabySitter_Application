import HelperClasses.FamilyTypes;
import HelperClasses.SitterScheduleTime;

import java.util.Scanner;


public class MainApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Babysitter Application");

        Scanner in = new Scanner(System.in); //User Input through Scanner
        String nameOfSitter = null;
        int HRBegin = 0;
        int MinBegin = 0;
        int HREnded = 0;
        int MinEnded = 0;
        int MeridiemBegin = 0;
        int MeridiemEnd = 0;
        String beginHR = null;
        String beginMinute = null;
        String endingHR = null;
        String endingMin = null;

        int totalPay = 0;
        String family = null;
        String familyUpperCase = null;
        String totalMinutes = null;
        int totalHours = 0;


        System.out.println("Powered By Accenture Kata Assignment\n");
        System.out.println("Instructions: Enter your name. Enter starting hour, minute and AM/PM. Enter ending hour, minute and AM/PM\n");
        System.out.println("You will given (3) family types to choose from (A, B, C) which will let us calculate your earnings.");
        System.out.println("*----------------------------------------------------------------------------------------------------------*\n");

        System.out.print("What is your name? ");
        nameOfSitter = in.nextLine();
        System.out.println("");

        do {
            //What is the starting hour for the sitter?
            do {
                System.out.print("What hour did you start babysitting? ");
                HRBegin = in.nextInt();
                System.out.println("");
                System.out.print("Was it PM or AM (Enter '0' for PM and '1' for AM)? ");
                MeridiemBegin = in.nextInt();
                System.out.println("");
                beginHR = SitterScheduleTime.SitterStartingHour(MeridiemBegin, HRBegin);
                System.out.println("Starting Hour is " + beginHR);

            } while (beginHR == "Incorrect Entry. Try Again.");

            //What  is the starting minute for the sitter?
            do {
                System.out.print("What minute did you start babysitting? ");
                MinBegin = in.nextInt();
                System.out.println("");
                beginMinute = SitterScheduleTime.SitterStartingMinute(MinBegin);
                System.out.println("Starting minute is " + beginMinute);
                System.out.println("");
            } while (beginMinute == "an Error.  Try again.");

            //What hour did you stop babysitting?
            do {
                System.out.print("What hour did you end babysitting? ");
                HREnded = in.nextInt();
                System.out.println("");
                System.out.print("Was it PM or AM (Enter '0' for PM and '1' for AM)? ");
                MeridiemEnd = in.nextInt();
                System.out.println("");
                endingHR = SitterScheduleTime.SitterEndingHour(MeridiemEnd, HREnded);
                System.out.println("Ending Hour is " + endingHR);
                System.out.println("");
            } while (endingHR == "Incorrect Entry. Error. Try again.");

            //What minute did you stop babysitting?
            do {
                System.out.print("What minute did you end babysitting? ");
                MinEnded = in.nextInt();
                System.out.println("");
                endingMin = SitterScheduleTime.SitterEndingMinute(MinEnded);
                System.out.println("Ending minute is " + endingMin);
                System.out.println("");
            } while (endingMin == "Incorrect Entry. Try Again.");

            //Calculate the total amount of minutes worked and then give options to user for what type of family they worked for
            totalMinutes = SitterScheduleTime.SitterTotalMinutesSitting(beginHR, beginMinute, endingHR,
                    endingMin);
            System.out.println("The Total Minutes are " + totalMinutes);
            System.out.println("");
        } while (totalMinutes == "Incorrect Entry Error. Try again.");

        System.out.println("Which family type did you babysit for?  Please enter 'A' for Type A,");
        System.out.println("'B' for the Type B or 'C' for the Type C: ");
        in.nextLine();

        //Enter A, B, or C  to get a calculated output of your earnings from sitting
        while (true) {
            family = in.nextLine();
            familyUpperCase = family.toUpperCase();
            switch (familyUpperCase) {
                case "A":
                    totalPay = FamilyTypes.TypeAComputation(beginHR, beginMinute, endingHR, endingMin);
                    totalHours = Integer.parseInt(totalMinutes)/60;
                    System.out.print(nameOfSitter + ", you have worked for " + totalMinutes + " minutes OR "+ totalHours + " full hours of pay and earned $");
                    System.out.print(+totalPay + " babysitting for Family Type A.");
                    System.out.println("");
                    break;
                case "B":
                    totalPay = FamilyTypes.TypeBComputation(beginHR, beginMinute, endingHR, endingMin);
                    totalHours = Integer.parseInt(totalMinutes)/60;
                    System.out.print(nameOfSitter + ", you have worked for " + totalMinutes + " minutes OR " + totalHours +"  full hours of pay and earned $");
                    System.out.print(+totalPay + " babysitting for Family Type B.");
                    System.out.println("");
                    break;
                case "C":
                    totalPay = FamilyTypes.TypeCComputation(beginHR, beginMinute, endingHR, endingMin);
                    totalHours = Integer.parseInt(totalMinutes)/60;
                    System.out.print(nameOfSitter + ", you have worked for " + totalMinutes + " minutes OR " + totalHours +" full hours of pay and earned $");
                    System.out.print(+totalPay + " babysitting for Family Type C.");
                    System.out.println("");
                    break;
                default:
                    System.out.print(
                            "Please enter 'A' for Type A, 'B' for the Type B or 'C' for Type C: \n");
            }
        }

    }


}
