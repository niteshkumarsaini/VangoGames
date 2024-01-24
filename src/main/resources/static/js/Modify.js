
const refresh_timer=document.getElementById("refresh-timer")
var seconds=20;
var totals=0;
    const id=setInterval(()=>{
    seconds=seconds-1;
    totals=totals+1;
    if(seconds==0){
        clearInterval(id);
        $(document).ready(()=>{
            $.ajax(({
                url:"/gameredirect",
                type:"POST",
                data:totals,
                success:function(data,status,jqXHR){
                    console.log(data);
                },
                error:function(jqXHR,status,errorThrown){
                    console.log(status);
                },
                processData:false,
                contentType:"text/html"

                
            }))
        })
        console.log(totals)
        
    }
    if(seconds<=10){
        refresh_timer.style.color="red";
    }
    else{
        refresh_timer.style.color="white";

    }
    refresh_timer.innerHTML=`${seconds} sec`;
    // console.log(seconds)
    
    
    },1000)
    
    const timerFunction=()=>{


      seconds=20;
    }
timerFunction();
    

const closeGame=()=>{
clearInterval(id);
        $(document).ready(()=>{
            $.ajax(({
                url:"/gameredirect",
                type:"POST",
                data:totals,
                success:function(data,status,jqXHR){
                    console.log(data);
                },
                error:function(jqXHR,status,errorThrown){
                    console.log(status);
                },
                processData:false,
                contentType:"text/html"

                
            }))
            window.location.href="/games";
        })
}


