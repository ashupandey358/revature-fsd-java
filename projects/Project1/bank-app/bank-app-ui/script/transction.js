const urlParams = new URLSearchParams(window.location.search);
const currentAccountId = urlParams.get('id');
let tabled = document.getElementById("transactionTable");
console.log(currentAccountId);

async function showTransactions(){
    let transaction ={
        accountId : currentAccountId
    };
    let response = await fetch(`http://localhost:8080/bank-app-rest/transctions/${currentAccountId}`);
    let transactions = await response.json();
    if(transactions.length != 0){
    let element = "";
    for (var tran of transactions) {
            element += `<tr>
            <td>${currentAccountId}</td>
            <td>${tran.transctionType}</td>
            <td>${tran.amount}</td>
          </tr>`
        }
    document.getElementById("cust").innerHTML = element;
    console.log(element);}
    else{
        document.getElementById("noTransactions").innerText = "No transactions to see";
       tabled.style.display = "none";
    }
 }
 showTransactions();