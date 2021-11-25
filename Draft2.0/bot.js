const { Telegraf } = require('telegraf')

const bot = new Telegraf('2051754904:AAFcdIMzL54b7QM55jE4w1eOaRbyWFKwaWQ')


var coti = false

bot.help((ctx) => {
    ctx.replyWithPhoto('https://i.imgur.com/wzfBfYa.jpg')
    ctx.reply("Inserta el numero o letra de la pieza que necesites cotizar, si necesitas varias insertalas una por una, con el carácter igual al de la imágen");
    coti = true
})

//bot.help((ctx) => ctx.reply('Send me a sticker'))
bot.on('sticker', (ctx) => ctx.reply('👍'))
bot.hears('hi', (ctx) => ctx.reply('Hey there'))


bot.on('message', (ctx) => {
    let msj = ctx.message.text;

    if (coti == true) {

        if (msj == '1'){
            ctx.reply("El costo de esta pieza es de $150");
        }
         if (msj == '2' ||msj =='7'||msj =='3'||msj =='4'||msj =='5'||msj =='6'||msj =='8'||msj =='9'||msj =='A'||msj =='B'||msj =='X'||msj =='Y'){
            ctx.reply("El costo de esta pieza es de $100");
        }

            ctx.reply("Si ya no quieres seguir insertando introduce la palabra 'fin' ");
        if(msj == 'fin'){
            coti = false
            ctx.reply("fin de la cotizacion");
        }

    }
    else {
        if (msj == "lince") {
            ctx.reply("Tú lo que yo + 1");
        }
        ctx.reply(`
        Bienvenido al Bot de Arias Reparaciones. 
    
    Somos una empresa dedicada a reparar y dar mantenimiento a los controles de Xbox One a un precio justo. Si dejarás tu control en manos de alguien, somos la mejor opción.
    
    Proporcionanos tu nombre y número telefónico
    
    Escribe /help para comenzar a cotizar con nosotros
        `);
    }

})



bot.launch()