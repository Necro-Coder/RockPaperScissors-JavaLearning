package advancedGame.game;

import advancedGame.utils.GameSpeeds;
import advancedGame.utils.Printer;
import advancedGame.utils.UserInputManager;

public class Game {
    private GameSpeeds gameSpeed = GameSpeeds.ULTRA_FAST;

    public void start() throws InterruptedException {
        initGame();
        int option = UserInputManager.readInt();
        switch (option) {
            case 1 -> {
                showMenu();
                int gameMode = UserInputManager.readInt();
                if (gameMode == 1) {
                    startSimpleGame();
                } else {
                    startAdvancedGame();
                }
            }
            case 2 -> {
                selectSpeed();
                int speed = UserInputManager.readInt();
                String speedSelected = "The advancedGame.game speed selected is: ";
                switch (speed) {
                    case 1 -> {
                        speedSelected += "Slow.";
                        gameSpeed = GameSpeeds.SLOW;
                    }
                    case 2 -> {
                        speedSelected += "Normal.";
                        gameSpeed = GameSpeeds.NORMAL;
                    }
                    case 3 -> {
                        speedSelected += "Fast.";
                        gameSpeed = GameSpeeds.FAST;
                    }
                    case 4 -> {
                        speedSelected += "Ultra Fast.";
                        gameSpeed = GameSpeeds.ULTRA_FAST;
                    }
                    case 5 -> start();
                    default -> showNoOption();
                }
                speedSelected += "\n(Type Any Key to Continue)";
                Printer.print(speedSelected, gameSpeed.getSpeed());
                UserInputManager.readInt();
                start();
            }
            case 3 -> showMenu();
            case 4 -> showInstructions();
            case 5 -> System.exit(0);
            default -> showNoOption();
        }
        Printer.print("Continue. (Type Any Key to Continue)", gameSpeed.getSpeed());
        UserInputManager.readInt();
        start();
    }

    private void startSimpleGame() throws InterruptedException {
        SimpleGame simpleGame = new SimpleGame(this.gameSpeed.getSpeed());
        try {
            simpleGame.start();
        } catch (InterruptedException e) {
            printError();
        }
    }

    private void startAdvancedGame() {

    }

    private void initGame() throws InterruptedException {
        String gameTitle = """
                Welcome to Rock, Paper, Scissors Game!!.
                These are you options:
                1. Start advancedGame.game.
                2. Select advancedGame.game speed.
                3. Customize advanced mode.
                4. Instructions.
                5. Exit.
                """;
        Printer.print(gameTitle, gameSpeed.getSpeed());
    }

    private void showInstructions() throws InterruptedException {
        String instructions = """
                The advancedGame.game has 2 modes:
                1. Simple Game.
                2. Advanced Game.
                                
                In case you select the Simple Game, the advancedGame.game will follow the rules of classic Rock, Paper,
                Scissors advancedGame.game.
                In case you select the Advanced Game, the advancedGame.game will follow the rules of
                Rock, Paper, Scissors,
                Lizard, Spock advancedGame.game by default, but you can customize the names by selecting
                Customized Game in the main menu.
                In case you select the Customized Game, you can add or remove weapons and their rules.
                If you want to exit, select Exit.
                """;

        Printer.print(instructions, gameSpeed.getSpeed());
    }

    private void selectSpeed() throws InterruptedException {
        String speedMenu = """
                Select the advancedGame.game speed (Ultra Fast by default):
                1. Slow.
                2. Normal.
                3. Fast.
                4. Ultra Fast.
                5. Back.
                """;
        Printer.print(speedMenu, gameSpeed.getSpeed());
    }

    private void showMenu() throws InterruptedException {
        String menu = """
                Select you advancedGame.game mode:
                1. Simple Game.
                2. Advanced Game.
                4. Exit.
                """;
        Printer.print(menu, gameSpeed.getSpeed());
    }

    private void showNoOption() throws InterruptedException {
        String noOption = """
                There is no option for this number.
                Please select a valid option.
                """;
        Printer.print(noOption, gameSpeed.getSpeed());
    }

    private void printError() throws InterruptedException{
        Printer.print("An error occurred. Please try again.", gameSpeed.getSpeed());
        System.exit(1);
    }
}
