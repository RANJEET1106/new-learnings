const EventEmitter = require('events')
const myEmitter = new EventEmitter()

function greetuser(name) {
  console.log('Greetings ' + name)
}

const greet1 = (name) => {
  console.log('Event handling example ' + name)
}

const greet2 = (name) => {
  console.log('Greetings ' + name)
}

myEmitter.on('greet', greet1)
myEmitter.on('greet', greet2)

myEmitter.emit('greet', 'Yash')

// user login notification
myEmitter.on('userLoggedIn', (username, age, city) => {
  console.log(`User Logged In: ${username}, Age: ${age}, City: ${city}`)
  myEmitter.emit('welcome', username)
})

myEmitter.on('welcome', (username) => {
  console.log(`Welcome ${username}!`)
})

myEmitter.emit('userLoggedIn', 'Yash', 21, 'Pune')

//Once example
myEmitter.once('greet', greetuser);

// remove one listener or off
myEmitter.removeListener('greet', greet1)
myEmitter.emit('greet', 'Yash')

// remove all greet listeners
myEmitter.removeAllListeners('greet')
myEmitter.emit('greet', 'Yash')


//shopping cart

const shopping = new EventEmitter()

shopping.on('itemAdded', (item) => {
  console.log(`Added: ${item.name} - ₹${item.price}`)
})

let cart = []
let items = [
  { name: 'Soap', price: 85.99 },
  { name: 'Toothpaste', price: 150 },
  { name: 'Bread', price: 50 },
  { name: 'Butter', price: 60 }
]

function addItem(item) {
  cart.push(item)
  shopping.emit('itemAdded', item)
}

items.forEach(addItem)

console.log('Final Cart:', cart)

///chat room

const chatRoom = new EventEmitter()

function handleJoin(user) {
  console.log(`${user} joined the chat`)
}

function handleLeave(user) {
  console.log(`${user} left the chat`)
}

function handleMessage(user, msg) {
  console.log(`${user}: ${msg}`)
}

chatRoom.on('join', handleJoin)
chatRoom.on('leave', handleLeave)
chatRoom.on('sendMessage', handleMessage)

chatRoom.emit('join', 'Yash')
chatRoom.emit('sendMessage', 'Yash', 'Hello everyone!')
chatRoom.emit('join', 'Aarav')
chatRoom.emit('sendMessage', 'Aarav', 'Hey Yash!')
chatRoom.emit('leave', 'Yash')
