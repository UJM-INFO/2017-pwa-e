//Based on https://spring.io/guides/gs/messaging-stomp-websocket/

var app = new Vue({
    el: '#app',
    data:
    {
        stompClient: null,
        comment: {text:'caca',author:'Chris',date:' ',idEvent: 2}
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
                
            
                stompClient.subscribe('/topic/comments', function(comments)
                {
                    console.log("ALLLLLLLLERTE A LUPDATE");
                    app.updateComments();
                    //this.app.showComments(JSON.parse(comments.body));
                });
                
                app.updateComments();
                
                //We send the id of the page for begin the data receiving
                //app.sendId();
            });
        },
        disconnect: function()
        {
            if(stompClient !== null)
            {
                stompClient.disconnect();
            }
            this.app.hideContent();
            
            console.log("Déconnecté");   
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
//        sendId: function()
//        {
//            //There is also a server verification obvioulsy
//            var id = parseInt($.urlParam('id'));
//            stompClient.send("/app/get_comments_by_eventid", {}, JSON.stringify({'id': id}));
//        },
        showComments: function(commentSet)
        {     
            var parsedCommentSet = JSON.parse(commentSet.bodyText);
            
            var display = "<h2><strong>Evenement:</strong> "+/*commentSet.eventName*/" erreur (Objet Event pas encore fait alors marche po)"/**/+"</h2>";
            parsedCommentSet._embedded.comments.forEach((comment)=>
            {
                display+=("<p><strong>Commentaire de "+comment.author+"</strong> ("+comment.date+")<br /> "+comment.text+"</p><br/><br/>");
            });
            $("#comments").html("");
            $("#comments").append(display);
        },
        saveComments: function()
        {
            var r = this.$resource('http://localhost:8080/api/comments/{/id}');
            r.save(this.comment).then(
            resp =>
            {
                console.log('save ok');
                
                //We send a websocket signal to the server too
                stompClient.send("/app/update", {}, JSON.stringify({'id': parseInt($.urlParam('id'))}));
                
            }, //OK
            resp =>
            {
                console.log("save error");
            } //ERROR
            );
        },
        updateComments: function()
        {
            var r = this.$resource('http://localhost:8080/api/comments/') //POUR RAJOUTER L'ID IL FAUDRA REQUETER SUR DES EVENT
            r.get({id: 2}).then(
            response =>
            {
                this.showComments(response);
                console.log("get ok");
            },
            response =>
            {
                console.log("get error");
            });
        }
    }
});
