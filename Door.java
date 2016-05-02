
public class Door {
	
	boolean opened=false, activated=false, prize=false;
	String name;
	
	/** 
     * Creates an instance of the Door object.
     * Initially, the door is closed, doesn't have a prize behind it 
     * and has not been chosen by the player.
     * 
     * @param name identifier for that door
     */
	public Door(String name){
		this.name = name;
	}

	/** 
     * Resets the door to its initial state: closed, without a prize behind it 
     * and not chosen by the player.
     */
	public void reset(){
		opened = false;
		prize = false;
		activated = false;
	}
	
	/** 
     * Sets this door open.
     */
	public void open(){
		opened = true;
	
	}
	
	/** 
     * Checks if the door is open.
     * @return true if the door is open
     */
	public boolean isOpen(){
		return opened;

	}
	
	/** 
     * Puts the prize behind this door.
     */
	public void setPrize(){
		prize = true;

	}
	
	/** 
     * Checks if the door has the prize.
     * @return true if the door has the prize
     */
	public boolean hasPrize(){
		return prize;
	}
	
	/** 
     * Sets this door as selected by the player.
     */
	public void choose(){
		activated = true;

	}

	/** 
     * Checks if the door is selected by the player.
     * @return true if the door is selected by the player
     */
	public boolean isChosen(){
		return activated;
	}
	
	
	/** 
     * @return the door's identifier
     */
	public String getName(){
		return this.name;
	}
}
