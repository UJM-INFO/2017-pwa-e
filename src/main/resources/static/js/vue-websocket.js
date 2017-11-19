var app = new Vue({
    el: '#app',
    data:
    {
        message: 'Premier test concluant',
        stompClient: null
    },
    methods:
    {
        connect: function()
        {
            var socket = new SockJS('/comments-websocket');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame)
            {
                setConnected(true);
                console.log('Connecté: ' + frame);
                stompClient.subscribe('/topic/comments', function(comments)
                {
                    showComments(JSON.parse(comments.body).content);
                });
            });
        },
        setConnected: function(connected)
        {
            $("#connect").prop("disabled", connected);
            $("#disconnect").prop("disabled", !connected);
            if(connected)
            {
                $("#comments-table").show();
            }
            else
            {
                $("#comments-table").hide();
            }
            $("#comments").html("");
        },
        connect: function()
        {
            var socket = new SockJS('/comments-websocket');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame)
            {
                setConnected(true);
                console.log('Connecté: ' + frame);
                stompClient.subscribe('/topic/comments', function (greeting)
                {
                    showComments(JSON.parse(greeting.body).content);
                });
            });
        },
        disconnect: function()
        {
            if(stompClient !== null)
            {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Déconnecté");   
        },
        sendName: function()
        {
            stompClient.send("/app/hello", {}, JSON.stringify({'id': $("#id-comment").val()}));
        },
        showComments: function(message)
        {
            $("#comments").append("<tr><td>" + message + "</td></tr>");
        }
        
    }
});
app.connect();


$(function ()
{
    $("form").on('submit', function (e)
    {
        e.preventDefault();
    });
    $( "#connect" ).click(function()
    { connect(); });
    $( "#disconnect" ).click(function()
    { disconnect(); });
    $( "#send" ).click(function()
    { sendName(); });
});

