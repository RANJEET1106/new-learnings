const winston=require('winston')
const {combine, timestamp, prettyPrint, errors, json}= winston.format
const logger=winston.createLogger({
    level:'info',
    format:combine(timestamp(), prettyPrint(), json(),errors({stack:true})),
    transports:[new winston.transports.Console, 
        new winston.transports.File({filename:'app.log'})
    ]
})

module.exports= logger