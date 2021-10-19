let signin = document.getElementById("sumbit");
let id = document.getElementById("id");
let firstName = document.getElementById("firstName");
let lastName = document.getElementById("lastName");
let email = document.getElementById("email");
let password = document.getElementById("password");
let valid = true;

let iderror = document.getElementById("iderror");
let firstNameError = document.getElementById("firstNameError");
let lastNameError = document.getElementById("LastNameError");
let emailError = document.getElementById("emailError");
let passwordError = document.getElementById("passwordError");

let idNumberVaildError;
let firstNameValidError;
let lastNameValidError;

success.style.display = "none";
error.style.display = "none";

function onClickingButton() {
    let idValid = true;
    let firstNameValid = true;
    let lastNameValid = true;
    let emailValid = true;
    let passwordValid = true;
    if (id.value == "") {
        iderror.innerText = "Customer Id is Mandatory"
        idValid = false;
        
    }
    else if (!id.value.match(/^[0-9]*$/)) {
        iderror.innerText = "Character or special character are not allowed"
        idValid = false;
        
    }
    if (firstName.value == "") {

        firstNameError.innerText = "First name is required";
        firstNameValid = false;
        

    }
    else if (!firstName.value.match(/^[A-Za-z]+$/)) {

        firstNameError.innerText = "Numbers cannot be included in name";
        firstNameValid = false;
        
    }
    if (lastName.value == "") {

        lastNameError.innerText = "Last name is required";
        lastNameValid = false;
        
    }
    else if (!lastName.value.match(/^[A-Za-z]+$/)) {

        lastNameError.innerText = "Numbers and Special Charcters can not be included in Lastname";
        lastNameValid = false;
        
    }
    if (email.value == "") {
        emailError.innerText = "Email is mandatory";
        emailValid = false;
    }
    else if (!email.value.match(/[a-z0-9._%+-]+@[a-z0-9.9.-]+\.[a-z]{2,}$/)) {
        emailError.innerText = "Enter in valid format. Example abc@mail.com";
        emailValid = false;
    }
    if (password.value == "") {
        passwordError.innerText = "Password is Mandatory";
        passwordValid = false;
    }
    console.log(valid);
    if (firstNameValid == true && lastNameValid == true && emailValid == true && passwordValid == true && firstNameValidError == true && lastNameValidError == true) {
        console.log("Clicked");
        addCustomer();
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

firstName.addEventListener("keyup", function () {
    firstNameValidError = true;
    if (firstName.value != "" && firstName.value.length > 20) {
        firstNameValidError = false;
        firstNameError.innerText = "First Name cannot exceed 20 characters";
        return;
    }
    if (firstName.value != "" && firstName.value.length <= 20) {


        firstNameError.innerText = "";
        return;
    }
});

lastName.addEventListener("keyup", function () {
    lastNameValidError = true;
    if (lastName.value != "" && lastName.value.length > 20) {

        lastNameValidError = false;
        lastNameError.innerText = "Last Name cannot exceed 20 characters";
        return;
    }
    if (lastName.value != "" && lastName.value.length <= 20) {
        lastNameError.innerText = "";
        return;
    }
});

email.addEventListener("keyup", function () {
    if (email.value != "") {
        emailError.innerText = "";
        return;
    }

});

password.addEventListener("keyup", function () {
    if (password.value != "" && password.value.length <= 20) {
        passwordError.innerText = "";
        return;
    }
});

async function addCustomer() {
    let customer = {
        id: id.value,
        firstName: firstName.value,
        lastName: lastName.value,
        email: email.value,
        password: password.value
    };
    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(customer)
    };

    let response = await fetch("http://localhost:8080/bank-app-rest/customers", options);
    if (response.status == 200) {
        clearFormData();
        success.style.display = "block";
        success.innerText = "Customer Added Successfully go to login page";
        
        
    }
    else {
       
        error.style.display = "block";
        error.innerText = "Failed to add employee. Retry or report to site administrator."
       
            clearFormData();
      
    }

}
function clearFormData() {
    id.value = "",
        firstName.value = "",
        lastName.value = "",
        email.value = "",
        password.value = ""

}