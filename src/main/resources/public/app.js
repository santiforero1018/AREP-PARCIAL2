app = (() => {

    function getFactors() {
        let number = document.getElementById("value").value;
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            document.getElementById("getrespmsg").innerHTML =
                this.responseText;
        }
        xhttp.open("GET", "/factors?value=" + number);
        xhttp.send();
    }

    function getPrimes(){
        let number = document.getElementById("value").value;
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            document.getElementById("getrespmsg").innerHTML =
                this.responseText;
        }
        xhttp.open("GET", "/primes?value=" + number);
        xhttp.send();
    }

    return {
        getFactors,
        getPrimes
    }
}
)();