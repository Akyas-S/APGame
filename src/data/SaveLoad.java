package data;

import entity.Player;

import java.io.*;

public class SaveLoad {

    Player player;
    dataStorage ds;
    File file;

    public SaveLoad(Player player){
        this.player = player;
        loadCoins();
        loadHighScore();
        File file = new File("save.dat");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Cannot create file");;
            }
        }
    }

    public void saveCoins(){
        try{
            ds.playerCoins = player.playerTotalCoins;
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(ds);
        }catch (Exception e){
            System.out.println("Save Error");
        }
    }

    public void saveHighScore(){
        try{
            ds.playerHighScore = player.playerHighScore;
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
            os.writeObject(ds);
        }catch (Exception e){
            System.out.println("Save Error");
        }
    }

    public int loadHighScore(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
            ds = (dataStorage) ois.readObject();
            player.playerHighScore = ds.playerHighScore;
            return ds.playerHighScore;
        }catch (Exception e){
            System.out.println("Load HighScore Error");
        }
        return 0;
    }

    public int loadCoins(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
            ds = (dataStorage) ois.readObject();
            player.playerTotalCoins = ds.playerCoins;
            return ds.playerCoins;
        }catch (Exception e){
            System.out.println("Load Coins Error");
        }
        return 0;
    }
}