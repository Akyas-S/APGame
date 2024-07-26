package utils;

public class Constants {

    // sets amount of animation frames for a certain animation in the sprite sheet for the player
    public static class PlayerConstants{

        // sets the Y value of the animation in the sprite sheet
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int ATTACK = 2;

        // returns the total amount of frames depending on the animation state
        public static int GetSpriteAmt(int player_action){
            switch (player_action){
                case IDLE:
                    return 8;

                case RUNNING:
                    return 8;

                case ATTACK:
                    return 5;
            }
            return player_action;
        }
    }

// sets the amount of animation frames for a certain animation in the sprite sheet for the enemy
    public static class EnemyConstants{
        public static final int PIRATE = 0;

        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int ATTACK = 2;
        public static final int DEAD = 4;
        public static final int HIT = 3;

        // returns the total amount of frames on the sprite sheet depending on the enemy type and state
        public static int GetEnemySpriteAmt(int enemyType,int enemyState){
            switch (enemyType) {
                case PIRATE:
                    switch (enemyState) {
                        case IDLE:
                            return 9;
                        case RUNNING:
                            return 6;
                        case ATTACK:
                            return 7;
                        case HIT:
                            return 4;
                        case DEAD:
                            return 5;
                    }
            }
            return 0;
        }
    }
}
