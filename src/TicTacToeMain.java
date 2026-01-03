import tictactoe.controllers.GameController;
import tictactoe.exceptions.InvalidMoveException;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TicTacToeMain {
    public static void main(String[] args) throws InvalidMoveException {
        System.out.println("Hello world, printed by " + Thread.currentThread().getName());

        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);

        System.out.println("GAME STARTS");
        System.out.println("Players Registration: ");
        System.out.print("Enter the Players Count: ");
        int playersCount = sc.nextInt();
        List<Player> players = new ArrayList<>();
        for(int i=0;i<playersCount;i++) {
            System.out.print("Player " + (i+1) + ": Human - 1/Bot - 2: ");
            int playerType = sc.nextInt();
            System.out.print("Enter Player " + (i+1) + " Name: ");
            String playerName = sc.next();
            System.out.print("Enter Player " + (i+1) + " Symbol: ");
            String playerSymbol = sc.next();
            players.add(
                    playerType == 1 ? new Player(playerName, new Symbol(playerSymbol.charAt(0)), PlayerType.HUMAN) :
                    new Bot("Bot", new Symbol(playerSymbol.charAt(0)), PlayerType.BOT, BotDifficultyLevel.EASY)
            );
        }

        int dimensions = playersCount + 1;

        List<WinningStrategy> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinningStrategy()
        );

        Game game = gameController.startGame(dimensions, players, winningStrategies);

        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)) {

            //1. show the board
            //2. make a move
            gameController.printBoard(game);

            if(!gameController.getcurrentPlayerBot(game)) {
                System.out.println("Do you want to undo ? y/n");
                String isUndo = sc.next();
                if(isUndo.equals("y")) {
                    gameController.undo(game);
                    continue;
                }
            }

            gameController.makeMove(game);
        }
        gameController.printBoard(game);
        if(gameController.getGameState(game).equals(GameState.ENDED)) {
            System.out.println(gameController.getWinner(game).getName() + " has won the game");
        } else {
            System.out.println("GAME DRAW");
        }
    }
}

// create the models
// create the way to create a objects using builder or normal