function OrderCake(str) {
	var l = str.length;
    var wt = parseInt(str.slice(0,4));
    var flavor = str.slice(4, l-3);
    var id = str.slice(l-3, l);
    var cost = 450;
    var price = Math.r(wt/1000 * cost);
    wt = Math.round(wt/1000);
    
    
    return ('Your order for ' + wt + ' kg ' + flavor + ' cake has been taken. You are requested to pay Rs. ' + price + ' on the order no ' + id);
}

console.log(OrderCake('5848Butterkmk456'));