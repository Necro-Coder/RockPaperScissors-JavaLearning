package advancedGame.Weapons.classicWeapons;

import advancedGame.Weapons.Weapon;
import org.jetbrains.annotations.NotNull;

public class Rock extends Weapon{
    private static final Weapon COUNTER = new Scissors();
    private static final Weapon COUNTERED_BY = new Paper();
    public Rock() {
        super(1, "Rock");
    }

    @Override
    public int compareTo(@NotNull Weapon other) {
        if (other.equals(COUNTER)) {
            return 1;
        } else if (other.equals(COUNTERED_BY)) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Rock{" +
                "index=" + getIndex() +
                ", name='" + getName() + '\'' +
                ", countered by" + COUNTERED_BY +
                ", counters" + COUNTER +
                '}';
    }
}
