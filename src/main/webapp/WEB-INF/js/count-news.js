window.onload = function() {
    countNewNews();
    lastNews();
};

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


function getXmlHttp(){
    var xmlhttp;
    try {
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (E) {
            xmlhttp = false;
        }
    }
    if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
        xmlhttp = new XMLHttpRequest();
    }
    return xmlhttp;
}

function lastNews() {
    var req = getXmlHttp();
    var statusElem = document.getElementById('lastnews');
    req.onreadystatechange = function() {;
        if (req.readyState == 4) {
            if(req.status == 200) {
                statusElem.innerHTML = req.responseText;
            }
        }
    }

    req.open('POST', '/LastNews', true);
    req.send(null);
    statusElem.innerHTML = ''

    setTimeout("lastNews()", 5000);
}

$(document).ready(function(){
    $('#newButton').click(function(){
        alert ('00')
        sendData();
    });
});
function sendData(){
    var mge = $('#newText').val();
    alert(mge);
    $.ajax({
        type: "POST",
        url: "/lastNews",
        data: { message : mge  }
    }).done(function( msg ) {
        alert( "Data Saved: " + msg );
    });
}

