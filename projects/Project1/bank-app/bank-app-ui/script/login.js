let submit = document.getElementById("submit");
let emailid = document.getElementById("email");
let password = document.getElementById("password");
let emailError = document.getElementById("emailError");
let passworderror = document.getElementById("password");
error.style.display = "none";
console.log(password)
submit.addEventListener("click", async function forLogin() {
    try {
        
        let data = await fetch("http://localhost:8080/bank-app-rest/customers/" + emailid.value + "/" + password.value);
        let customerDetails = await data.json();
        if (data.status == 200) {  
           window.location.href="00-AccountMain.html"
        }
        else if (response.status == "401") {
            console.log("Login failed");
            error.style.display = "block";
            error.innerText = "Enter Correct Credentials";
        }
        else if (response.status == "404") {
            error.style.display = "block";
            error.innerText = "Enter E-mail and Password";
        }
    }catch(err)
    {
        error.style.display = "block";
         error.innerText = "Server is facing an issue. Try after sometime. Sorry For Inconvenience";
    }


    });

    










