

public class Statistics {

	int games_played;
	int switching_strategy_worked;
	int switching_strategy_failed;
	int[] doors_prize = new int[]{};
	int[] doors_selected = new int[]{};
	int[] doors_opened = new int[]{};

	/** 
     * Initializes the statistics.
     * 
     * @param numberOfDoors the number of doors used
     */
 	public  Statistics(int numberOfDoors){
		doors_prize = new int[numberOfDoors];
		doors_selected = new int[numberOfDoors];
		doors_opened = new int[numberOfDoors];
	}
	
	/** 
     * Updates statistics after one game.
     *   @param doorArry the list of Doors used during the game
     */
	public void updateStatistics(Door[] doorArray){
		games_played ++;
		int a;
		int y;

		for(y=0; y < doorArray.length; y++){
			if (doorArray[y].hasPrize()){
				doors_prize[y] ++;
			} 

			if (doorArray[y].isChosen()){
				doors_selected[y] ++;
			}

			if (doorArray[y].isOpen()){
				doors_opened[y] ++;
			}
		}


		boolean flag = false;
		for (a=0; a < doorArray.length; a++){
			if (doorArray[a].hasPrize() && doorArray[a].isChosen()){
				switching_strategy_failed ++;
				flag = true;
			} 
		}
		if (flag == false){
			switching_strategy_worked++;
		}




	}
	


	/** 
     *  @return Returns the complete statistics information
     */
	public String toString(){

		String selected="";
		String winning="";
		String opened="";
		for(int z=0; z < doors_selected.length ; z++){
			selected = selected +  "	door" + z + ": " + doors_selected[z] + "\n"; 
		}

		for (int q=0; q < doors_prize.length ; q++){
			winning = winning + "	door" + q + ": " + doors_prize[q] + "\n";
		}

		for(int l=0; l < doors_opened.length; l++){
			opened = opened + " 	door" + l + ": " + doors_opened[l] + "\n";
		}


		return "Number of games played:" + games_played + "\n" + 
		"Staying strategy won: " + switching_strategy_failed + "( " + ((double) switching_strategy_failed / (double) games_played) * 100 + " % )" + "\n" +
		"Switching strategy won: " + switching_strategy_worked + "( " + ((double) switching_strategy_worked / (double) games_played) * 100 + " % )" + "\n" + 
		"Selected doors:" + "\n" + selected + "Winning doors:" + "\n" + winning + "Open doors:" + "\n" + opened;

	}
	
	/** 
     *  @return Returns the complete statistics information in CSV format
     */
	public String toCSV(){
		String s = "";

		for(int z=0; z < doors_selected.length ; z++){
			s = s + "Door " + z + "," + doors_selected[z] + "," + doors_prize[z] + "," + doors_opened[z] + "\n";
		}

		return "Numver of games," + games_played + "\n" + 
		"Number of doors," + doors_prize.length + "\n" + 
		",Win,Loss" + "\n" + 
		"Staying strategy,"+switching_strategy_failed+","+switching_strategy_worked+"\n"+
		"Switching strategy,"+switching_strategy_worked+","+switching_strategy_failed+"\n"+
		",Selected doors,Winning doors,Open doors"+"\n"+
		s;

	}

}
