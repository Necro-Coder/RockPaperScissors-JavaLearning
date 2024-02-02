package advancedGame.utils;

public enum GameSpeeds {
    SLOW(100),
    NORMAL(50),
    FAST(25),
    ULTRA_FAST(10);

    private final int speed;

    GameSpeeds(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
