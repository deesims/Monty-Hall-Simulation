import javax.swing.JOptionPane;
import java.util.Random;

public class MontyHall {

	Door[] list = new Door[]{};
	Random rand_number = new Random();
	/** 
     * Initializes the list of doors.
     * 
     * @param numberOfDoors number of door used in the simulation
     */
 	public MontyHall(int numberOfDoors){

 		list = new Door[numberOfDoors];
 		for(int x=0; x < list.length; x++){
 			list[x] = new Door("A");
 		}

	}
	
	/** 
     * Runs a series of Monty Hall games and displays the resulting statistics in a 
     * message dialog or on the standard output  
     * 
     * @param numberOfGames the number of games to simulate
     * @param commandLine if true, sends the results as CSV to standard output, else uses a message dialog
     */
 	public void runGames(int numberOfGames, boolean commandLine){
 	
 		Statistics stats = new Statistics(list.length);
 		int h;

 		for(h=0; h < numberOfGames; h++){
 			oneGame();
 			stats.updateStatistics(list);
 		}
		

		if(commandLine) {
			System.out.println(stats.toCSV());
		}
		else {
			JOptionPane.showMessageDialog (null,stats.toString(), "Results", JOptionPane.INFORMATION_MESSAGE);
		}
	}

 	public void oneGame(){

 		for(int a=0; a < list.length ; a++){
 			list[a].reset();
 		}

 		int prizeNum = rand_number.nextInt(list.length);
 		Door prizeDoor = list[prizeNum];
 		prizeDoor.setPrize();
 		Door selectedDoor = pickADoor();
 		openOtherDoors(prizeDoor,selectedDoor,prizeNum);
		
	}

	/** 
     * Simulates a random selection of one of the  doors.
     * @return the door randomly selected  
     */
 	private Door pickADoor(){
		int playerNum = rand_number.nextInt(list.length);
		list[playerNum].choose();
		return list[playerNum];
	}
	
 	private void openOtherDoors(Door prizeDoor, Door selectedDoor, int prizeNum){
 			int d = list.length - 2;
 			Door[] otherDoors = new Door[d];

 			while( d > 0 ){

 				int hostNum = rand_number.nextInt(list.length);
 				
 				while (list[hostNum].isChosen() | hostNum == prizeNum | list[hostNum].isOpen()){
 					hostNum = rand_number.nextInt(list.length);
 				}


 				list[hostNum].open();
 				d = d - 1;
 			}



	}
	
	public static void main(String[] args) {

		MontyHall montyHall;
		int numberOfGames;
		int numberOfDoors;
		boolean commandLine = false;
		
		AuthorInfo.display();

		if (args.length == 2) {
			numberOfGames = Integer.parseInt(args[0]);
			numberOfDoors = Integer.parseInt(args[1]);
			commandLine = true;
		} else {
			numberOfGames = Integer.parseInt(JOptionPane.showInputDialog("Input the number of games to play", "1000"));
			numberOfDoors = Integer.parseInt(JOptionPane.showInputDialog("Input the number of doors", "3"));
		}

		
		montyHall = new MontyHall(numberOfDoors);		
		montyHall.runGames(numberOfGames, commandLine);
	}

}
