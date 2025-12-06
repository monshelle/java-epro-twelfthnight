package game;

import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JOptionPane;

import game.story.StoryLoader;
import image.Illyria;
import player.Player;

public class Set2_2 {
	private GameManager gm;
	private Illyria frame;
	private Player viola;
	
	public Set2_2(GameManager gm, Illyria frame) {
		this.gm=gm;
		this.frame=frame;
		this.viola=frame.p1;
	}
	
	public void start() {
		frame.setRightImage("/image/malvolio.jpg");
		for(ActionListener al : frame.btnStory.getActionListeners()) {
		    frame.btnStory.removeActionListener(al);
		}
		StoryLoader story = new StoryLoader("/game/story/textSet2_2.txt");
		frame.btnStory.addActionListener(e ->{
			if(story.hasNext()) {
				String line = story.getNextLine();
				frame.appendStory(line+"\n");
				return;
			}
			String[] options = { "끝내준다!", "음... 난 별로..." };
			
			int choice = JOptionPane.showOptionDialog(
	                frame,                           // 부모 컴포넌트
	                "Malvolio의 말에 대한 당신의 반응은?",  // 메시지
	                "선택해주세요",                       // 타이틀
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.QUESTION_MESSAGE,
	                null, options, options[0]
	        );
			
			if (choice == 0) {
				frame.appendStory("\n");
	            frame.appendStory("보는 눈이 있군.\n");
	        }
			else if (choice == 1) {
				frame.appendStory("\n");
	            frame.appendStory("자네 두고 봐...\n");
	            int r = frame.p1.getRandom(0, 100);
	            
	            // HP 감소
	            frame.p1.setHp(frame.p1.getHp() - r);
	            if (frame.p1.getHp() > 100) viola.setHp(100);
	            
	            // HP bar 갱신
	            frame.bar1.setValue(frame.p1.getHp());
	            
	            frame.appendStory("\n");
				frame.appendStory("현재 Hp: "+frame.p1.getHp()+"\n");
				
	        }     
	            
		});

	}

}