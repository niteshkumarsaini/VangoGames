function handleCredentialResponse(response) {
  console.log(response);
  if (response.credential) {
      try {
          const idToken = response.credential;
          const decodedToken = JSON.parse(atob(idToken.split('.')[1]));
          let str="";
          for(i=decodedToken.email.length-1; i>=0; i--){
            str=str+decodedToken.email.charAt(i);
          }
     
        let st1=str.substring(0,str.length/2);
         let st2=str.substring(str.length/2,str.length)
         let stEncoded=`^^2366@jiehhstyri${st2}99jjddebbd783266hHHTTTWEWkkddheeyt${st1}nnnehh&&&TT##`
       
          $(document).ready(() => {

              $.ajax({
                  url: "/signinusinggoogle",
                  type: "POST",
                  data: stEncoded,
                  contentType: "application/text",  // Set content type to JSON
                  success: function (data, status, jqXHR) {
                    // console.log(requestData)  
                    console.log("Successfully request sent..");
                    









                   
                  
                      
                  },
                  error: function (jqXHR, status, errorThrown) {
                    if (jqXHR.status === 400) {
                      // Bad Request: Handle this type of error
                      window.location.href="/completeProfile"
                      console.log("Bad Request: Invalid data sent to the server.");
                  } else if (jqXHR.status === 401) {
                      // Unauthorized: Handle this type of error
                      console.log("Unauthorized: User is not authenticated.");
                  } else if (jqXHR.status === 404) {
                      // Not Found: Handle this type of error
                      console.log("Not Found: The requested resource was not found on the server.");
                  } else if (jqXHR.status === 500) {
                      // Internal Server Error: Handle this type of error
                    window.location.href="/register";
                  } else {
                      // Other error status codes: Handle as needed
                      console.log("Unhandled error status code:", jqXHR.status);
                  }
                  }
              });
          });

      } catch (error) {
          console.error("Error decoding JWT:", error);
      }
  } else {
      console.error("Credential is missing");
  }
}
function registerRedirection(){
  window.location.href="/register";

}


const showpassword=document.getElementById("showpassword");
const passwordField=document.getElementById("passwordfield");
showpassword.addEventListener('click',()=>{
  if(passwordField.getAttribute("type")=='password'){
    passwordField.setAttribute("type","text");

  }
  else{
    passwordField.setAttribute("type","password");

  }
})




