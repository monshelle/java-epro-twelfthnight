package player;

public class Andrew extends Player{
	public Andrew(String name, int hp, int power, String imgPath) {
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
