async function getAccounts() {
    try {
        
        let response = await fetch(`http://localhost:8080/bank-app-rest/accounts/`);
        let accounts = await response.json();
        console.log("Method Executed");
        console.log(accounts);
        let element = "";
        for (var account of accounts) {
            element += ` <div class="col-sm-4">
        <div class="card text-white bg-dark mb-4" style="max-width: 35rem;">
        <div class="card-header"><h4>Account Detail</div>
        <div class="card-body">
          <p class="card-text">Account number : ${account.accountNo}</p>
          <p class="card-text">Account Type : ${account.accountType}</p>
          <p class="card-text">Balance : ${account.balance}</p>
        </div>
        <div class="card-footer"><a href="10-deposit.html?id=${account.accountNo}" class="btn btn-primary mr-auto mb-3">Deposit</a>
        <a href="11-withdraw.html?id=${account.accountNo}" class="btn btn-primary mr-auto mb-3">Withdraw</a>
        <a href="transactions.html?id=${account.accountNo}" class="btn btn-primary mr-auto mb-3">Transactions</a></div>
      </div>
        </div>
        </div>` }
        document.getElementById("accountlist").innerHTML = element;
        }
    catch (err) {
        console.log("error");
    }
}
getAccounts();