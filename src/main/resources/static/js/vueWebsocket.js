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
        typeMatch: function(type)
        {
            if(type=='1')
                return "BO1";
            if(type=='3')
                return "BO3";
            if(type=="5")
                return "B05";
        },
        getTeam1: function(commentSet,event)
        {
           var links = event._links.team1.href;
           this.test = this.$http.get(links);
           return this.test.then(
                    resp =>
                    {     
                        var team1 = JSON.parse(resp.bodyText);
                        this.getTeam2(commentSet,event,team1);
                    },
                    resp =>
                    {
                        console.log("Error get team1");
                    }
                );
        },
        getTeam2: function(commentSet,event,team1)
        {
           var links = event._links.team2.href;
           this.test = this.$http.get(links);
           return this.test.then(
                    resp =>
                    {     
                        var team2 = JSON.parse(resp.bodyText);
                        this.getStatsTeam1(commentSet,event,team1,team2);
                    },
                    resp =>
                    {
                        console.log("Error get team2");
                    }
                );
        },
        getStatsTeam1: function(commentSet,event,team1,team2)
        {
           var links = event._links.stats_team1.href;
           this.test = this.$http.get(links);
           return this.test.then(
                    resp =>
                    {     
                        var stats_team1 = JSON.parse(resp.bodyText);
                        this.getStatsTeam2(commentSet,event,team1,team2,stats_team1);
                    },
                    resp =>
                    {
                        console.log("Error get team1");
                    }
                );
        },
        getStatsTeam2: function(commentSet,event,team1,team2,stats_team1)
        {
           var links = event._links.stats_team2.href;
           this.test = this.$http.get(links);
           return this.test.then(
                    resp =>
                    {     
                        var stats_team2 = JSON.parse(resp.bodyText);
                        this.showComments(commentSet,event,team1,team2,stats_team1,stats_team2);
                    },
                    resp =>
                    {
                        console.log("Error get team1");
                    }
                );
        },
        statusMatch: function(status)
        {
            
            if(status=='0')
                return "La partie n'a pas encore commencé!";
            if(status=='1')
                return "L'équipe 1 à gagné!";
            if(status=='2')
                return "L'équipe 2 à gagné!";
        },
        showComments: function(commentSet,event,team1,team2,stats_team1,stats_team2)
        {     

            
            console.log(commentSet);
            console.log(event);
            console.log(team1);
            console.log(team2);
            console.log(stats_team1);
            console.log(stats_team2);
            
            
            var display = "<p>"+event.description+" en "+this.typeMatch(event.type)+"</p><br/>";
            display += "<p>"+this.statusMatch(event.status)+"</p><br/>";
 
 
            display+= "<div class='container'>"+
                            "<div class='row justify-content-md-center'>"+
                                "<div class='col col-lg-1'>"+
                                '<img src="/images/logoteam'+team1.teamName+'.png"/>'+
                                "</div>"+
                                "<div class='col-md-auto'>"+
                                    ""+
                                "</div>"+
                                "<div class='col col-lg-2'>"+
                                  '<img src="/images/logoteam'+team2.teamName+'.png"/>'+
                                "</div>"+
                            "</div>"+                    
                            "<div class='row justify-content-md-center'>"+
                                "<div class='col col-lg-1'>"+                                
                                    stats_team1.kill+
                                "</div>"+
                                "<div class='col-md-auto'>"+
                                    "KILL"+
                                "</div>"+
                                "<div class='col col-lg-2'>"+
                                  stats_team2.kill+
                                "</div>"+
                            "</div>"+
                            "<div class='row justify-content-md-center'>"+
                                "<div class='col col-lg-1'>"+
                                    stats_team1.tower+
                                "</div>"+
                                "<div class='col-md-auto'>"+
                                    "TOWER"+
                                "</div>"+
                                "<div class='col col-lg-2'>"+
                                    stats_team2.tower+
                                "</div>"+
                            "</div>"+
                            "<div class='row justify-content-md-center'>"+
                                "<div class='col col-lg-1'>"+
                                    stats_team1.drake+
                                "</div>"+
                                "<div class='col-md-auto'>"+
                                    "DRAKE"+
                                "</div>"+
                                "<div class='col col-lg-2'>"+
                                  stats_team2.drake+
                                "</div>"+
                            "</div>"+
                        "</div>";
            
            
            commentSet._embedded.comments.forEach((comment)=>
            {
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
                
                var r2 = this.$resource('http://localhost:8080/api/events{/id}');
                
                r2.get({id: parseInt($.urlParam('id'))}).then(
                response2 =>
                {
                    var parsedComment = JSON.parse(response1.bodyText);
                    var parsedEvent = JSON.parse(response2.bodyText);
                    this.getTeam1(parsedComment,parsedEvent);
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
