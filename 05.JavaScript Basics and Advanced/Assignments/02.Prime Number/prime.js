function isPrime(num){
    if(num<=1) return false
    for(let i=2; i<= Math.sqrt(num);i++){
        if(num%i===0) return false
    }
    return true 
}

function firstNPrime(n){
    let count=0,num=2;
    while(count<n){
        if(isPrime(num)){
            console.log(num)
            count++
        }
        num++
    }
}

console.log(isPrime(11)? "Prime":"Not Prime")
console.log(isPrime(12)? "Prime":"Not Prime")

firstNPrime(10)