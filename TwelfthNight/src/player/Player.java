package player;

public class Player{
	
	protected int hp;
    private int power;
    public String name;
    private String imgPath;//프로필 이미지 경로
    
    public Player(){}

    public Player(String name, int hp, int power, String imgPath){
    	this.name=name;
    	this.hp=hp;
    	this.power=power;
    	this.imgPath=imgPath;
    }
    
    //hp 랜덤 조정
    public int getRandom(int min, int max) {
    	return(int)(Math.random()*(max-min+1))+min;
    }
    public void updateHp() {
    }
    
    //공격 기능
    public void attack(Player target){
    	System.out.printf("%s------>%s\n", this.name, target.name);
    	target.hp -= this.power;
    }

    public void showHp(Player target){
    	System.out.println(this.name+"의 hp: "+this.hp);
    	System.out.println(target.name+"의 hp: "+target.hp);
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
    	this.hp = Math.max(hp, 0);
    }

    public int getPower(){
        return power;
    }

    public void setPower(int power){
    	this.power=power;
    }
    
    public String getImgPath() {
    	return imgPath;
    }
    
    public void setImgPath(String imgPath) {
    	this.imgPath=imgPath;
    }

}
