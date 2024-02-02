package advancedGame.Weapons.classicWeapons;

import advancedGame.Weapons.Weapon;
import org.jetbrains.annotations.NotNull;

public class Scissors extends Weapon {
    private static final Weapon COUNTER = new Paper();
    private static final Weapon COUNTERED_BY = new Rock();

    public Scissors() {
        super(3, "Scissors");
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
        return "Scissors{" +
                "index=" + getIndex() +
                ", name='" + getName() + '\'' +
                ", countered by" + COUNTERED_BY +
                ", counters" + COUNTER +
                '}';
    }
}
