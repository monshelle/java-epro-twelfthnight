package player;

public class Toby extends Player{
	public Toby(String name, int hp, int power, String imgPath) {
		super(name, hp, power, imgPath);
	}
	
	@Override
	public void attack(Player target) {
		if(target instanceof Viola) {
			super.attack(target);
			return;
		}
		
	}

}
