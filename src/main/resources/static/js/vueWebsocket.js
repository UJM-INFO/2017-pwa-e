//Based on https://spring.io/guides/gs/messaging-stomp-websocket/

var app = new Vue({
    el: '#app',
    data:
    {
        stompClient: null
    },
    created: function()
    {
        //Launch at the opening of the page
        this.connect();
    },
    methods:
    {
        connect: function()
        {
            //Connection to the websocket server
            var socket = new SockJS('/comments-websocket');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame)
            {
                //Sucess
                app.showContent();


                //When we receive a signal from the server we update comments
                stompClient.subscribe('/topic/comments', function(comments)
                {
                    console.log("UPDATE");
                    setTimeout(app.updateComments,100);
                });
                
                //The first displaying of comments
                app.updateComments();
            });
        },
        disconnect: function()
        {
            if(stompClient !== null)
            {
                stompClient.disconnect();
            }
            this.app.hideContent(); 
        },
        showContent()
        {
            $("#comments-table").show();
            $("#comments").html("");
        },
        hideContent()
        {
            $("#comments-table").hide();
            $("#comments").html("");
        },
        showComments: function(commentSet,event)
        {     
            var parsedComment = JSON.parse(commentSet.bodyText);
            var parsedEvent = JSON.parse(event.bodyText);
            
            var display = "";
            parsedComment._embedded.comments.forEach((comment)=>
            {
                console.log(comment);
                display+=("<p>"+comment.text+"</p><br/>");
            });
            $("#comments").html("");
            $("#comments").append(display);
        },
        saveComments: function()
        {
                console.log('save ok');
                stompClient.send("/app/update", {}, JSON.stringify({'id': parseInt($.urlParam('id') )}));
        },
        updateComments: function()
        {
            var r = this.$resource('http://localhost:8080/api/events{/id}/comments');
            r.get({id: parseInt($.urlParam('id'))}).then(
            response1 =>
            {
                console.log("get comments ok");
                var r2 = this.$resource('http://localhost:8080/api/events{/id}');
                r2.get({id: parseInt($.urlParam('id'))}).then(
                response2 =>
                {
                    console.log("get event ok");
                    this.showComments(response1,response2);

                },
                response2 =>
                {
                    console.log("get event error");
                });
            },
            response1 =>
            {
                console.log("get comments error");
            });
        }
    }
});