var app = new Vue({
    el: '#app',
    data:
    {
    },
    methods:
    {
        displayCreation : function()
        {
            var userAdminUI = 
                '<h2>Création d\'évenement</h2>'+
                '<form th:action="@{/add_event}" method="POST">'+
                '    <label> Description : <input type="text" class="form-control" name="description"/></label><br/>'+
                '    <label> Equipe 1 : <input type="text" class="form-control" name="team1"/></label><br/>'+
                '    <label> Equipe 2 : <input type="text" class="form-control" name="team2"/></label><br/>'+
                '<input type="submit" class="btn btn-info btn-lg btn-block" value="Valider"/>'+
                '</form>';
                     
            $("#creationDisplayButton").hide();   
            $("#eventCreation").html(userAdminUI);
        }
    }
});