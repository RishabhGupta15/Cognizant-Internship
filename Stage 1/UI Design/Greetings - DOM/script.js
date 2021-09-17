function display(){
    var name = document.getElementById('sname').value;
    var courseIndx = document.getElementById('course').options.selectedIndex;
    var courses = ['Python','Java','Oracle']

    if(name) document.getElementById('greet').innerHTML = 'Hi,' + name + '. You have successfully reqisterd for '+ courses[courseIndx] + ' course.';
    else document.getElementById('greet').innerHTML = 'Name cannot be empty';
    return false;
}