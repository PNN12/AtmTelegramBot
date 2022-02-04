package com.ATM;

import org.checkerframework.checker.units.qual.A;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.ATM.VarConstant.*;

public class AtmBanking extends TelegramLongPollingBot {
    static String status = START;

    @Override
    public String getBotUsername() {
        return "atmtelegram_bot";
    }

    @Override
    public String getBotToken() {
        return "5258741771:AAHY27uGDZOWMB2twuAAQqQnLFq8YC7aXTg";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message =update.getMessage();
        long chatId = update.getMessage().getChatId();

        if(message != null){

            if (message.getText().equals(START)) {
                SendMessage sendMessageWelcome = new SendMessage();
                sendMessageWelcome.setChatId(String.valueOf(chatId));
                sendMessageWelcome.setText("Welcome to ATM\n" + "Your account number is " + chatId);
                try {
                    execute(sendMessageWelcome);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }



                if (message.getText().equals(ATM)){
                    SendMessage sendMessageATM = new SendMessage();
                    sendMessageATM.setChatId(String.valueOf(chatId));
                   sendMessageATM.setText("+=+=+=ATM operation=+=+=+\n" +"Choose (/withdraw) for Withdraw\n" + "Choose (/deposit) for Deposit\n" + "Choose (/balance) for Check Balance\n" +"Choose (/exit) for EXIT\n" + "Choose the operation you want to perform:");
                    try{
                        execute(sendMessageATM);
                    }catch (TelegramApiException e){
                        e.printStackTrace();
                  }
                }

                if (message.getText().equals(WITHDRAW)){
                    SendMessage sendMessageWithdraw = new SendMessage();
                    sendMessageWithdraw.setChatId(String.valueOf(chatId));
                    sendMessageWithdraw.setText("Enter the amount to be withdraw:");
                    try{
                        execute(sendMessageWithdraw);
                    }catch (TelegramApiException e){
                        e.printStackTrace();
                    }

                }
                status = DEPOSIT;
                if (message.getText().equals(status)){

                }

            }
        }
    }
}





