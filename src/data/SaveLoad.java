package data;

import entity.Player;
import main.GamePanel;

import java.io.*;

public class SaveLoad {

    Player player;

    public SaveLoad(Player player){
        this.player = player;

    }
    public void save(){
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
            dataStorage ds = new dataStorage();
            ds.playerHighScore = player.playerHighScore;
            os.writeObject(ds);

        }catch (Exception e){
            System.out.println("Save Error");
        }
    }

    public int load(){
        try{

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
            dataStorage ds = (dataStorage) ois.readObject();
            player.playerHighScore = ds.playerHighScore;
            return ds.playerHighScore;
        }catch (Exception e){
            System.out.println("Load Error");
            return 0;
        }
    }
}
