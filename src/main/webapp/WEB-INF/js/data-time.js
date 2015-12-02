function clock() {
    var d = new Date();
    var day = d.getDate();
    var hours = d.getHours();
    var minutes = d.getMinutes();
    var seconds = d.getSeconds();

    var month=new Array("January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December");
    var days=new Array("Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday");

    if (day <= 9) {
        day = "0" + day;
    }
    if (hours <= 9) {
        hours = "0" + hours;
    }
    if (minutes <= 9) {
        minutes = "0" + minutes;
    }
    if (seconds <= 9) {
        seconds = "0" + seconds;
    }
    var date_date = day + " " + month[d.getMonth()] + " " + d.getFullYear() + " (" +
        days[d.getDay()] + ")";
    var date_time = hours + ":" + minutes + ":" + seconds;

    document.getElementById("id_date").innerHTML = date_date;
    document.getElementById("id_time").innerHTML = date_time;

    setTimeout("clock()", 1000);
}
//clock();