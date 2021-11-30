const { Telegraf } = require('telegraf');

const bot = new Telegraf('2051754904:AAFcdIMzL54b7QM55jE4w1eOaRbyWFKwaWQ');


var validarCotizacion = false;

var validarSolicitud = false;

var validarday = false;

var validarhorario = false;

var sumaPiezas = 0;

var flagNoPiezas = false;

//bot.command(['dia', 'DIA', 'Dia'], (ctx) => {

//})

/*bot.onStartChattingMessage((message) => {
    bot.getUserProfile(message.from)
        .then((user) => {
            message.reply(`Hola ${user.firstName}! Soy Ariasbot🤖 de Reparaciones AA, si eliges nuestro servicio de reparaciones no te arrepentirás. Oprime cualquier tecla para continuar`);
        });
});*/

bot.help((ctx) => {
    ctx.replyWithPhoto('https://i.imgur.com/wzfBfYa.jpg')
    ctx.reply(`Inserta el numero o letra de la pieza que necesites cotizar igual al de la imágen. 
    Si necesitas varias insertalas una por una y se irá realizando la suma de los precios de las piezas que elijas.

     \nPara salir de la cotización y mostrar el monto de las piezas cotizadas escribe la palabra 'last' `);
    if(sumaPiezas == 0){
        ctx.reply("Si no sabes que le falla a tu control ingresa '?' ");
    }

    validarCotizacion = true;
})

bot.settings((ctx) => {


    if (sumaPiezas != 0 || flagNoPiezas == true ) {
        validarSolicitud = true;
        validarday = true;

        ctx.reply(`Gracias por solicitar nuestro servicio ` + ctx.from.first_name + `.
        \nLe informamos que los días que podemos recibir su equipo son de lunes a viernes de 13 a 19 horas. \n
        Recuerda que puedes agendar solo si ya has hecho tu cotización, si no la has hecho introduce /help.\n
        `);
        ctx.reply("Ingresa el digito del dia que agendarás con nosotros, correspondiente a la imagen.")

        ctx.replyWithPhoto('https://i.imgur.com/9uPtR5G.jpg');


    } else {

        ctx.reply("Solicita la cotización con el comando /help antes de agendar con nosotros");

    }

})

//bot.help((ctx) => ctx.reply('Send me a sticker'))
//bot.on('sticker', (ctx) => ctx.reply('👍'));
//bot.hears('hi', (ctx) => ctx.reply('Hey there'));

