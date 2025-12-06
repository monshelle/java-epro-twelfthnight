package player;

public class Viola extends Player{
	
	public Viola(String name, int hp, int power, String imgPath) {
		super(name, hp, power, imgPath);
	}
	
	@Override
	public void attack(Player target) {
		if(target instanceof Andrew) {
			super.attack(target);
			return;
		}
		
	}

}
