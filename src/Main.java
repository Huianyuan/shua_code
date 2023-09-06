import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String taskList = scanner.nextLine();

        String[] taskParts=taskList.split(",");
        int minBattery=0;
        int minInitialBattery=0;

        for(String task:taskParts){
            String[] taskInfo=task.split(":");
            int powerRequired=Integer.parseInt(taskInfo[0]);
            int initialBattery=Integer.parseInt(taskInfo[1]);

            minBattery+=initialBattery-powerRequired;
            if(minBattery<0){
                minInitialBattery+=Math.abs(minBattery);
                minBattery=0;
            }
        }

    }
}