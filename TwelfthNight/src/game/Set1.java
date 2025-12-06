package game;

import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import game.story.StoryLoader;
import image.Illyria;
import player.Player;

public class Set1 {
	private GameManager gm;
	private Illyria frame;
	private Player viola;
	
	public Set1(GameManager gm, Illyria frame) {
		this.gm=gm;
		this.frame=frame;
		this.viola = frame.p1;
	}
	
	StoryLoader story;
	public void start() {
		frame.setRightImage("/image/orsino.jpg");
		
		for(ActionListener al : frame.btnStory.getActionListeners()) {
		    frame.btnStory.removeActionListener(al);
		}
		story = new StoryLoader("/game/story/textSet1.txt");
		frame.btnStory.addActionListener(e ->{
			if(story.hasNext()) {
				String line = story.getNextLine();
				frame.appendStory(line+"\n");
				return;
			}
			
				int r = frame.p1.getRandom(0,100);
				
				//hp 증가
				frame.p1.setHp(frame.p1.getHp()+r);
				if(frame.p1.getHp()>100)frame.p1.setHp(100);
				
				//화면 hp bar 갱신
				SwingUtilities.invokeLater(() -> {
				    frame.bar1.setValue(frame.p1.getHp());
				});

				
				frame.appendStory("\n");
				frame.appendStory("현재 Hp: "+frame.p1.getHp()+"\n");
				
				if(frame.p1.getHp()<50) {
					frame.appendStory("(이런! Orsino의 호감을 얻지 못했습니다.\n");
					frame.appendStory("(다시 연주해봅시다.)\n");
				}
				else {
					frame.appendStory("\n");
					frame.appendStory("Orsino: \n");
					frame.appendStory("unfold the passion of my love to Olivia\n");
					frame.appendStory("(다음 세트로 넘어가세요)\n");
					frame.appendStory("\n");
					gm.goToSet(2);
				}
			
		});
	}
}
