window.onload = function() { countNewNews(); };

function countNewNews() {
    var startNum = document.getElementById("countNewNews").innerHTML;
   if (startNum ===''){
       startNum = getRandomInt (1 , 20);
   }else {
       startNum++;
   }
    document.getElementById("countNewNews").innerHTML = startNum;

    var dt = getRandomInt (3 , 7) * 1000;

    setTimeout("countNewNews()", dt);
}

function getRandomInt(min, max){
    return Math.floor(Math.random() * (max - min + 1)) + min;
}
