package data;

// Importing the necessary classes
import entity.Player;
import gamestates.Audio;

import java.io.*;

// Public class SaveLoad
public class SaveLoad {

    // Reference to the Player object
    Player player;
    // Reference to the dataStorage object
    dataStorage ds;
    Audio audio;
    // File object to store the save data
    File file;

    // Constructor for the SaveLoad class
    public SaveLoad(Player player){
        // Initialize the player reference
        this.player = player;
        // Load the player's coins
        loadCoins();
        // Load the player's high score
        loadHighScore();
        // Create a new File object with the name "save.dat"
        this.file = new File("save.dat");
        // Check if the file exists
        if(!file.exists()){
            try {
                // Create the file if it doesn't exist
                file.createNewFile();
            } catch (IOException e) {
                // Print an error message if the file cannot be created
                System.out.println("Cannot create file");;
            }
        }
    }

    // Method to save the player's coins
    public void saveCoins(){
        try{
            // Update the dataStorage object with the player's current coins
            ds.playerCoins = player.playerTotalCoins;
            // Create an ObjectOutputStream to write the dataStorage object to the file
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            // Write the dataStorage object to the file
            os.writeObject(ds);
        }catch (Exception e){
            // Print an error message if an exception occurs during saving
            System.out.println("Save Coin Error");
        }
    }

    // Method to save the player's high score
    public void saveHighScore(){
        try{
            // Update the dataStorage object with the player's current high score
            ds.playerHighScore = player.playerHighScore;
            // Create an ObjectOutputStream to write the dataStorage object to the file
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
            // Write the dataStorage object to the file
            os.writeObject(ds);
        }catch (Exception e){
            // Print an error message if an exception occurs during saving
            System.out.println("Save HighScore Error");
        }
    }

    // Method to load the player's high score
    public int loadHighScore(){
        try{
            // Create an ObjectInputStream to read the dataStorage object from the file
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
            // Read the dataStorage object from the file
            ds = (dataStorage) ois.readObject();
            // Update the player's high score with the loaded value
            player.playerHighScore = ds.playerHighScore;
            // Print the loaded high score
            System.out.println(player.playerHighScore);
            // Return the loaded high score
            return ds.playerHighScore;
        }catch (Exception e){
            // Print an error message if an exception occurs during loading
            System.out.println("Load HighScore Error");
        }
        // Return 0 if an error occurs during loading
        return 0;
    }
    // Method to load the player's coins
    public int loadCoins(){
        try{
            // Create an ObjectInputStream to read the dataStorage object from the file
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
            // Read the dataStorage object from the file
            ds = (dataStorage) ois.readObject();
            // Update the player's coins with the loaded value
            player.playerTotalCoins = ds.playerCoins;
            // Return the loaded coins
            return ds.playerCoins;
        }catch (Exception e){
            // Print an error message if an exception occurs during loading
            System.out.println("Load Coins Error");
        }
        // Return 0 if an error occurs during loading
        return 0;
    }
    public void saveSFXAndMusicSettings(){
        try{
            ds.isSFXMuted =!Audio.getAudio().isSFXEnabled; // save SFX mute state
            ds.isMusicMuted =!Audio.getAudio().isMusicEnabled; // save music mute state
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(ds);
        }catch (Exception e){
            System.out.println("Save SFX and Music Settings Error");
        }
    }

    public void loadSFXAndMusicSettings(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
            ds = (dataStorage) ois.readObject();
            Audio.getAudio().isSFXEnabled =!ds.isSFXMuted; // load SFX mute state
            Audio.getAudio().isMusicEnabled =!ds.isMusicMuted; // load music mute state
        }catch (Exception e){
            System.out.println("Load SFX and Music Settings Error");
        }
    }
}
}