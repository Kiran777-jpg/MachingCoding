import tictactoe.models.Bot;
import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.models.Symbol;
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

        System.out.println("Game Starts");

        Scanner sc = new Scanner(System.in);
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

        Game game = Game.getBuilder().setDimensions(dimensions)
                                     .setPlayers(players)
                                     .setWinningStrategies(winningStrategies)
                                     .build();
    }
}

// create the models
// create the way to create a objects using builder or normal