bot.on('message', (ctx) => {

    let msj = ctx.message.text;

    if (validarCotizacion != true && validarSolicitud != true) {

        console.log(ctx.from)

        ctx.reply(`Bienvenid@ al Bot de Arias Reparaciones🤖,  ` + ctx.from.first_name + " " + ctx.from.last_name);
        ctx.reply(`👉Escribe /help para comenzar o continuar tu cotización con nosotros.
         \n👉Escribe /settings para agendar con nosotros una vez que tengas tu cotización `)
    }

    if (validarCotizacion == true && flagNoPiezas == false) {



        switch (msj) {

            case '1':
                ctx.reply("El costo de la pieza " + msj + " es de $150");
                ctx.reply("\n\nPara salir de la cotización y mostrar el monto de las piezas escribe la palabra 'last' ");
                sumaPiezas += 150;
                break;
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '16':
            case 'A':
            case 'a':
            case 'B':
            case 'b':
            case 'X':
            case 'x':
            case 'Y':
            case 'y':
                ctx.reply("El costo de la pieza " + msj + " es de $100");
                ctx.reply("\n\nPara salir de la cotización y mostrar el monto de las piezas cotizadas escribe la palabra 'last' ");
                sumaPiezas += 100;
                break;
            case '?':
                ctx.reply("Si no sabes lo que le sucede a tu control, no te preocupes, puedes agendar tu cita sin costo con el comando /settings. ");
                flagNoPiezas = true;
                break;
            case 'last':
                if((sumaPiezas !== 0 )|| (sumaPiezas == 0 && flagNoPiezas == true) ){
                    ctx.reply(`👍Fin de la cotización👍
                \nEl total de esta cotización es de: $` + sumaPiezas);
                ctx.reply(`👉Escribe /help para comenzar o continuar tu cotización con nosotros.
                \n👉Escribe /settings para agendar con nosotros una vez que tengas tu cotización `)
                validarCotizacion = false;
                }else{
                    ctx.reply("Elige una opción que corresponda a la imagen antes de salir, recuerda que si lo que necesitas no está entre las opciones o no sabes lo que necesitas puedes ingresar '?' ")
                    sumaPiezas = 0;
                    flagNoPiezas == false;

                }
                
                break;
            default:
                ctx.reply("Escribe la letra o numero correctos que correspondan a la imagen+++");
        }


    }


    if ((validarSolicitud == true && sumaPiezas != 0) || (flagNoPiezas == true)) {

        var dia;
        var hora;


        if (validarday == true) {
            switch (msj) {

                case "L":
                case "l":
                    ctx.reply("Has elegido el día Lunes inserta otra inicial si deseas un día diferente. Para confirmar tu elección escribe '0' ");
                    dia = 'Lunes';
                    break;


                case "M":
                case "m":
                    ctx.reply("Has elegido el día Martes inserta  otra inicial si deseas un día diferente. Para confirmar tu elección escribe '0' ");
                    dia = 'Martes';
                    break;


                case "X":
                case "x":
                    ctx.reply("Has elegido el día Miercoles inserta otra inicial si deseas un día diferente. Para confirmar tu elección escribe '0' ");
                    dia = 'Miercoles';
                    break;


                case "J":
                case "j":
                    ctx.reply("Has elegido el día Jueves inserta otra inicial si deseas un día diferente. Para confirmar tu elección escribe '0' ");
                    dia = 'Jueves';
                    break;


                case "V":
                case "v":
                    ctx.reply("Has elegido el día Viernes inserta otra inicial si deseas un día diferente. Para confirmar tu elección escribe '0' ");
                    dia = 'Viernes';
                case "0":
                    ctx.reply("Has elegido el dia " + dia + ", es momento de elegir la hora")
                    ctx.reply("Selecciona el numero del horario correspondiente a la imagen")
                    
                    ctx.replyWithPhoto('https://i.imgur.com/WK6QA1j.jpg');

                    validarhorario = true;
                    validarday = false;
                    break;
                default:
                     ctx.reply("Escribe la letra y numero correctos que correspondan a la imagen*");
            }
        }


        if (dia != 0 || validarhorario == true) {
            horario = true;
            switch (msj) {
                case '1':
                    ctx.reply("Has elegido el horario de las 13 horas, si deseas otro horario ingresa el numero correspondiente. Si deseas salir escribe 'fin' ");
                    hora = 13;
                    break;

                case '2':
                    ctx.reply("Has elegido el horario de las 14 horas; si deseas otro horario ingresa el numero correspondiente. Si deseas salir escribe 'fin' ");
                    hora = 14;
                    break;
                case '3':
                    ctx.reply("Has elegido el horario de las 15 horas, ingresa '3' para confirmar; si deseas otro horario ingresa el numero correspondiente. Si deseas salir escribe 'fin' ");
                    hora = 15;
                    break;
                case '4':
                    ctx.reply("Has elegido el horario de las 16 horas; si deseas otro horario ingresa el numero correspondiente. Si deseas salir escribe 'fin' ");
                    hora = 16;
                    break;
                case '5':
                    ctx.reply("Has elegido el horario de las 17 horas; si deseas otro horario ingresa el numero correspondiente. Si deseas salir escribe 'fin' ");
                    hora = 17;
                    break;
                case '6':
                    ctx.reply("Has elegido el horario de las 18 horas; si deseas otro horario ingresa el numero correspondiente. Si deseas salir escribe 'fin' ");
                    hora = 18;
                    break;
                case '7':
                    tx.reply("Has elegido el horario de las 19 horas, ingresa '5' para confirmar; si deseas otro horario ingresa el numero correspondiente. Si deseas salir escribe 'fin' ");
                    hora = 19;
                    break;
                case 'fin':
                    ctx.reply(`Fin de la agenda. \n Has asignado una cita con nosotros, te esperamos el día ` + dia + ` a las ` + hora + `:00 horas, aquí te dejamos la ubicación `);
                    ctx.replyWithPhoto('https://i.imgur.com/tOsH9i5.jpg');
                    ctx.replyWithLocation('21.028913493274725', '-89.57957424483826');
                    validarhorario = false;
                    validarCotizacion == false;
                    validarday == 0;
                    validarhorario == 0;
                    validarSolicitud = false;
                    return;

                default:
                    ctx.reply("Escribe la letra y numero que correspondan a la imagen..");

            }

        }


    }


})


console.log("Hola, todo bien");
bot.launch()