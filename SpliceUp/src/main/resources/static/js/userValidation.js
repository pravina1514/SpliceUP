$(document).ready(function(){
$("#alertSuccess").hide();
	$("#errid").hide();
	$("#errname").hide();
	$("#erremail").hide();  //Initially hiding the error spans
	$("#errpass").hide();

	$("#Rbtn").click(function() {
		
		var username=$("#name").val();
		var password=$("#password").val(); //triggers on click of register
		var email=$("#email").val();
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		 var letters = /^[A-Za-z]+$/;

	
		 if(username==null || username==""){
			alert("UserName cannot be Empty");
			return false;
		}else if(password=="" || password==null){
			alert("Password cannot be Empty");
			return false;
			
		}else if(email=="" || email==null){
			
			alert("Email cannot be Empty");
			return false;
		}else if(isNaN(userid)){
			
			alert("User ID should contain Only Digits");
			return false;
		}else if(!(email.match(mailformat))){
			alert("Please Enter Valid Mail ID");

		return false;
		}else if(!(username.match(letters))){
			alert("Pleas Enter only Characters for Username");
			return false;
		}else{
			$("#alertSuccess").show();
			$("#formid").submit();
			return true;
		}
		
		});

	
	$("#username").change(function(){
		var username=$("#username").val();    //here we are restricting the user at the time of typing,we called an event "Keyup"
		 var letters = /^[A-Za-z]+$/;

		 if(!(username.match(letters))){
			 $("#errname").show();               //if user enters other than number then the error span will be shown

			 return false;
			}else{
				$("#errname").hide();
				return true;
			}
		
	});
	$("#email").change(function(){
		var email=$("#email").val();

		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(!(email.match(mailformat))){
			 $("#erremail").show();


		return false;
		}else{
			 $("#erremail").hide();
		return true;
			
			
		}
		
	});
	
	$("#cpassword").change(function(){
		var password=$("#password").val();
		var cpassword=$("#cpassword").val();
		if(!(password==cpassword)){
			 $("#errpass").show();
			return false;	
			
		}else{
			 $("#errpass").hide();

			return true;
		}		
	});	
});





//new code for validation


$(function() {
	  // Initialize form validation on the registration form.
	  // It has the name attribute "registration"
	  $("form[name='registration']").validate({
	    // Specify validation rules
	    rules: {
	      // The key name on the left side is the name attribute
	      // of an input field. Validation rules are defined
	      // on the right side
	      firstname: "required",
	      lastname: "required",
	      email: {
	        required: true,
	        // Specify that email should be validated
	        // by the built-in "email" rule
	        email: true
	      },
	      password: {
	        required: true,
	        minlength: 5
	      }
	    },
	    // Specify validation error messages
	    messages: {
	      firstname: "Please enter your firstname",
	      lastname: "Please enter your lastname",
	      password: {
	        required: "Please provide a password",
	        minlength: "Your password must be at least 5 characters long"
	      },
	      email: "Please enter a valid email address"
	    },
	    // Make sure the form is submitted to the destination defined
	    // in the "action" attribute of the form when valid
	    submitHandler: function(form) {
	      form.submit();
	    }
	  });
	});