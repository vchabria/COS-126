public class NoonSnooze {

    public static void main(String[] args) {
        int snooze = Integer.parseInt(args[0]);
        int hours = 0; // store the hour
        int minutes = 0; // store the minutes
        int min = 60; // minutes to hour conversion value
        int am = 12; // pm to am conversion value
       String minute = " ";


         // checking if its more than a day
        if (snooze > 1440)
        {
            snooze = snooze % 1440;
        }


         // minutes to hours conversion in a 24 hour period
         if (snooze < 1440)

         {
              // for single digit minutes
             minutes = snooze % min;
             if (minutes < 10)
                  minute= "0" +  minutes;
             else
                 minute = "" + minutes;



            if ((snooze / min) <=0) {
                System.out.println("12:" + minute + "pm");
            }
            else if ((snooze / min) < am && (snooze / min) > 0) {
                hours = snooze / min;
                System.out.println(hours + ":" + minute + "pm");
            }
            else if ( (snooze/ min) == am)
                System.out.print("12:"+minute+"am");

            else if ((snooze / min) > am ) {
                hours = (snooze / min)-am  ;
                System.out.println(hours + ":" + minute + "am");
            }

        }
    }
}
