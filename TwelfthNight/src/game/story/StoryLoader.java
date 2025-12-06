package game.story;

import java.io.*;
import java.util.*;

public class StoryLoader {
	private List<String> lines;
	private int index=0;
	
	public StoryLoader(String filename) {
		lines = new ArrayList<>();
		load(filename);
	}

	public void reset() {
		index=0;
	}
	private void load(String fileName) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream(fileName), "UTF-8"))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	public String getNextLine() {
		if(index<lines.size()) {
			return lines.get(index++);
		}
		return null;
	}
	public boolean hasNext() {
		return index < lines.size();
	}

}
