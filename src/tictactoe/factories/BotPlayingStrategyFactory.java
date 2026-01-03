package tictactoe.factories;

import tictactoe.models.enums.BotDifficultyLevel;
import tictactoe.strategies.botPlayingStrategy.BotPlayingStrategy;
import tictactoe.strategies.botPlayingStrategy.EasyBotPlayingStrategy;
import tictactoe.strategies.botPlayingStrategy.HardBotPlayingStrategy;
import tictactoe.strategies.botPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyFactory(BotDifficultyLevel botDifficultyLevel) {
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)) {
            return new EasyBotPlayingStrategy();
        } else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)) {
            return new MediumBotPlayingStrategy();
        }
        return new HardBotPlayingStrategy();
    }
}
