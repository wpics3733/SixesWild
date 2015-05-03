package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import model.Achievement;

/**
 * Controller to save and load achievements so that they will be saved between sessions
 * @author justin
 *
 */
public class AchievementFileController {
	
	public static void saveFile() {
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter("achievements.sav"));
			
			Set<Achievement> list = Achievement.getList();
			Set<Achievement> secretList = Achievement.getSecretList();
			
			for (Achievement a: list) {
				if (a.isUnlocked()) { out.write(a.ID + "\n"); }
			}
			for (Achievement a: secretList) {
				if (a.isUnlocked()) { out.write(a.ID + "\n"); }
			}
			
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void loadSave() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("achievements.sav"));
			
			String line = in.readLine();
			// Keep reading lines until we get null
			while(line != null) {
				// Each line that was written is the ID of an unlocked achievement
				Achievement.setUnlocked(Integer.parseInt(line));
				line = in.readLine();
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			// We're not worried about this
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
