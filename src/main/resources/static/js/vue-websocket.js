//Based on https://spring.io/guides/gs/messaging-stomp-websocket/

var app = new Vue({
    el: '#app',
    data:
    {
        
        message: 'Premier test concluant',
        stompClient: null,
        comment: {text:'blablabla',author:'Echyx'}
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
            //Connexion to the websocket server
            var socket = new SockJS('/comments-websocket');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame)
            {
                //Sucess
                app.showContent();
            
                stompClient.subscribe('/topic/comments', function(comments)
                {
                    this.app.showComments(JSON.parse(comments.body));
                });
                
                //We send the id of the page for begin the data receiving
                app.sendId();
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
        sendId: function()
        {
            //There is also a server verification obvioulsy
            var id = parseInt($.urlParam('id'));
            stompClient.send("/app/hello", {}, JSON.stringify({'id': id}));
        },
        showComments: function(commentSet)
        {
            /*<img src='/dreamhack.jpg' width='300'></img> */
            
            var affichage = "<h2><strong>Evenement:</strong> "+commentSet.eventName+"</h2>";
            commentSet.set.forEach((comment)=>
            {
                affichage+=("<p><strong>Commentaire de "+comment.author+"</strong> ("+comment.date+")<br /> "+comment.text+"</p><br/><br/>");
            });
            $("#comments").html("");
            $("#comments").append(affichage);
        },
        saveComments: function()
        {
            var r = this.$resource('http://localhost:8080/api/comments/{/id}');
            r.save(this.comment).then(
                resp => {console.log('youpi');}, //OK
                resp => {
                    console.log("la");} //ERROR
                );
        }
    }
});