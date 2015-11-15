/**
 * Created by Remco on 13-11-2015.
 */



function getTimeRemaining(endTime) {
    var parsedDate = Date.parse(endTime);
    if (isNaN(parsedDate)){
        return {
            'totalDiff': 0,
            'seconds': 0,
            'minutes': 0,
            'hours': 0,
            'days': 0
        };
    }
    else {
        var totalDiff = parsedDate - Date.parse(new Date());
        var seconds = Math.floor((totalDiff / 1000) % 60);
        var minutes = Math.floor((totalDiff / 1000 / 60) % 60);
        var hours = Math.floor((totalDiff / 1000 * 3600) % 24);
        var days = Math.floor(totalDiff / (1000 * 3600 * 24));

        return {
            'totalDiff': totalDiff,
            'seconds': seconds,
            'minutes': minutes,
            'hours': hours,
            'days': days
        };
    }
}

function initializeCountdown(endTime) {
    var countdownDiv = document.getElementById('countdown');
    var daysSpan = countdownDiv.querySelector('.days');
    var hoursSpan = countdownDiv.querySelector('.hours');
    var minutesSpan = countdownDiv.querySelector('.minutes');
    var secondsSpan = countdownDiv.querySelector('.seconds');


    function updateClock() {
        var time = getTimeRemaining(endTime);

        daysSpan.innerHTML = time.days;
        hoursSpan.innerHTML = ('0' + time.hours).slice(-2);
        minutesSpan.innerHTML = ('0' + time.minutes).slice(-2);
        secondsSpan.innerHTML = ('0' + time.seconds).slice(-2);

        if (time.totalDiff <= 0) {
            clearInterval(timeInterval);
            daysSpan.innerHTML = '0';
            hoursSpan.innerHTML = '00';
            minutesSpan.innerHTML = '00';
            secondsSpan.innerHTML = '00';

            //Invoke backing bean
            var jsfCommandLink = document.getElementById("form:link");
            jsfCommandLink.click();
        }
    }

    updateClock(); // run function once at first to avoid delay
    var timeInterval = setInterval(updateClock, 1000);
}