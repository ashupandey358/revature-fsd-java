let signin = document.getElementById("sumbit");
let id = document.getElementById("ID");
let firstName = document.getElementById("firstname");
let lastName = document.getElementById("lastname");
let email = document.getElementById("emailid");
let password = document.getElementById("password");
signin.addEventListener("click", create);
async function create() {
    url = "http://localhost:8080/bank-app-rest/customers"
    let data = {
        id:document.getElementById("ID"),
        firstName:document.getElementById("firstname"),
        lastName:document.getElementById("lastname"),
        email:document.getElementById("emailid"),
        password:document.getElementById("password"),
    }
    fetch(url, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type':"application/json"},

        
        
    })
}