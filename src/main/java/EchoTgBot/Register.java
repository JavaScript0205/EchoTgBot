package EchoTgBot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Register {
    public static void main(String[] args) {
        try {
            TelegramBotsApi bot = new TelegramBotsApi(DefaultBotSession.class);

            bot.registerBot(new EchoBot());

        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
