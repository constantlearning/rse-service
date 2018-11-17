function login(){
	var emailInput = document.querySelectorAll('.input-email')[0];
	var passwordInput = document.querySelectorAll('.input-password')[0];
	if(!emailInput.value){
		emailInput.classList.add('invalid-input');
		alert('Campo e-mail inválido!');
		return;
	}

	if(!passwordInput.value){
		passwordInput.classList.add('invalid-input');
		alert('Campo senha inválida!');
		return;
	}

	window.location.href = 'home.html';

	fetch(API_CHECK_LOGIN, { 
	  method: 'post' 
	})
	.then(function(response) { 
	  response.text()
	  .then(function(result){ 
	     console.log(result);
	   }) 
	})
	.catch(function(err) { console.error(err); });

}