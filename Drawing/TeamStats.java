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
   String[][] main = new String[6][14];
   for(int i = 0; i<=13; i ++){
      main[0][i] = gone.next();
      main[1][i] = gtwo.next();
      main[2][i] = gthree.next();
      main[3][i] = bone.next();
      main[4][i] = btwo.next();
      main[5][i] = bthree.next();
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

int id = lineScan.nextInt();

int gear = lineScan.nextInt();

int floor =lineScan.nextInt();

int gtpc = lineScan.nextInt();

int score = lineScan.nextInt();

int intake = lineScan.nextInt();

int target = lineScan.nextInt();

int stpc = lineScan.nextInt();

int move = lineScan.nextInt();

int power = lineScan.nextInt();

int hoppersize = lineScan.nextInt();

int climb = lineScan.nextInt();

int speed1 = lineScan.nextInt();

int speed2 = lineScan.nextInt();
//Creates radar graph setup
DrawingPanel panel = new DrawingPanel(200,200);
Graphics g = panel.getGraphics();
g.drawLine(25,100,175,100); //25,100 center left/right
g.drawLine(135,35,100,100);
g.drawLine(100-35,35,100,100);
g.drawLine(100-35, 200-35, 100,100);
g.drawLine(135, 200-35, 100,100);
g.drawLine(25,100,135,35); //Cord 1
g.drawString("Gears",30,35);
g.drawLine(135,35,65,35); //Cord 2
g.drawString("Cord2",0,90);
g.drawLine(65,35,65,165); //Cord 3
g.drawString("Test",100,100);
g.drawLine(50,150,100,175); //Cord 4
g.drawString("Test",100,100);
g.drawLine(100,175,150,150); //Cord 5
g.drawString("Test",100,100);
g.drawLine(150,150,175,100); //Cord 6
g.drawString("Test",100,100);
//Input for Graph
g.setColor(Color.YELLOW);
int[] f = {50,100,100};
int[] d = {50,25,100};
g.fillPolygon(f,d,3);
//Graph Input Ends
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
}
   public static void mathybit(Scanner c,String main[][]){
   int gears1 = 0; //Number of allies able to do gears
   int gearsc1 = 0; //Adverage consistancy
   int gears2 = 0;
   int gearsc2 = 0;
   int shoot1 = 0; //Number of bots shooting
   int shootc1 = 0; //Adverage consistancy
   int shoot2 = 0;
   int shootc2 = 0;
   int climb1 = 0;
   int climb2 = 0;
   int gr1 = 0; //adv speed per gear run
   int sr1 = 0; //adv speed per shoot run
   int gr2 = 0;
   int sr2 = 0;
   }
}