let strInput = '';
function addFeedback(){
    let input = document.getElementById('feedback').value;
    console.log(input);
    document.getElementById('confirm-msg').innerHTML = 'Successfully Added Feedback Details';
}

function displayFeedback(){
    let input = document.getElementById('feedback').value;
    strInput += input;
    document.getElementById('confirm-msg').innerHTML = strInput;
}