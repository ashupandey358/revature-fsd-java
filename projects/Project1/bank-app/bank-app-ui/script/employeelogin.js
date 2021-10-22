let submit1 = document.getElementById("submit");
var emailid1 = document.getElementById("email");
var password1 = document.getElementById("password");
error.style.display = "none";

submit1.addEventListener("click", async function forLogin() {
    
    try {
        
        let data = await fetch("http://localhost:8080/bank-app-rest/employees/" + emailid1.value + "/" + password1.value);
        let customerDetails = await data.json();
        if (data.status == 200) {  
           window.location.href="12-EmployeeMain.html"
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

    










