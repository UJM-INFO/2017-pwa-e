var stompClient = null;

function setConnected(connected)
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
}

function connect()
{
    var socket = new SockJS('/comments-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame)
    {
        setConnected(true);
        console.log('Connecté: ' + frame);
        stompClient.subscribe('/topic/comments', function (greeting)
        {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect()
{
    if(stompClient !== null)
    {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Déconnecté");
}

function sendName()
{
    stompClient.send("/app/hello", {}, JSON.stringify({'id': $("#id-comment").val()}));
}

function showGreeting(message)
{
    $("#comments").append("<tr><td>" + message + "</td></tr>");
}

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

