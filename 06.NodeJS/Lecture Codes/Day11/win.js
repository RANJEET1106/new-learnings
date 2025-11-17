require('./app1')
const winston = require('winston')
const paymentLogger = winston.loggers.get('paymentLogger')
const orderLogger = winston.loggers.get('orderLogger')
// paymentLogger.info('payment received')
// orderLogger.error('order Failed')


let requestHandler = (path)=>{
    const profiler= paymentLogger.startTimer()
    for(let i=0;i<100000;i++) i*3
    profiler.done({message:`request to ${path} is processed`})
}
requestHandler('/payment') 