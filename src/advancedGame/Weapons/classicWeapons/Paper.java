package advancedGame.Weapons.classicWeapons;

import advancedGame.Weapons.Weapon;
import advancedGame.Weapons.advancedWeapons.Lizard;
import advancedGame.Weapons.advancedWeapons.Spock;
import org.jetbrains.annotations.NotNull;

public class Paper extends Weapon {
    private static final Weapon[] COUNTER = {new Rock(), new Spock()};
    private static final Weapon[] COUNTERED_BY = {new Scissors(), new Lizard()};

    public Paper() {
        super(2, "Paper");
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
        return "Paper{" +
                "index=" + getIndex() +
                ", name='" + getName() + '\'' +
                ", countered by" + COUNTERED_BY +
                ", counters" + COUNTER +
                '}';
    }
}
