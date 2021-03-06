var app = new Vue({
    el: '#app',
    data:
    {
    },
    methods:
    {
        displayUserAdminUI : function(event)
        {
            var id = event.currentTarget.id;
            var pseudo = id.split('_')[1];
            
            var userAdminUI = 
                    '<div class="btn-group">'+
                    '    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">'+
                    '        Changement de role <span class="caret"></span>'+
                    '    </button>'+
                    '    <ul class="dropdown-menu">'+
                    '        <li><a href="/become_user?token=vba7rqk6lra5fua1&&pseudo='+pseudo+'">Utilisateur</a></li>'+
                    '        <li><a href="/become_editor?token=vba7rqk6lra5fua1&&pseudo='+pseudo+'">Editeur</a></li>'+
                    '        <li><a href="/become_admin?token=vba7rqk6lra5fua1&&pseudo='+pseudo+'">Administateur</a></li>'+
                    '    </ul>'+
                    '  </div><br /><hr />';
                    
            $("#hideButton_"+pseudo).show();  
            $("#displayButton_"+pseudo).hide();   
            $("#userAdminUI_"+pseudo).html(userAdminUI);
        },
        hideUserAdminUI : function(event)
        {
            var id = event.currentTarget.id;
            var pseudo = id.split('_')[1];
            
            $("#hideButton_"+pseudo).hide();
            $("#displayButton_"+pseudo).show();
            $("#userAdminUI_"+pseudo).html("");
        }
        
    }
});