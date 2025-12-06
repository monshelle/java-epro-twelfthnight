package game;

import image.Illyria;
import player.Player;

public class GameManager {
	private Illyria frame;
	private Player[] players;
	private int currentSet = 1;
	
	public GameManager(Illyria frame, Player...players ) {
		this.frame=frame;
		this.players=players;
	}
	
	public Illyria getFrame() {
		return frame;
	}
	
	public Player getPlayer(int index) {
        return players[index];
    }
	
	public void start() {
		goToSet(1);
	}
	

	public void goToSet(int setNum) {
		currentSet = setNum;
		
		switch(setNum) {
		case 1 :
			new Set0(this, frame).start();
			break;
		case 2:
			new Set1(this,frame).start();
			break;
		case 3:
			new Set2(this,frame).start();
			break;
		case 4:
			new Set2_2(this,frame).start();
			break;
		case 5:
			new Set3(this,frame).start();
			break;
		case 6:
			new SetEnd(this,frame).start();
			break;
		case 7:
			new SetEnd_2(this,frame).start();
			break;
		}
	}
}
