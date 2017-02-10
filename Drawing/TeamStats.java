import java.util.*;
import java.io.*;
import java.awt.*;
public class TeamStats{
   public static void main(String[] args) throws FileNotFoundException {
      boolean repeat = true;
      while (repeat == true){
      Scanner console = new Scanner(System.in);
      Scanner input = new Scanner(new File("TeamStats.txt"));
      input.nextLine();
      System.out.println("TEAM 2557 SCOUTING INFORMATION SYSTEM --Big sis");
      System.out.print("");
      System.out.print("1 - Team Lookup 2 - Alliance Logic: ");
      switch(console.nextInt()){
         case 1:
            System.out.print("Enter a team number: ");
            int searchId = console.nextInt();
            repeat = lookup(console,searchId,input);
            break;
         case 2: 
            repeat = logic(input, console);
            break;
      }}
}

public static boolean lookup(Scanner console,int searchId,Scanner input) throws FileNotFoundException {

String line = findTeam(input, searchId);

if (line.length() > 0) {

processLine(line);

} else {

System.out.println("No data was found for Team #" + searchId);

}
System.out.print("Restart? true/false: ");
return console.nextBoolean();
}

public static boolean logic(Scanner input,Scanner console){
   System.out.println("");
   System.out.println("Adventure Club Mates:");
   System.out.print("Team 1:");
   Scanner gone = new Scanner(findTeam(input,console.nextInt()));
   System.out.print("Team 2:");
   Scanner gtwo = new Scanner(findTeam(input,console.nextInt()));
   System.out.print("Team 3:");
   Scanner gthree = new Scanner(findTeam(input,console.nextInt()));
   System.out.println("");
   System.out.println("Adventure Club Adversaries:");
   System.out.print("Team 1:");
   Scanner bone = new Scanner(findTeam(input,console.nextInt()));
   System.out.print("Team 2:");
   Scanner btwo = new Scanner(findTeam(input,console.nextInt()));
   System.out.print("Team 3:");
   Scanner bthree = new Scanner(findTeam(input,console.nextInt()));
   System.out.println("");
   Double[][] main = new Double[7][14];
   for(int i = 0; i<=13; i ++){
      main[0][i] = gone.nextDouble();
      main[1][i] = gtwo.nextDouble();
      main[2][i] = gthree.nextDouble();
      main[3][i] = bone.nextDouble();
      main[4][i] = btwo.nextDouble();
      main[5][i] = bthree.nextDouble();
   }
   mathybit(console,main);
   System.out.print("Restart? true/false: ");
   return console.nextBoolean();
}
// Locates and returns the line of data about a particular team.

public static String findTeam(Scanner input, int searchId) {
while (input.hasNextLine()) {
String line = input.nextLine();

Scanner lineScan = new Scanner(line).useDelimiter("\t");

int id = lineScan.nextInt();

if (id == searchId) {

return line; // we found them!

}

}

return ""; 

}

public static void processLine(String line) {

Scanner lineScan = new Scanner(line);

String id = lineScan.next();

double gear = lineScan.nextDouble();

double floor =lineScan.nextDouble();

double gtpc = lineScan.nextDouble();

double score = lineScan.nextDouble();

double intake = lineScan.nextDouble();

double target = lineScan.nextDouble();

double stpc = lineScan.nextDouble();

double move = lineScan.nextDouble();

double power = lineScan.nextDouble();

double hoppersize = lineScan.nextDouble();

double climb = lineScan.nextDouble();

int speed1 = lineScan.nextInt();

int speed2 = lineScan.nextInt();

System.out.println("");
System.out.println("Stats for FRC team: " + id);
System.out.println("");
System.out.println("---Gears---");
System.out.println("Ability:   " + gear + "%");
System.out.println("Floor fed: " + floor + "%");
System.out.println("Time:      " + gtpc + " SPC\n");
System.out.println("---Fuel---");
System.out.println("Ability:     " + score + "%");
System.out.println("Floor fed:   " + intake + "%");
System.out.println("Target:      " + target + "%");
System.out.println("Hopper Size: " + hoppersize + " Fuel");
System.out.println("Time:      " + stpc + " SPC\n");
System.out.println("---Drive-Train---");
System.out.println("Maneuverability: " + move + "%");
System.out.println("Power:           " + power + "%\n");
System.out.println("Climb Status: " + climb);
System.out.println("Robot Speed one: " + speed1 + "fps Robot Speed two: " + speed2 + "fps");
radarGraph(id,gear,score,move,power,hoppersize,climb);
}
   public static void radarGraph(String id, double gear,double score,double move, double power, double hoppersize, double climb){
      //Input for Graph
      gear = gear/100;
      move = move/100;
      power = power/100;
      score = score/100;
      hoppersize = (hoppersize*2)/100;
      climb = climb/100;
      Double a1 = new Double(100-75*gear);
      Double a2 = new Double(100-35*move);
      Double a3 = new Double(100+35*power);
      Double a4 = new Double(100+75*score);
      Double a5 = new Double(100+35*hoppersize);
      Double a6 = new Double(100-35*climb);
      int b1 = 100;
      Double b2 = new Double(100-65*move);
      Double b3 = new Double(100-65*power);
      int b4 = 100;
      Double b5 = new Double(100+65*hoppersize);
      Double b6 = new Double(100+65*climb);
      
      DrawingPanel panel = new DrawingPanel(200,250);
      Graphics g = panel.getGraphics();
      g.setColor(Color.YELLOW);
      
      int[] ax1 = {a1.intValue(),a2.intValue(),100};
      int[] ay1 = {b1,b2.intValue(),100};
      g.fillPolygon(ax1,ay1,3);
      
      int[] ax2 = {a2.intValue(),a3.intValue(),100};
      int[] ay2 = {b2.intValue(),b3.intValue(),100};
      g.fillPolygon(ax2,ay2,3);
      
      int[] ax3 = {a3.intValue(),a4.intValue(),100};
      int[] ay3 = {b3.intValue(),b4,100};
      g.fillPolygon(ax3,ay3,3);
      
      int[] ax4 = {a4.intValue(),a5.intValue(),100};
      int[] ay4 = {b4,b5.intValue(),100};
      g.fillPolygon(ax4,ay4,3);
      
      int[] ax5 = {a5.intValue(),a6.intValue(),100};
      int[] ay5 = {b5.intValue(),b6.intValue(),100};
      g.fillPolygon(ax5,ay5,3);
      
      int[] ax6 = {a6.intValue(),a1.intValue(),100};
      int[] ay6 = {b6.intValue(),b1,100};
      g.fillPolygon(ax6,ay6,3);
      //Graph Input Ends
      //Creates radar graph setup
      g.setColor(Color.BLACK);
      g.drawLine(25,100,175,100); //25,100 center left/right
      g.drawLine(135,35,100,100);
      g.drawLine(100-35,35,100,100);
      g.drawLine(100-35, 200-35, 100,100);
      g.drawLine(135, 200-35, 100,100);
      g.drawLine(25,100,65,35); //Cord 1
      g.drawString("Gears",0,90);
      g.drawLine(65,35,135,35); //Cord 2
      g.drawString("Speed",40,30);
      g.drawLine(135,35,175,100); //Cord 3
      g.drawString("Power",120,30);
      g.drawLine(175,100,135,165); //Cord 4
      g.drawString("Fuel",170,90);
      g.drawLine(135,165,65,165); //Cord 5
      g.drawString("Storage",120,180);
      g.drawLine(65,165,25,100); //Cord 6
      g.drawString("Climb",40,180);
      g.drawString(id,80,200);
   }
   public static void mathybit(Scanner c,Double main[][]){
   for(int i = 0; 1<main[0].length; i++){
      String id = new String(main[i][0].toString()); 
      radarGraph(id,main[i][1],main[i][4],main[i][8],main[i][9],main[i][10],main[i][11]);
   }
//    int gears1 = 0; //Number of allies able to do gears
//    int gearsc1 = 0; //Adverage consistancy
//    int gears2 = 0;
//    int gearsc2 = 0;
//    int shoot1 = 0; //Number of bots shooting
//    int shootc1 = 0; //Adverage consistancy
//    int shoot2 = 0;
//    int shootc2 = 0;
//    int climb1 = 0;
//    int climb2 = 0;
//    int gr1 = 0; //adv speed per gear run
//    int sr1 = 0; //adv speed per shoot run
//    int gr2 = 0;
//    int sr2 = 0;
   }
}