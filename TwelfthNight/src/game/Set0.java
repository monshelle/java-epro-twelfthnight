package game;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import game.story.StoryLoader;
import image.Illyria;
import player.Player;

public class Set0 {
	private GameManager gm;
	private Illyria frame;
	private Player viola;
	
	public Set0(GameManager gm, Illyria frame) {
		this.gm=gm;
		this.frame=frame;
		this.viola = frame.p1;
	}
	

	StoryLoader story;
	public void start() {
		frame.setRightImage(null);
		
		for(ActionListener al : frame.btnStory.getActionListeners()) {
		    frame.btnStory.removeActionListener(al);
		}
		
		story = new StoryLoader("/game/story/textSet0.txt");
		
		frame.btnStory.setEnabled(true);
		
		frame.btnStory.addActionListener(e ->{
			SwingUtilities.invokeLater(()->{
				if(story.hasNext()) {
					String line = story.getNextLine();
					frame.appendStory(line+"\n");
					
				}
			});
		});
		
	}
}
