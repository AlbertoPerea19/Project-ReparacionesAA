package reparacionesaa.BotTelegram.Reparation;


import java.util.ArrayList;

import org.telegram.telegrambots.meta.api.objects.Message;

import reparacionesaa.BotTelegram.Bot;

public class Reparation {
   

   


   public void costosReparacion(Message message){
      ArrayList<Integer> costototales=new ArrayList<>();
      Bot bot=new Bot();      
      String id=message.getChatId().toString();
      String mensaje= message.getText();
     

      if(mensaje.startsWith("pieza")){
         
         if(mensaje.equals("pieza1")){
            costototales.add(150);
         bot.sendMessagetoChat(id, "Esta pieza tiene un costo de $150");

         }
         else if(mensaje.equals("pieza2")||mensaje.equals("pieza3")||mensaje.equals("pieza4")||
         mensaje.equals("pieza5")||mensaje.equals("pieza6")||mensaje.equals("pieza7")||mensaje.equals("pieza8")||
         mensaje.equals("pieza9")||mensaje.equals("pieza16")||mensaje.equals("piezaA")||mensaje.equals("piezaB")||
         mensaje.equals("piezaX")||mensaje.equals("piezaY")){
            costototales.add(100);
            bot.sendMessagetoChat(id, "Esta pieza tiene un costo de $100");
         }
          
         else {
            bot.sendMessagetoChat(id, "Por favor ingrese un valor correcto, si tiene dudas escriba /help para responder a cada una de ellas");
         }
         bot.sendMessagetoChat(id, "Para terminar cotización escriba /finish");

      }

      if(mensaje.equals("/finish")){
         int sum=0;
         for(int i=0;i<costototales.size();i++){
            sum=+costototales.get(i);
          }
         String suma= String.valueOf(sum);
         bot.sendMessagetoChat(id, "La reparación tendrá un costo de: "+suma);

      }


      if(mensaje.startsWith("Pieza")||mensaje.startsWith("Pieza ")){
         bot.sendMessagetoChat(id, "Por favor respete los espacios, mayúsculas y minúsculas");
      }  
   
   }
}