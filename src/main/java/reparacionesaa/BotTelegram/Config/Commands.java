package reparacionesaa.BotTelegram.Config;
/*
*@author Rafael Perea
*@version 1.0
*@brief bot config
*@date 03 december 2021
*/
public class Commands {


   private Commands() {
   }

   public static final String INITCOMMAND = "/";

   //start
   public static final String STARTCOMMAND = INITCOMMAND + "start";

   //quotation
   public static final String QUOTATIONCOMMAND = INITCOMMAND + "cotizar";

   //help
   public static final String HELPCOMMAND = INITCOMMAND + "help";

   //Cancel
   public static final String CANCELCOMMAND = INITCOMMAND + "cancelar";

   //finish
   public static final String FINISHCOMMAND = INITCOMMAND + "finish";



}
