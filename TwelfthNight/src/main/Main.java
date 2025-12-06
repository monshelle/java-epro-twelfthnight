package main;

import game.GameManager;
import image.Illyria;
import player.*;

public class Main {

	public static void main(String[] args) {
		Player p1 = new Viola("Viola", 0, 10, "/image/viola.jpg");
        Player p2 = new Andrew("Andrew", 100, 10, "/image/andrew.jpg");
        Player p3 = new Antonio("Antonio", 100, 20, "/image/Antonio.jpg");
        Player p4 = new Toby("Toby", 100, 10, "/image/toby.jpg");

        Illyria frame = new Illyria(null, p1, p2, p3, p4);
        GameManager gm = new GameManager(frame, p1,p2,p3,p4);

        frame.setGameManager(gm);

        // 4) 실행
        frame.setVisible(true);
        gm.start();

	}

}
