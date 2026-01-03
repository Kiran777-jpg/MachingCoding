import tictactoe.controllers.GameController;
import tictactoe.models.Bot;
import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.models.Symbol;
import tictactoe.models.enums.GameState;
import tictactoe.strategies.winningStrategy.ColWinningStrategy;
import tictactoe.strategies.winningStrategy.DiagonalWinningStrategy;
import tictactoe.strategies.winningStrategy.RowWinningStrategy;
import tictactoe.strategies.winningStrategy.WinningStrategy;
import tictactoe.models.enums.BotDifficultyLevel;
import tictactoe.models.enums.PlayerType;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TicTacToeMain {
    public static void main(String[] args) {
        System.out.println("Hello world, printed by " + Thread.currentThread().getName());

        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);

        System.out.println("GAME STARTS");

        int dimensions = sc.nextInt();
        List<Player> players = List.of(
                new Player("John", new Symbol('X'), PlayerType.HUMAN),
                new Bot("Bot", new Symbol('O'), PlayerType.BOT, BotDifficultyLevel.EASY)
        );

        List<WinningStrategy> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinningStrategy()
        );

        Game game = gameController.startGame(dimensions, players, winningStrategies);

        while(gameController.getGameState().equals(GameState.IN_PROGRESS)) {

            //1. show the board
            //2. make a move
            game.printBoard(game);

        }
    }
}

// create the models
// create the way to create a objects using builder or normal