package image;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import game.GameManager;
import player.Player;

public class Illyria extends JFrame{
	
	private GameManager gm;
	private Player[] players;
	
	private JPanel contentPane;
	
	//Left Player
	 public JLabel label1;
	 private JButton btn1;
	 public JProgressBar bar1;
	 
	 //Right Player
	 private JLabel label2;
	 private JButton btn2;
	 private JProgressBar bar2;
	 
	 //게임 시작 버튼
	 public JButton btnStart;
	 
	 // Story Panel(bottom)
	 private JScrollPane storyScroll;
	 private JTextArea storyArea;

	 //스토리 진행 버튼(필드로 선언)
	 public JButton btnStory;
	    
	 // Next Button
	 private JButton btnNext;
	 
	 private JLabel bg;
	 private int currentBgIndex = 0;
	 
	 public Player p1;
	 public Player p2;
	 public Player p3;
	 public Player p4;
	 
	 
	 private void newPlayer(Player newP, JLabel targetLabel, JProgressBar targetBar) {

		    // 라벨에 캐릭터 이미지 세팅
		    Image img = new ImageIcon(getClass().getResource(newP.getImgPath())).getImage();
		    Image img2 = img.getScaledInstance(targetLabel.getWidth(), targetLabel.getHeight(), Image.SCALE_SMOOTH);
		    targetLabel.setIcon(new ImageIcon(img2));

		    // HP Bar 초기화
		    targetBar.setMaximum(100);
		    targetBar.setValue(newP.getHp());
		}
	 
	 public void appendStory(String text) {
		 storyArea.append(text);
		 storyArea.setCaretPosition(storyArea.getDocument().getLength());
	 }
	 
