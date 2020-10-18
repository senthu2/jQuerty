function greeting(){
    console.log("Hej");
}

function preventUserSending(form){
    form.submit(function (event){
        event.preventDefault(); // forhindrer at formen bliver sendt.
        opretUser($("#username").val());// hent value fra <input...>
    });
}

function preventFormFromSending(form){
    form.submit(function (event){
        event.preventDefault(); // forhindrer at formen bliver sendt.
        searchUser($("#username").val());// hent value fra <input...>
    });
}

function preventNyhedsFormFromSending(form){
    form.submit(function (event){
        event.preventDefault(); // forhindrer at formen bliver sendt.
        hentNyheder();
    });
}

function preventOpretNyhedFromSending(form){
    form.submit(function (event){
        event.preventDefault(); // forhindrer at formen bliver sendt.
        opretNyhed($("#nyhed").val());// hent value fra <input...>
    });
}

function opretNyhed(nyhed){ // AJAX request   PAUSE til 14.32 PAUSE til 14.32 PAUSE til 14.32 PAUSE til 14.32
    console.log("opretNyhed er kaldet" );
    var opretNyhedObjekt = {};
    opretNyhedObjekt["nyheden"] = nyhed;
    $.ajax({
        url:"/api/opretnyhed",
        type:"POST",
        contentType:"application/JSON",
        data: JSON.stringify(opretNyhedObjekt),
        success:function (data){
            data.nyheder.reverse();
            $.each(data.nyheder, function (index, value){
                $("#nyheder").append("<div>" + value.nyheden +
                    "<button>Dislike</button></div>")
            })
            $("#status").html("Server: Nyheder OK");
        },
        error:function (data){
            console.log("ERROR i svar fra server");
            $("#status").html("ERROR i svar fra server");
        }
    });
}

function hentNyheder(){ // AJAX request   PAUSE til 14.32 PAUSE til 14.32 PAUSE til 14.32 PAUSE til 14.32
    console.log("hentNyheder er kaldet" );
    $.ajax({
        url:"/api/nyheder",
        type:"POST",
        contentType:"application/JSON",
        success:function (data){
            $.each(data.nyheder, function (index, value){
                $("#nyheder").append("<div>" + value.nyheden +
                    "<button>Dislike</button></div>")
            })
            $("#status").html("Server: Nyheder OK");
        },
        error:function (data){
            console.log("ERROR i svar fra server");
            $("#status").html("ERROR i svar fra server");
        }
    });
}

function searchUser(userName){ // AJAX request
    console.log("searchUser er kaldet med " + userName);
    var searchObject = {};
    searchObject["username"] = userName;
    $.ajax({
        url:"/api/search",
        type:"POST",
        contentType:"application/JSON",
        data: JSON.stringify(searchObject),
        success:function (data){
            $.each(data.userList, function (index, value){
                console.log("SUCCES svar fra server " + index);
                $("#userlist").append("<div>" + value.username +
                    "<button>Dislike</button></div>")
            })
            $("#status").html("Server: " + data.message);
        },
        error:function (data){
            console.log("ERROR i svar fra server");
            $("#status").html("ERROR i svar fra server");
        }
    });
}

function checkjQuery(){
    if(typeof jQuery != undefined){
        console.log("jQuery er loaded")
    }else {
        console.log("jQuery er IKKE loaded")
    }
}

function opretUser(userName){ // AJAX request
    console.log("searchUser er kaldet med " + userName);
    var searchObject = {};
    searchObject["username"] = userName;
    $.ajax({
        url:"/api/opretuser",
        type:"POST",
        contentType:"application/JSON",
        data: JSON.stringify(searchObject),
        success:function (data){
            $.each(data.userlist, function (index, value){
                console.log("SUCCES svar fra server " + index);
                $("#userlist").append("<div>" + value.username +
                    "<button>Dislike</button></div>")
            })
            $("#status").html("Server: " + data.message);
        },
        error:function (data){
            console.log("ERROR i svar fra server");
            $("#status").html("ERROR i svar fra server");
        }
    });

}