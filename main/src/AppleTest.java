import java.util.List;

public class AppleTest {
    public int process(int amount, int speed, int day){
        int appleLeft = amount;
        int appleFallen = 0;
       // appleFallen = speed * appleFallenPreviousDay;
       for(int i = 1; i <= day; i++){
        if(day == 1)  {
            appleLeft = appleLeft - 1;
        } else {
            if( i == 1){
                appleLeft = appleLeft - 1;
                appleFallen= 1;
            } else {
                appleFallen = speed * appleFallen;
                if(appleFallen > appleLeft){
                    System.out.println("No more apple on the tree for the day " + (i + 1));
                    return 0;
                }
                appleLeft = appleLeft - appleFallen;
            }
        }
       }
       return appleLeft;
    }

}
