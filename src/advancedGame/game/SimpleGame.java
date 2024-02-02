package advancedGame.game;

import advancedGame.Weapons.Weapon;
import advancedGame.utils.Printer;
import advancedGame.utils.UserInputManager;
import advancedGame.utils.Weapons;

import java.util.Map;

public class SimpleGame {
    private final Map<Integer, Weapon> weapons = Map.of(
            Weapons.ROCK.getWeapon(Weapons.ROCK.name()), Weapons.ROCK.getSelectedWeapon(),
            Weapons.PAPER.getWeapon(Weapons.PAPER.name()), Weapons.PAPER.getSelectedWeapon(),
            Weapons.SCISSORS.getWeapon(Weapons.SCISSORS.name()), Weapons.SCISSORS.getSelectedWeapon()
    );
    private final int gameSpeed;
    private Weapon weaponSelected;
    private Weapon computerWeapon;

    public SimpleGame(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }
    public void start() throws InterruptedException {
        System.out.print("Game starting");
        Printer.printLoadingDots(12);
        initGame();
        if (UserInputManager.readString().equalsIgnoreCase("exit")) {
            return;
        } else if(UserInputManager.readString().equalsIgnoreCase("y")) {
            printGameModeInstructions();
            UserInputManager.readInt();
        }
        showDialog();
        getWeaponSelected();
        generateRandomWeapon();
        printResult();
        showFinalMenu();
        int finalMenuOption = UserInputManager.readInt();
        if (finalMenuOption == 1) {
            showDialog();
        }
    }

    private void initGame() throws InterruptedException {
        Printer.print("""
                Selected Game Mode: Simple Game.
                The basicGame.game follow the rules of classic Rock, Paper, Scissors basicGame.game.
                You will play against the computer.
                Do you want to see the instructions? (Y/n .. if you want to exit, type exit)
                """, this.gameSpeed);
    }

    private void generateRandomWeapon() {
        int randomWeaponId = (int) (Math.random() * 3 + 1);
        this.computerWeapon = this.weapons.get(randomWeaponId);
    }
    private void printResult() throws InterruptedException {
        String result = "You selected: " + this.weaponSelected.getName() + "\n";
        result += "The computer selected: " + this.computerWeapon.getName() + "\n";
        result += "The result is: ";
        switch (this.weaponSelected.compareTo(this.computerWeapon)) {
            case 1 -> result += "You win! ";
            case -1 -> result += "You lose! ";
            default -> result += "It's a tie! ";
        }
        Printer.print(result, this.gameSpeed);
    }
    private void printGameModeInstructions() throws InterruptedException{
        String instructions = """
                -----------------
                Game Rules:
                -> Rock crushes Scissors
                -> Scissors cuts Paper
                -> Paper covers Rock
                -----------------
                How to play:
                When the song end, enter your choice: Rock, Paper, or Scissors in less than 3 seconds.
                You will see a simple menu to select your choice.
                The basicGame.game will show the result and the winner.
                The basicGame.game will continue until you decide to stop.
                Enjoy the basicGame.game!
                (Press any key to continue)
                """;

        Printer.print(instructions, this.gameSpeed);

    }
    private void showDialog() throws InterruptedException {
        String menu = """
                Select your choice:
                1. Rock
                2. Paper
                3. Scissors
                4. Exit
                Enter your choice:\s""";
        Printer.print(menu, this.gameSpeed);
    }
    private void getWeaponSelected() {
        int weaponSelectedId = UserInputManager.readInt();
        this.weaponSelected = this.weapons.get(weaponSelectedId);
    }
    private void showFinalMenu() throws InterruptedException {
        String finalMenu = """
                Do you want to play again?
                1. Yes
                2. No
                """;
        Printer.print(finalMenu, this.gameSpeed);}
}