	 public void setLeftImage(String imgPath) {
		    if (imgPath == null) {
		        label1.setIcon(null);
		        return;
		    }
		    
		    Image img = new ImageIcon(getClass().getResource(imgPath)).getImage();
		    Image img2 = img.getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_SMOOTH);
		    label1.setIcon(new ImageIcon(img2));
		}

	 
	 public void setRightImage(String imgPath) {
		 if(imgPath == null) {
			 label2.setIcon(null);
			 return;
		 }
		 Image img = new ImageIcon(getClass().getResource(imgPath)).getImage();
		 Image img2 = img.getScaledInstance(label2.getWidth(), label2.getHeight(), Image.SCALE_SMOOTH);
		 label2.setIcon(new ImageIcon(img2));

	 }
 

	
	public Illyria(GameManager gm, Player...players ) {
		this.gm=gm;
		this.players=players;
		
		if(players.length>=4) {
			this.p1=players[0];
			this.p2=players[1];
			this.p3=players[2];
			this.p4=players[3];
		}
		initUI();
	}
	public void setGameManager(GameManager gm) {
		this.gm=gm;
	}
	
	private void initUI() {
		
		//전체 레이블 세팅
		setTitle("우당탕탕 오빠 찾아 삼만리 ~ Illyrian Edition ~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 1149, 765);
	    
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    //bg image 목록
	    String[] bgImages = {"bgSet0.jpg", "bgSet1.jpg", "bgSet2.jpg", "bgSet2_2.jpg","bgSet3.jpg", "bgSet3.jpg", "bgSetEnd.jpg"};
	    
	    //배경 사진 세팅
	    bg = new JLabel();
	    bg.setBounds(0, 0, 1149, 765);
	    bg.setIcon(new ImageIcon(new ImageIcon(Illyria.class.getResource(bgImages[currentBgIndex]))
	                .getImage().getScaledInstance(bg.getSize().width, bg.getSize().height, Image.SCALE_SMOOTH)));
	        contentPane.add(bg);
	    
	        
	    //left player1 사진 세팅하기
		label1=new JLabel("");
		label1.setBounds(80, 202, 270, 360);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		
		Image img=new ImageIcon(this.getClass().getResource("/image/viola.jpg")).getImage();
		Image img2= img.getScaledInstance(label1.getSize().width, label1.getSize().height, Image.SCALE_SMOOTH);
		ImageIcon icon1=new ImageIcon(img2);
		label1.setIcon(icon1);
		contentPane.add(label1);
		     
		     
		 //right player2 사진 세팅하기
		 label2=new JLabel("");
		 label2.setBounds(799, 202, 270, 360);
		 label2.setHorizontalAlignment(SwingConstants.CENTER);
		 label2.setIcon(null);
		 contentPane.add(label2);
		 
		 //game start button
		 btnStart = new JButton("게임 시작");
		 btnStart.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 storyArea.append("==========================================\n");
				 storyArea.append("     ~ 오빠 찾아 삼만리 ~\n");
				 storyArea.append("	당신은 일리리아에 도착했습니다.\n");
				 storyArea.append("	오빠 세바스찬을 찾아야 합니다\n");
				 storyArea.append("	...그럼 여행을 시작해봅시다.\n");
				 storyArea.append("==========================================\n");
			 }
		 });
		 btnStart.setBounds(359, 556, 140, 45);
		 contentPane.add(btnStart);
		 
		 //스토리 진행 버튼
		 btnStory = new JButton("스토리 진행");
		 btnStory.setBounds(505, 556, 140, 45);
		 contentPane.add(btnStory);
		 
		 //set 진행 버튼
		 btnNext = new JButton("다음 세트");
		 btnNext.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 currentBgIndex = (currentBgIndex+1)%bgImages.length;
				 bg.setIcon(new ImageIcon(new ImageIcon(Illyria.class.getResource(bgImages[currentBgIndex]))
			                .getImage().getScaledInstance(bg.getSize().width, bg.getSize().height, Image.SCALE_SMOOTH)));
			 bg.repaint();
			 if (Illyria.this.gm != null) {
		            Illyria.this.gm.goToSet(currentBgIndex + 1);
		        }
			 }
		 });
		 btnNext.setBounds(651, 556, 140, 45);
		 contentPane.add(btnNext);
		 
		 //left(viola) -> right 공격 버튼 세팅
		 btn1 = new JButton("공격하기");
		 btn1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 p1.attack(p2);
				 bar2.setValue(p2.getHp());
				 storyArea.append(p1.name + "이 " + p2.name + "을 공격합니다.\n");
				 
				 if(p1.getHp()<50) {
					 p1=p3;
					 storyArea.append("      플레이어가 교체되었습니다!\n");
					 
					//초상화 교체
					 newPlayer(p1, label1, bar1);
				 }
				 if(p1.getHp()<=0) {
					 storyArea.append(p1.name + "은 패배했습니다.\n");
					 btn1.setEnabled(false);
					 btn2.setEnabled(false);
				 }
				 
				 if(p2.getHp()<50) {
					 p2=p4;
					 storyArea.append("      플레이어가 교체되었습니다!\n");
					 
					//초상화 교체
					newPlayer(p2, label2, bar2);
				 }
				 if(p2.getHp()<=0) {
					 storyArea.append(p2.name + "은 패배했습니다.\n");
					 btn1.setEnabled(false);
					 btn2.setEnabled(false);
				 }
				 
			 }
		 });
		 btn1.setBounds(130, 580, 170, 40);
	     contentPane.add(btn1);
	     
	     //right -> left(viola) 공격 버튼 세팅
	     btn2 = new JButton("공격하기");
	     btn2.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 p2.attack(p1);
				 bar1.setValue(p1.getHp());
				 storyArea.append(p2.name + "이 " + p1.name + "을 공격합니다.\n");
				 
				 if(p1.getHp()<50) {
					 p1=p3;
					 
					 storyArea.append("	플레이어가 교체되었습니다!\n");
					 
					//초상화 교체
					 newPlayer(p1, label1, bar1);
				 }
				 if(p1.getHp()<=0) {
					 storyArea.append(p1.name + "은 패배했습니다.\n");
					 
					 btn1.setEnabled(false);
					 btn2.setEnabled(false);
				 }
				 
				 if(p2.getHp()<50) {
					 p2=p4;
					 storyArea.append("      플레이어가 교체되었습니다!\n");
					 
					//초상화 교체
					newPlayer(p2, label2, bar2);
				 }
				 if(p2.getHp()<=0) {
					 storyArea.append(p2.name + "은 패배했습니다.\n");
					 btn1.setEnabled(false);
					 btn2.setEnabled(false);
				 }
				 
			 }
		 });
	     btn2.setBounds(849, 580, 170, 40);
	     contentPane.add(btn2);
	     
	     bar1 = new JProgressBar();
	     bar1.setMaximum(100);
	     bar1.setValue(p1.getHp());
	     bar1.setForeground(Color.RED);
	     bar1.setBounds(80, 630, 270, 20);
	     contentPane.add(bar1);

	     bar2 = new JProgressBar();
	     bar2.setMaximum(100);
	     bar2.setValue(p2.getHp());
	     bar2.setForeground(Color.RED);
	     bar2.setBounds(799, 630, 270, 20);
	     contentPane.add(bar2);
	     
	     
	        // Story Panel (bottom)
	        
	        storyScroll = new JScrollPane();
	        storyScroll.setBounds(359, 212, 432, 324);
	        contentPane.add(storyScroll);

	        storyArea = new JTextArea();
	        storyArea.setEditable(false);
	        storyArea.setLineWrap(true);
	        storyArea.setWrapStyleWord(true);
	        storyScroll.setViewportView(storyArea);

	        contentPane.setComponentZOrder(bg, contentPane.getComponentCount() - 1);

	    
	}
	

}
