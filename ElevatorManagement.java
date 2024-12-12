import java.util.Scanner;

public class ElevatorManagement {
     private Scanner input = new Scanner(System.in);
     private int Maintanence[] = new int[5];
    {
        System.out.println("Enter the Lift number of the Lift Under Maintanence");
        int liftNumber = input.nextInt();
        Maintanence[liftNumber-1] = -1;
    }
    
    public void initialize(int[] lifts) {
        String[] liftNames = {"L1", "L2", "L3", "L4", "L5"};
        int capacity[] = assignCapacity(liftNames.length);
        displayLiftPositions(lifts, liftNames,capacity);
        int[] point = userInput();
        int assignedLift = assignLift(lifts, point[0], point[1]);
        if (assignedLift != -1) {
            System.out.println("L" + (assignedLift + 1) + " is assigned");
            lifts[assignedLift] = point[1];
            displayLiftPositions(lifts, liftNames,capacity);
        } 
        else {
            System.out.println("No lift available for the requested destination.");
        }
    }
    
    private int[] assignCapacity(int length){
       int capacity[] = new int[length];
       System.out.println("Enter the capacities for the list");
       int liftNumber = 1;
       for(int i=0;i<length;i++){
          System.out.println("Enter the Capacity of L" + liftNumber++);
          capacity[i] = input.nextInt();
       }
       return capacity;
    } 
    

    
    
    public  void displayLiftPositions(int[] lifts, String[] liftNames,int capacity[]) {
        System.out.print("Lift: ");
        for (String lift : liftNames) 
            System.out.print(lift + " ");
        System.out.println();

        System.out.print("Floor: ");
        for (int floor : lifts) 
            System.out.print(floor + " ");
        System.out.println();
        
        System.out.print("Capacity:");
        for(int liftCapacity : capacity)
           System.out.print(liftCapacity + " ");
        System.out.println();
    }

    private int[] userInput() {
        int source = -1;
        int destination = -1;
        while (true) {
           System.out.print("Enter the source floor: ");
           if (input.hasNextInt()) {
               source = input.nextInt();
                if (source >= 0 && source <= 10) {
                   break;  
                } 
                else {
                   System.out.println("Lifts Available on 0 to 10 only:!!");
               }
          } 
          else {
            System.out.println("Invalid input. Please enter an integer.");
            input.next();  
          }
      }

    
      while (true) {
        System.out.print("Enter the destination floor: ");
        if (input.hasNextInt()) {
            destination = input.nextInt();
            if (destination >= 0 && destination <= 10) {
                break;  
            } 
            else {
                System.out.println("Lifts Available on 0 to 10 only:!!");
            }
        } 
        else {
            System.out.println("Invalid input. Please enter an integer.");
            input.next();  
        }
    }

     return new int[]{source, destination};
  }


   public int assignLift(int[] lifts, int source, int destination) {
      int assignedLift = -1;
      int minDistance = Integer.MAX_VALUE;

      boolean isMovingUp = destination > source;

      for (int i = 0; i < lifts.length; i++) {
        if (isLiftAccessible(i, destination) && !isMaintanence(i)) {  
            int distance = Math.abs(lifts[i] - source);
            boolean isLiftMovingUp = lifts[i] < source;

            if (distance < minDistance) {
                minDistance = distance;
                assignedLift = i;
            } 
            else if (distance == minDistance) {
                if (((isMovingUp && lifts[i] < source) || (!isMovingUp && lifts[i] > source))) {
                    assignedLift = i;
                }
            }
        }
     }

      return assignedLift;
  }


    private  boolean isLiftAccessible(int liftIndex, int floor) {
        if (liftIndex == 0 || liftIndex == 1) 
            return floor >= 0 && floor <= 5;
        else if (liftIndex == 2 || liftIndex == 3) 
            return floor >= 0 && floor <= 10 && floor >= 6;
        else 
            return floor >= 0 && floor <= 10;
    }
    
    private boolean isMaintanence(int liftNumber){
        return Maintanence[liftNumber] ==-1;
    }

 /*   public static void main(String[] args) {
        int[] lifts = {0, 0, 0, 0, 0}; 
        ElevatorManagement manager = new ElevatorManagement();
        manager.initialize(lifts);
    }*/
}

