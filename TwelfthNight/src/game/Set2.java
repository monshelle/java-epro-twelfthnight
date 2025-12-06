package game;

import java.awt.event.ActionListener;
import java.util.Scanner;

import game.story.StoryLoader;
import image.Illyria;
import player.Player;

public class Set2 {
	private GameManager gm;
	private Illyria frame;
	private Player viola;
	
	public Set2(GameManager gm, Illyria frame) {
		this.gm=gm;
		this.frame=frame;
		this.viola=frame.p1;
	}
	public void start() {
		frame.setRightImage("/image/olivia.jpg");
		for(ActionListener al : frame.btnStory.getActionListeners()) {
		    frame.btnStory.removeActionListener(al);
		}
		StoryLoader story = new StoryLoader("/game/story/textSet2.txt");
		frame.btnStory.addActionListener(e ->{
			if(story.hasNext()) {
				String line = story.getNextLine();
				frame.appendStory(line+"\n");
				return;
			}
		});
	}
}
