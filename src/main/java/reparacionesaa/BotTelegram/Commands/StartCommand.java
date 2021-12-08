package reparacionesaa.BotTelegram.Commands;


import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import reparacionesaa.BotTelegram.Bot;
import reparacionesaa.BotTelegram.Config.Answer;
import reparacionesaa.Controller.UserController;


public class StartCommand  extends BotCommand{
   

   public StartCommand() {
      super("start", "Con este comando puedes iniciar el bot");
   }
   
   
    public void MessageStart( Message message) {
        UserController controller= new UserController();
        

        String userName = message.getFrom().getFirstName() + " " + message.getFrom().getLastName();
         String saludo="";
         
         
         String id=message.getFrom().getId().toString();
         
        if (controller.setUserStateForCommandsBot(id)) {
            saludo="Hola de nuevo "+ userName+ Answer.START_STRING;
        } else {
            saludo=
            "Hola "+userName+Answer.START_STRING;
            
        }
        Bot bot=new Bot();
        bot.sendMessagetoChat(message.getChatId().toString(),saludo);
    }


}
