public class Elevator{
     public static void main(String[]args){
        ElevatorManagement elevatorManagement = new ElevatorManagement();
        int lift1 = Integer.parseInt(args[0]);
        int lift2 = Integer.parseInt(args[1]);
        int lift3 = Integer.parseInt(args[2]);
        int lift4 = Integer.parseInt(args[3]);
        int lift5 = Integer.parseInt(args[4]);
        int lift[] = {lift1,lift2,lift3,lift4,lift5};
        elevatorManagement.initialize(lift);
     }
       
}
 /* 1
  private int assignLift(int[] lifts, int source) {
        int assignedLift = -1;
        int minDistance = Integer.MAX_VALUE;

       
        for (int i = 0; i < lifts.length; i++) {
            int distance = Math.abs(lifts[i] - source);  
            if (distance < minDistance) {
                minDistance = distance;
                assignedLift = i; 
            }
        }

        return assignedLift;
    }*/



/*
   4
    public static int assignLift(int[] lifts, int source, int destination) {
        int assignedLift = -1;
        int minDistance = Integer.MAX_VALUE;
        boolean isMovingUp = destination > source; 
        for (int i = 0; i < lifts.length; i++) {
            int distance = Math.abs(lifts[i] - source);  
            boolean isLiftMovingUp = lifts[i] < source;
            if (distance < minDistance) {
                minDistance = distance;
                assignedLift = i;
            } 
            else if (distance == minDistance) {
                if ((isMovingUp && lifts[i] < source) || (!isMovingUp && lifts[i] > source)) {
                    assignedLift = i;
                }
            }
        }

        return assignedLift;
    }

*/
