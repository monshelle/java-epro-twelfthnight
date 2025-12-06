package game;

import java.awt.event.ActionListener;

import game.story.StoryLoader;
import image.Illyria;

public class Set3 {
	private GameManager gm;
	private Illyria frame;
	
	public Set3(GameManager gm, Illyria frame) {
		this.gm=gm;
		this.frame=frame;
	}
	
	public void start() {
		frame.setRightImage("/image/andrew.jpg");
		
		for(ActionListener al : frame.btnStory.getActionListeners()) {
		    frame.btnStory.removeActionListener(al);
		}
		StoryLoader story = new StoryLoader("/game/story/textSet3.txt");
		
		frame.btnStory.addActionListener(e ->{
			if(story.hasNext()) {
				String line = story.getNextLine();
				frame.appendStory(line+"\n");
				return;
			}
			
		});
	}

}
