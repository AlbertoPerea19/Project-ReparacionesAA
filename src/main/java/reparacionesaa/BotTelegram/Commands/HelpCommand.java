package reparacionesaa.BotTelegram.Commands;



import org.telegram.telegrambots.meta.api.objects.Message;

import reparacionesaa.BotTelegram.Bot;
import reparacionesaa.BotTelegram.Config.Answer;
import reparacionesaa.BotTelegram.Config.BotConfig;

public class HelpCommand {
   

   public void helpMessage(Message message){
      String id=message.getChatId().toString();
      String ayuda=Answer.HELP_STRING;

      Bot bot=new Bot();
        bot.sendMessagetoChat(id,ayuda);
      
        bot.sendImagetoChat(BotConfig.IMAGELOGO, id);

        bot.sendMessagetoChat(id, Answer.CONTINUE_STRING);
   }   
}
