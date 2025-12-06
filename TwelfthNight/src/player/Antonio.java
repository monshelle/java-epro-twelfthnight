package player;

public class Antonio extends Player{
	public Antonio(String name, int hp, int power, String imgPath) {
		super(name, hp, power, imgPath);
	}
	
	@Override
	public void attack(Player target) {
		if(target instanceof Andrew||target instanceof Toby) {
			super.attack(target);
			return;
		}
		
	}
	
}
