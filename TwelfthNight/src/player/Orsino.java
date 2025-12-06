package player;

public class Orsino extends Player{
	public Orsino(String name, int hp, int power, String imgPath) {
		super(name, hp, power, imgPath);
	}
	@Override
	public void updateHp() {
		int increase = getRandom(0,20);//+만 가능
		this.hp += increase;
		System.out.println(increase + "hp 증가");
	}
	

}
