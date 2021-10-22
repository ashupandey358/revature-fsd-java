let signin = document.getElementById("sumbit");
let id = document.getElementById("ID");
let Name = document.getElementById("Name");
let Email = document.getElementById("Email");
let Password = document.getElementById("Password");
let deparment = document.getElementById("dep")
let valid = true;

let iderror = document.getElementById("idError");
let NameError = document.getElementById("nameError");
let EmailError = document.getElementById("emailidError");
let PasswordError = document.getElementById("passwordError");

let idNumberVaildError;
let NameValidError;

success.style.display = "none";
error.style.display = "none";

function onClickingButton() {
    let idValid = true;
    let NameValid = true;
    let emailValid = true;
    let PasswordValid = true;
    if (id.value == "") {
        iderror.innerText = "Customer Id is Mandatory";
        idValid = false;
        
    }
    else if (!id.value.match(/^[0-9]*$/)) {
        iderror.innerText = "Character or special character are not allowed"
        idValid = false;
        
    }
    if (Name.value == "") {

        NameError.innerText = "name is required";
        NameValid = false;
        

    }
    else if (!Name.value.match(/^[A-Za-z]+$/)) {

        NameError.innerText = "Numbers cannot be included in name";
        NameValid = false;
        
    }
    if (Email.value == "") {

        EmailError.innerText = "Email is required";
        emailValid = false;
        
    }
    else if (!Email.value.match(/[a-z0-9._%+-]+@[a-z0-9.9.-]+\.[a-z]{2,}$/)) {

        EmailError.innerText = "write in this way abc@123.gmail.com";
        emailValidValid = false;
        
    }
    if (Password.value == "") {
        PasswordError.innerText = "Password is Mandatory";
        PasswordValid = false;
    }
    if (idValid == true && NameValid == true && PasswordValid == true && emailValid == true  && NameValidError == true) {
        addemployee();
    }
}

id.addEventListener("keyup", function () {
 
    customeriderror = true;
    if (id.value != "" && id.value.length > 6) {
        idNumberVaildError = false;
        iderror.innerText = "id value not greter then 6";
        return;
    }
    if (id.value != "" && id.value.length <= 6) {


        iderror.innerText = "";
        return;
    }
});

Name.addEventListener("keyup", function () {
    NameValidError = true;
    if (Name.value != "" && Name.value.length > 20) {
        NameValidError = false;
        NameError.innerText = "First Name cannot exceed 20 characters";
        return;
    }
    if (Name.value != "" && Name.value.length <= 20) {


        NameError.innerText = "";
        return;
    }
});

Email.addEventListener("keyup", function () {
    if (Email.value != "") {
        EmailError.innerText = "";
        return;
    }

});

Password.addEventListener("keyup", function () {
    if (Password.value != "" && Password.value.length <= 20) {
        PasswordError.innerText = "";
        return;
    }
});

async function addemployee() {
    console.log("hiiii");
    let employee = {
        employeeId: id.value,
        name: Name.value,
        email: Email.value,
       password: Password.value,
       department: deparment.value
    };
    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(employee)
    };

    let response = await fetch("http://localhost:8080/bank-app-rest/employees", options);
    if (response.status == 200) {
        clearFormData();
        success.style.display = "block";
        success.innerText = "employee Added Successfully go to login page";
        
        
    }
    else {
       
        error.style.display = "block";
        error.innerText = "Failed to add employee. Retry or report to site administrator."
       
            clearFormData();
      
    }

}
function clearFormData() {
        id.value = "",
        Name.value = "",
        Email.value = "",
        Password.value = ""
      

}

