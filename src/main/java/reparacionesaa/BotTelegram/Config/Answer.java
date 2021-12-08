package reparacionesaa.BotTelegram.Config;

public class Answer {


   private Answer() {
   }



   public static final String START_STRING=
   
   ", sea usted bienvenid@ al Bot de Arias Reparaciones.\n"+
   "Somos una empresa dedicada a reparar y dar mantenimiento a los controles de Xbox One a un precio justo."+"\n\n"+
  "👉Escribe /cotizar para comenzar o continuar tu cotización con nosotros.\n"+
  "👉Escribe /help para tener más informacion\n"+
  "👉Escribe /cancelar para salir";



   public static final String QUOTATION_STRING=

   "Muy bien! Comencemos con su cotización, para ello adjuntaremos una imagen donde tendrá que escoger"+
   " qué piezas tenemos que reparar.\n\n En caso que desconozca el fallo de su control, favor de escribir /help \n\n"+
   "El bot automáticamente sacará los costos de la(s) reparacion(es) que usted necesite\n\n"+
   "En caso que quiera cancelar, favor de escribir /cancel para salir";


   public static final String QUO_STRING=
   "Inserte el número o letra de la pieza que necesite cotizar igual al de la imágen, pero con el prefijo 'pieza', como se le muestra a continuación:\n\n"+
   "pieza1, piezaA, pieza16\n\nSiempre respetando los espacios y las mayúsculas.\nSi necesitas varias insertalas una por una y se irá realizando la suma de los precios de las piezas que elijas";

   public static final String HELP_STRING=

   "Si tienes dudas acerca de este bot o de quienes somos, en esta sección responderemos a cada una de ellas.\n\n"+
   "👾¿Qué hace este bot?👾\n AriasBot está dedicado al servicio del cliente, la cual tomará órdenes para poder brindarle"+
   " una cotización en reparaciones de controles de xbox; logrando así que usted no tenga la necesidad de ir presencialmente a que lo chequen.\n\n"+
   "🤔¿Quiénes Somos?🤔\n Somos una empresa dedicada a reparar y dar mantenimiento a los controles de Xbox One a un precio justo en manos de expertos.\n\n"+
   "🎮¿Qué hago si desconozco lo que tiene mi control?🎮\n"+
   "Para estos casos te recomendamos irte a nuestra página de facebook, donde te podrás poner directamente en contacto "
   +BotConfig.FACEBOOKURL+"\n  Tambien contamos con Whatsapp" +BotConfig.PHONENUMBER;

   public static final String CANCEL_STRING= "Nos vemos pronto, que tenga un bonito día";

   public static final String CONTINUE_STRING="Si quiere seguir con el proceso de cotización: \n Escriba /cotizar para iniciar proceso\n"+
   "Escriba /cancelar para salir";

}
