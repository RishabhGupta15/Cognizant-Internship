function validateEmail(email) {
    var regex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g;
    var matches = email.match(regex);
    if(matches){
        if(matches == email) return 'Valid email address!';
        else return 'Invalid email address!';
    } 
    return 'Invalid email address';
 }

 console.log(validateEmail('rishabhgupta15nov@peechrammarList.com'));
 