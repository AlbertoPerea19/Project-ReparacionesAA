package reparacionesaa.BotTelegram;
/*
*@author Rafael Perea
*@version 1.0
*@brief bot config
*@date 03 december 2021
*/


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import reparacionesaa.BotTelegram.Commands.HelpCommand;
import reparacionesaa.BotTelegram.Commands.QuotationCommand;
import reparacionesaa.BotTelegram.Commands.StartCommand;
import reparacionesaa.BotTelegram.Config.Answer;
import reparacionesaa.BotTelegram.Config.BotConfig;
import reparacionesaa.BotTelegram.Config.Commands;
import reparacionesaa.BotTelegram.Reparation.Reparation;
import reparacionesaa.Controller.UserController;


public class Bot extends TelegramLongPollingBot {
  
  UserController controller;
  Reparation reparation;
  
  @Override 
   public String getBotUsername() {
      
      return BotConfig.USERNAMEBOT;
   }

   @Override
   public String getBotToken() {

     return BotConfig.TOKENBOT;
   }


   @Override
   public void onUpdateReceived(Update update) { 
      reparation= new Reparation();
      Message message=update.getMessage();
      opcionesComandos(message);
      reparation.costosReparacion(message);
      
   }
   

   private void opcionesComandos(Message message){
      
         if(message.getText().equals(Commands.STARTCOMMAND)){
            StartCommand start=new StartCommand();
            start.MessageStart(message);
            }
         if(message.getText().equals(Commands.HELPCOMMAND)){
            HelpCommand help= new HelpCommand();
            help.helpMessage(message);
            }
         if(message.getText().equals(Commands.CANCELCOMMAND)){
            sendMessagetoChat(message.getChatId().toString(), Answer.CANCEL_STRING);
            reparation= new Reparation();
            
            }
         if(message.getText().equals(Commands.QUOTATIONCOMMAND)){
            QuotationCommand quotation=new QuotationCommand();
            quotation.quotation(message);
            }                
                      
   }
       
   public SendMessage sendMessagetoChat(String chatId, String text){
      SendMessage sendMessage= new SendMessage();
      sendMessage.setChatId(chatId);
      sendMessage.setText(text);

      try {
         execute(sendMessage);
      } catch (TelegramApiException e) {
         e.printStackTrace();
      }
      return sendMessage;
      
   }

   public void sendImagetoChat(String fileId, String chatId) {
      SendPhoto sendPhotoRequest = new SendPhoto();
      sendPhotoRequest.setChatId(chatId);
      sendPhotoRequest.setPhoto(new InputFile(fileId));
      try {
          execute(sendPhotoRequest);
      } catch (TelegramApiException e) {
          e.printStackTrace();
      }
  }          
}