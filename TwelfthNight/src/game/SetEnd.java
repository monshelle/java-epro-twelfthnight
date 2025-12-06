package game;

import java.awt.event.ActionListener;

import game.story.StoryLoader;
import image.Illyria;

public class SetEnd {
	private GameManager gm;
	private Illyria frame;
	
	public SetEnd(GameManager gm, Illyria frame) {
		this.gm=gm;
		this.frame=frame;
	}
	
	public void start() {
		frame.setLeftImage("/image/viola.jpg");
		frame.setRightImage("/image/Antonio.jpg");
		
		for(ActionListener al : frame.btnStory.getActionListeners()) {
		    frame.btnStory.removeActionListener(al);
		}
		StoryLoader story = new StoryLoader("/game/story/textSetEnd1.txt");
		
		frame.btnStory.addActionListener(e ->{
			if(story.hasNext()) {
				String line = story.getNextLine();
				frame.appendStory(line+"\n");
				return;
			}
			
		});
	}


}
