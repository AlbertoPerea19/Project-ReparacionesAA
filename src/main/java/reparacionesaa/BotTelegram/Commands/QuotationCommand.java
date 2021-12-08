package reparacionesaa.BotTelegram.Commands;


import org.telegram.telegrambots.meta.api.objects.Message;

import reparacionesaa.BotTelegram.Bot;
import reparacionesaa.BotTelegram.Config.Answer;
import reparacionesaa.BotTelegram.Config.BotConfig;

public class QuotationCommand {
   
   public void quotation(Message message){
      
      String id=message.getChatId().toString();
      

      Bot bot=new Bot();
        bot.sendMessagetoChat(id,Answer.QUOTATION_STRING);
      
        bot.sendImagetoChat(BotConfig.IMAGECONTROL, id);

        bot.sendMessagetoChat(id, Answer.QUO_STRING);
        
      
   }   
   

  
}
