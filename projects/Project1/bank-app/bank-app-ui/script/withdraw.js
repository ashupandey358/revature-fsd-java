const urlParams = new URLSearchParams(window.location.search);
const currentAccountNo = urlParams.get('id');
console.log(currentAccountNo);
let amount = document.getElementById("amount");
let depositBtn = document.getElementById("depositButton")
let amountError = document.getElementById("amountError");
let successMessage = document.getElementById("success");
let errorMessage = document.getElementById("error");
successMessage.style.display = "none";
errorMessage.style.display = "none";

depositBtn.addEventListener("click", function () {
    amountEnteredValid = true;
    if (amount.value == "") {
        amountError.innerText = "Amount is manadatory";
        amountEnteredValid = false;
    }
    else if (amount.value <= 0) {
        amountError.innerText = "Amount Cannot be less than 0";
        amountEnteredValid = false;
    }
    else if (!amount.value.match(/^[0-9]+$/)) {
        amountError.innerText = "Amount should be in integers only.";
        amountEnteredValid = false;
    }
    if (amountEnteredValid == true) {
        console.log("Clicked");
        performWithdrwa();
    }
});

amount.addEventListener("keyup", function () {
    if (amount.value != "") {
        amountError.innerText = "";
    }
});

async function performWithdrwa() {
    let withdrawDetails = {
        accountNumber: currentAccountNo,
        amount: amount.value
    };

    var options = {
        method: 'PUT',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(withdrawDetails)
    };
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/transctions", options);

        if (response.status == 200){
            successMessage.style.display = "Block";
            errorMessage.style.display = "none";
            window.location.href = "00-AccountMain.html"
            clearData();
        }
        else if (response.status == "400") {
            errorMessage.style.display = "block";
            successMessage.style.display = "none";
            errorMessage.innerText = "Insufficient Funds in your account to perform withdrawal"
        }

    }
    catch (err) {
        errorMessage.style.display = "block";
        errorMessage.innerText = "Server is facing issues. Try again later"
    }
}
function clearData(){
    amount.value = " ";
}

