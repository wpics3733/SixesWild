package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

import model.Achievement;

/**
 * Controller to save and load achievements so that they will be saved between sessions
 * @author justin
 *
 */
public class AchievementFileController {
	
	public static void saveFile() {
		File f;
		FileOutputStream saveFile;
		ObjectOutputStream save;
		try{// Catch errors in I/O if necessary.
			// Open a file to write to, named SavedObj.sav.
			
			f = new File("achievements.sav");
			if(!f.exists()){
				f.createNewFile();
			}
			
			//saveFile=new FileOutputStream(levelName.concat(".sav"));
			saveFile=new FileOutputStream(f);
			
			// Create an ObjectOutputStream to put objects into save file.
			save = new ObjectOutputStream(saveFile);
			
			// Now we do the save.
			//save.writeObject(this);
			
			Set<Achievement> list = Achievement.getList();
			Set<Achievement> secretList = Achievement.getSecretList();
			
			save.writeObject(list);
			save.writeObject(secretList);
			
			// Close the file.
			save.close(); // This also closes saveFile.
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public static void loadFile() {
		File f;
		FileInputStream saveFile;
		ObjectInputStream save;
		try{
			
			f = new File("achievements.sav");
			
			
			// Open file to read from, named SavedObj.sav.
			saveFile = new FileInputStream(f);
			
			// Create an ObjectInputStream to get objects from save file.
			save = new ObjectInputStream(saveFile);

			// Now we do the restore.
			// readObject() returns a generic Object, we cast those back
			// into their original class type.
			// For primitive types, use the corresponding reference class.
			//LevelState tmp = (LevelState) save.readObject();
			
			Set<Achievement> list = (Set<Achievement>) save.readObject();
			Set<Achievement> secretList = (Set<Achievement>) save.readObject();
			
			
			// go through the save and if an achievement has been unlocked,
			// then we set it as unlocked in the current program
			for(Achievement a: list) {
				if(a.isUnlocked()) {
					Achievement.setUnlocked(a.ID);
				}
			}
			
			for(Achievement a: secretList) {
				if(a.isUnlocked()) {
					Achievement.setUnlocked(a.ID);
				}
			}

			// Close the file.
			save.close(); // This also closes saveFile.
		}
		catch(Exception exc){
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

}
