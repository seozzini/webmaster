<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script src="dist/index.global.js"></script>
    <script type="text/javascript">
      document.addEventListener('DOMContentLoaded', async function () {
        var calendarEl = document.getElementById('calendar');
        var today = new Date();
        var date = new Date();

        //var eventDate =[];//

        // Ajax 호출.
        // new Promise(function(){},function(){}) 매개값: 성공,실패시 실행할 함수
        // 프라미스객체가 반환될 때 await 수행코드. -> 그 다음 코드 실행.
        var eventData = [];
        let resolve = await fetch('eventList.do?job=list'); //fetch('eventList.do')
        let result = await resolve.json(); //.then(resolve => resolve.json())
        eventData = result; //.then(result => {
        //eventData = result;
        // })
        // .catch (err => console.log(err));
        console.log(result);

        var calendar = new FullCalendar.Calendar(calendarEl, {
          headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay',
          },
          initialDate: today,
          navLinks: true, // can click day/week names to navigate views
          selectable: true,
          selectMirror: true,
          select: function (arg) {
            var title = prompt('Event Title:');
            if (title) {
              console.log(arg); //start,end 값 들어있음
              let start = eventDate(arg.startStr, arg.allDay);
              let end = eventDate(arg.endStr, arg.allDay);
              fetch(
                'addEvent.do?job=add&title=' +
                  title +
                  '&start=' +
                  start +
                  '&end=' +
                  end
              )
                .then((resolve) => resolve.json())
                .then((result) => {
                  calendar.addEvent({
                    title: title,
                    start: arg.start,
                    end: arg.end,
                    allDay: arg.allDay,
                  });
                  // title, start, end 값.
                  // 화면에 출력.
                }); // 화면출력.
            }
            calendar.unselect();
          },
          eventClick: function (arg) {
            console.log(arg);
            if (confirm('Are you sure you want to delete this event?')) {
              arg.event.remove();
              fetch(
                'addEvent.do?job=del&title=' +
                  arg.event.title +
                  '&start=' +
                  arg.event.startStr +
                  '&end=' +
                  arg.event.endStr
              )
                .then((resolve) => resolve.json())
                .then((result) => {
                  calendar.addEvent({
                    title: arg.title,
                    start: arg.start,
                    end: arg.end,
                    allDay: arg.allDay,
                  });
                });
            }
          },
          editable: true,
          dayMaxEvents: true, // allow "more" link when too many events
          events: eventData, // {{}, {}, ... , {}} 배열데이터를 담을 변수
        });

        calendar.render(); // 화면출력.
      });

      function eventDate(date, allDay) {
        // true = yyyy-mm-dd
        // false = yyyy-mm-ddThh:,
        if (!allDay) {
          let year = date.getFullYear(); 
          let month = date.getMonth();
          let day = date.getDate();
          let hour = date.getHours();
          let min = date.getMinutes();
          let sec = date.getSeconds();

          return (
            year + '-' + month + '-' + day + 'T' + hour + ':' + min + ':' + sec
          );
        }
        return date;
      }
    </script>
    <style>
      body {
        margin: 40px 10px;
        padding: 0;
        font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
        font-size: 14px;
      }

      #calendar {
        max-width: 1100px;
        margin: 0 auto;
      }
    </style>
  </head>
  <body>
    <div id="calendar"></div>
  </body>
</html>