
var p;
var r;
var t;

var emi;
var total_Payment;
var total_Interest;


function EstimateReducingInterestLoan() {

    p = parseFloat(document.getElementById('principalAmount').value);
    r = parseFloat(document.getElementById('interestRate').value);
    t = parseFloat(document.getElementById('tenure').value);
    
    r = (r/100)/12;
    emi = p * r * (Math.pow((1 + r), t) / (Math.pow((1 + r), t)-1));
    total_Payment = emi * t;
    total_Interest = total_Payment - p;
    calculateEMI();
    totalPayment();
    totalInterest();
    EstimateFixedInterestLoan();

    return false;


}

function EstimateFixedInterestLoan() {
    /* Fill with required javascript code here  */
    var fixedInt = p * r * t;
    fixedInt = fixedInt.toFixed(2);
    document.getElementById("tInterestFixed").innerHTML = fixedInt; /*Assign total Interest value here*/

    /* Fill with required javascript code here  */
    var fixedpay = parseFloat(p) + parseFloat(fixedInt);
    fixedpay = fixedpay.toFixed(2);
    document.getElementById("tPaymentFixed").innerHTML = fixedpay; /*Assign total payment value here*/

    /* Fill with required javascript code here  */
    var fixedemi = fixedpay / (t/12 * 12);
    fixedemi = fixedemi.toFixed(2);
    document.getElementById("EMIFixed").innerHTML = fixedemi; /*Assign emi  value here*/
    return false;

}

function calculateEMI() {

    /* Fill with required javascript code here  */

    emi = emi.toFixed(2);
    document.getElementById("EMI").innerHTML = emi;/*Assign emi value here*/
}

function totalPayment() {

    /* Fill with required javascript code here  */

    total_Payment = total_Payment.toFixed(2);
    document.getElementById("tPayment").innerHTML = total_Payment; /*Assign total payment value here*/
}

function totalInterest() {

    /* Fill with required javascript code here  */

    total_Interest = total_Interest.toFixed(2);
    document.getElementById("tInterest").innerHTML = total_Interest; /*Assign total Interest value here*/
}


