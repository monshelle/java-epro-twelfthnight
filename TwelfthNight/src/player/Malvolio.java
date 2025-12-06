package player;

public class Malvolio extends Player{
	public Malvolio(String name, int hp, int power, String imgPath) {
		super(name, hp, power, imgPath);
	}
	
	@Override
	public void attack(Player target) {
		if(target instanceof Viola) {
			super.attack(target);
			System.out.println("Malvolio: The quality of mercy is not strained.\n");
			return;
		}
		
	}

}
