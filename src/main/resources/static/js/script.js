function checkInput(ele) {
	var val = ele.value;
    var id = ele.id;
    var e = document.getElementById(id);
    if (val.trim() == "") {
    	alert("You cannot keep the input box blank");
        e.value = "";
        e.style.borderBottomColor = "red";
        e.style.borderRightColor = "red";
        e.focus();
    } else {
    	e.style.borderBottomColor = "rgb(7, 6, 104)";
        e.style.borderRightColor = "rgb(7, 6, 104)";
    }
}

function checkRating(ele) {
	var val = ele.value;
	var id = ele.id;
	var e = document.getElementById(id);
	if (val.trim() != "" && !isNaN(val)) 
	{
			if(!Number.isInteger(val) && Number(val)>0 && Number(val)<=10)
			{
				e.style.borderBottomColor = "rgb(7, 6, 104)";
        		e.style.borderRightColor = "rgb(7, 6, 104)";
			}
			else
			{
				alert("Please enter a 10 digit mobile number");
        		e.value = "";
        		e.style.borderBottomColor = "red";
        		e.style.borderRightColor = "red";
        		e.focus();	
        	}	
	}else
	{
			alert("Please enter a 10 digit mobile number");
        	e.value = "";
        	e.style.borderBottomColor = "red";
        	e.style.borderRightColor = "red";
        	e.focus();	
    }
}

function checkRunTime(ele) {
	var val = ele.value;
	var id = ele.id;
	var e = document.getElementById(id);
	if (val.trim() != "" && !isNaN(val))
	{
		e.style.borderBottomColor = "rgb(7, 6, 104)";
        e.style.borderRightColor = "rgb(7, 6, 104)";	
	}else{
			alert("Please enter the run time of the movie in minutes");
        	e.value = "";
        	e.style.borderBottomColor = "red";
        	e.style.borderRightColor = "red";
        	e.focus();	
    }
}

function checkPhoneNumber(number)
{
	var val = number.value;
	var id = number.id;
	var e = document.getElementById(id);
	if (val.trim() != "" && !isNaN(val)) {
			var no = val.toString();
			var len = no.length;
			if(len===10)
			{
				e.style.borderBottomColor = "rgb(7, 6, 104)";
        		e.style.borderRightColor = "rgb(7, 6, 104)";
			}else{
				alert("Please enter a 10 digit mobile number");
        		e.value = "";
        		e.style.borderBottomColor = "red";
        		e.style.borderRightColor = "red";
        		e.focus();	
        	}	
	}else{
			alert("Please enter a 10 digit mobile number");
        	e.value = "";
        	e.style.borderBottomColor = "red";
        	e.style.borderRightColor = "red";
        	e.focus();	
    }
}

function checkYear(number)
{
	var val = number.value;
	var id = number.id;
	var e = document.getElementById(id)
	if (val.trim() != "" && !isNaN(val)) {
			var no = val.toString();
			var len = no.length;
			if(len===4)
			{
				e.style.borderBottomColor = "rgb(7, 6, 104)";
        		e.style.borderRightColor = "rgb(7, 6, 104)";
			}else{
				alert("Please enter a year(eg: 2007)");
        		e.value = "";
        		e.style.borderBottomColor = "red";
        		e.style.borderRightColor = "red";
        		e.focus();	
        	}	
	}else{
				alert("Please enter a year(eg: 2007)");
        	e.value = "";
        	e.style.borderBottomColor = "red";
        	e.style.borderRightColor = "red";
        	e.focus();	
    }
}


function validateEmail(mail) {
    var m = mail.value;
    var id = mail.id;
    var e = document.getElementById(id);
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (m.trim() != "" && m.match(mailformat)) {
        e.style.borderBottomColor = "rgb(7, 6, 104)";
        e.style.borderRightColor = "rgb(7, 6, 104)";
    } else {
        alert("You have entered an invalid email address!")
        e.value = "";
        e.style.borderBottomColor = "red";
        e.style.borderRightColor = "red";
        e.focus();
    }
}

function confirmPassword(password)
{
   var confirmPw = password.value;
   var id = password.id;
   var pw = document.getElementById("pw_signup");
   if (pw.value.trim() == "") {
      alert("First enter the password please");
      password.value = "";
      pw.focus();
   } else if (confirmPw.trim() != "" && confirmPw === pw.value) {
      password.style.borderBottomColor = "rgb(7, 6, 104)";
      password.style.borderRightColor = "rgb(7, 6, 104)";
   } else {
      alert("This password does not match with the above password");
      password.value = "";
      password.style.borderBottomColor = "red";
      password.style.borderRightColor = "red";
      password.focus();
   }
}


function checkGenre()
{
	var genres = document.getElementsByName("genre");
	var count = 0;
	for(let i=0;i<genres.length;i++)
	{
		if(genres[i].checked)
		{
			count = count + 1;
		}
	}
	if(count==0)
	{
		alert("Check One or more Genres of the movie");
		return false;
	}
	return true;
}

function showSearch(){
	document.getElementById('searchItems').style.display = 'grid';
}
    