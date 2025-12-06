package game;

public class StoryLoaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		game.story.StoryLoader s = new game.story.StoryLoader("/game/story/textSet0.txt");
        System.out.println("hasNext? " + s.hasNext());
        while (s.hasNext()) {
            System.out.println("> " + s.getNextLine());
        }
	}

}
