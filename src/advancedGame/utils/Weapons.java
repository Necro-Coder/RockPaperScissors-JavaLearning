package advancedGame.utils;

import advancedGame.Weapons.Weapon;
import advancedGame.Weapons.classicWeapons.Paper;
import advancedGame.Weapons.classicWeapons.Rock;
import advancedGame.Weapons.classicWeapons.Scissors;

public enum Weapons {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private final int weaponValue;
    private Weapon selectedWeapon;

    Weapons(int selected) {
        this.weaponValue = selected;
        setWeapon(selected);
    }

    private void setWeapon(int weaponValue) {
           switch (weaponValue) {
            case 1 -> {
                this.selectedWeapon = new Rock();
            }
            case 2 -> {
                this.selectedWeapon = new Paper();
            }
            case 3 -> {
                this.selectedWeapon = new Scissors();
            }
            default -> {
                this.selectedWeapon = new Weapon(0, "Unknown");
            }
        }
    }

    public int getWeaponValue() {
        return weaponValue;
    }

    public Weapon getSelectedWeapon() {
        return selectedWeapon;
    }

    public int getWeapon(String weapon) {
        switch (weapon.toLowerCase()) {
            case "rock" -> {
                return ROCK.getWeaponValue();
            }
            case "paper" -> {
                return PAPER.getWeaponValue();
            }
            case "scissors" -> {
                return SCISSORS.getWeaponValue();
            }
            default -> {
                return 0;
            }
        }
    }

}
