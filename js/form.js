window.onload = inizializza;

function inizializza() {
	document.getElementById("bottone").onclick = controlla;
}



function controlla() {
	var email = document.getElementById("email").value;
	var tipoS= document.getElementsByName("cesto");
	console.log(tipoS[0].checked);
	console.log(tipoS[1].checked);
	console.log(tipoS[2].checked);
    console.log(tipoS[3].checked);
    if (document.getElementById("nome").value.length < 3) {
		document.getElementById("nome").setCustomValidity("Il campo non può essere vuoto!");
	}
	else {
		document.getElementById("nome").setCustomValidity("");
	}
	if (document.getElementById("cognome").value.length < 3) {
		document.getElementById("cognome").setCustomValidity("Il campo non può essere vuoto!");
	}
	else {
		document.getElementById("cognome").setCustomValidity("");
	}
	if (!validaEmail(email)) {
		document.getElementById("email").setCustomValidity("Email errata");
	}
	else {
		document.getElementById("email").setCustomValidity("");
	}
    if (document.getElementById("citta").value.length < 3) {
		document.getElementById("citta").setCustomValidity("Il campo non può essere vuoto!");
	}
	else {
		document.getElementById("citta").setCustomValidity("");
	}
    if (document.getElementById("provincia").value.length < 2) {
		document.getElementById("provincia").setCustomValidity("Il campo non può essere vuoto!");
	}
	else {
		document.getElementById("provincia").setCustomValidity("");
	}
    if (document.getElementById("indirizzo").value.length < 3) {
		document.getElementById("indirizzo").setCustomValidity("Il campo non può essere vuoto!");
	}
	else {
		document.getElementById("indirizzo").setCustomValidity("");
	}
    if (document.getElementById("cap").value.length != 5) {
		document.getElementById("cap").setCustomValidity("Il CAP deve essere composto da 5 numeri");
	}
	else {
		document.getElementById("cap").setCustomValidity("");
	}
	
	
	if(tipoS[0].checked===false && tipoS[1].checked===false && tipoS[2].checked===false && tipoS[3].checked===false){
		document.getElementById("cesto1").setCustomValidity("Seleziona il tuo cesto");
	}
	else{
		document.getElementById("cesto1").setCustomValidity("");
	}
	
	

}


function validaEmail(email) {
	var regex = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$/;
	return regex.test(email);
}
