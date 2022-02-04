package com.ATM;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.sql.*;

import static com.ATM.Database.*;

public class AtmMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Database database = new Database();



        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new AtmBanking());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
