package game;

import java.awt.event.ActionListener;

import game.story.StoryLoader;
import image.Illyria;

public class SetEnd_2 {

	private GameManager gm;
	private Illyria frame;
	
	public SetEnd_2(GameManager gm, Illyria frame) {
		this.gm=gm;
		this.frame=frame;
	}
	
	public void start() {
		frame.setRightImage("/image/sebastian.jpg");
		
		for(ActionListener al : frame.btnStory.getActionListeners()) {
		    frame.btnStory.removeActionListener(al);
		}
		StoryLoader story = new StoryLoader("/game/story/textSetEnd2.txt");
		
		frame.btnStory.addActionListener(e ->{
			if(story.hasNext()) {
				String line = story.getNextLine();
				frame.appendStory(line+"\n");
				return;
			}
			
			javax.swing.JOptionPane.showMessageDialog(frame, 
					"축하합니다!\n Viola와 Sebastian은 재회했습니다",
					"The End",
					javax.swing.JOptionPane.INFORMATION_MESSAGE
					);
			
		});
	}
}
