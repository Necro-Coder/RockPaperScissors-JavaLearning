package advancedGame.Weapons;

import org.jetbrains.annotations.NotNull;

public class Weapon implements Comparable<Weapon> {
    private final int index;
    private final String name;

    public Weapon(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Weapon{" +
                "index=" + index +
                ", name='" + name + '\'' +
                '}';
    }
    public boolean equals(@org.jetbrains.annotations.NotNull Weapon other) {
        return this.index == other.index;
    }


    @Override
    public int compareTo(@NotNull Weapon o) {
        return 0;
    }
}
