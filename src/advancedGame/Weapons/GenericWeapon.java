package advancedGame.Weapons;

import org.jetbrains.annotations.NotNull;

public class GenericWeapon extends Weapon {
    private static Weapon[] counter;
    private static Weapon[] counteredBy;

    public GenericWeapon(int index, String name) {
        super(index, name);
    }

    public void setCounter(Weapon[] counter) {
        GenericWeapon.counter = counter;
    }

    public void setCounteredBy(Weapon[] counteredBy) {
        GenericWeapon.counteredBy = counteredBy;
    }

    @Override
    public int compareTo(@NotNull Weapon other) {
        for(Weapon weapon : counter) {
            if (other.equals(weapon)) {
                return 1;
            }
        }
        for(Weapon weapon : counteredBy) {
            if (other.equals(weapon)) {
                return -1;
            }
        }
        return 0;
    }
}
