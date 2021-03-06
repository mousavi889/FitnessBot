package ir.sbu.db;

import ir.sbu.db.Controller.MainController;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {

    public static void main(String[] args)
    {
        ApiContextInitializer.init();
        // Instantiate Telegram Bots API
        TelegramBotsApi botsApi = new TelegramBotsApi();
        // Register our bot
        try
        {
            botsApi.registerBot(new MainController());
        }
        catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }
}
