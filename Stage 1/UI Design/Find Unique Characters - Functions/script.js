function modifyString(str){
    str = str.toLowerCase();
    newStr = '';
    for (var i = 0; i < str.length; i++){
        if(str.charAt(i) === ' ') continue;
        newStr += str.charAt(i);
    }
    return newStr;
}

function uniqueCharacters(str)
{
    var newStr = modifyString(str);
    var seen =[];
    for(var i = 0; i < newStr.length; i++){
        var ch = newStr.charAt(i);
        if (seen.indexOf(ch) === -1) seen.push(ch);
    }

    return seen.join('');
} 

console.log(uniqueCharacters('Rishabh Gupta'));