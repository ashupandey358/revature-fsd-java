let accountNo = document.getElementById("accountNo");
let aadharNo = document.getElementById("aadharNo");
let phoneno = document.getElementById("phoneno");
let balance = document.getElementById("balance");
let accounttype = document.getElementById("accounttype");
let createAccountButton = document.getElementById("createAccountButton");
let success = document.getElementById("success");
let error = document.getElementById("error");
success.style.display = "none";
error.style.display = "none";
let accountNoerror = document.getElementById("accountNoerror");
let aadharerror = document.getElementById("aadharerror");
let phonenoError = document.getElementById("phonenoError");
let balanceError = document.getElementById("balanceError");
let accounttypeError = document.getElementById("accounttypeError");

createAccountButton.addEventListener("click", function () {
    let accountNoValid = true;
    let aadharNoValid = true;
    let phonenoValid = true;
    let balanceValid = true;
    let accounttypeValid = true;

    if (accountNo.value == "") {
        accountNoValid = false;
        accountNoerror.innerText = "Account No Is Manadatory";
        return;
    }
    else if(!accountNo.value.match(/^[0-9]*$/))
    {
        accountNoValid = false;
        accountNoerror.innerText = "Account No Is only digit";
        return;
    }
    if (aadharNo.value == "") {
        aadharNoValid = false;
        aadharerror.innerText = "aadhar No Is Manadatory";
        return;
    }
    else if(!aadharNo.value.match(/^[0-9]+$/))
    {

        aadharNoValid = false;
        aadharerror.innerText = "aadhar No Is only digit";
        return;
    }
    if (phoneno.value == "") {
        phonenoValid = false;
        phonenoError.innerText = "phone No Is Manadatory";
        return;
    }
    else if(!phoneno.value.match(/^[0-9]+$/))
    {
        phonenoValid = false;
        phonenoError.innerText = "phone No Is only digit";
        return;
    }
    if (balance.value == "") {
        balanceValid = false;
        balanceError.innerText = "intial balance is Manadatory";
        return;
    }
    else if(!balance.value.match(/^[0-9]+$/))
    {
        balanceValid = false;
        balanceError.innerText = "intial balance is only digit";
        return;
    }
    if (accountNoValid == true && aadharNoValid == true && phonenoValid == true && balanceValid == true) {
        console.log("clicked");
        createAccount();
    }

});

accountNo.addEventListener("keyup", function () {
    if (accountNo.value != "") {
        accountNoerror.innerText = "";
        return;
    }

});

aadharNo.addEventListener("keyup", function () {
    if (aadharNo.value != "") {
        aadharerror.innerText = "";
        return;
    }

});


phoneno.addEventListener("keyup", function () {
    if (phoneno.value != "") {
        phonenoError.innerText = "";
        return;
     
    }

});

balance.addEventListener("keyup", function () {
    if (balance.value != "") {
        balanceError.innerText = "";
        return;
    }

});




async function createAccount()
{
    let account = {
        accountNo: accountNo.value,
        aadharNumber: aadharNo.value,
        mobileNumber: phoneno.value,
        balance: balance.value,
        accountType: accounttype.value
        

    };

    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(account)
    };
    
        let response = await fetch("http://localhost:8080/bank-app-rest/accounts",options)
        if(response.status==200){
        console.log("Account Creation SuccessFull");
        clearFormData();
        window.location.href = "00-AccountMain.html"
        }
        else{
            error.style.display = "block";
            error.innerText = "Failed to create account. Retry or report to site administrator.";
        }
    

};

function clearFormData(){
    accountNo.value = "";
    aadharNo.value = "";
    phoneno.value = "";
    balance.value = "";
    accounttype.value = "";
}








