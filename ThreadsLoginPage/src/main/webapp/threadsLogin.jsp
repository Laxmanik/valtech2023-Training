<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="bg-top bg-contain bg-no-repeat bg-center pb-8 " style="background-image: url('threadsbackground.png');">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login page</title>
<link rel="stylesheet" href="style.css">
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="min-h-full">
		<div class="flex h-screen">
			<div class="max-w-sm  w-full m-auto mt-52">
				<header>
					<h3 class="text-center mb-4 font-bold">Log in with
						your Instagram account</h3>
					<h4>
					</h4>
				</header>
				<form action="threadsLogin" method="post">
					<div>
						<input
							class="w-full p-4 mb-2 outline-none border-0 bg-input outline-custom"
							name="name" type="text" id="name" id="floatingInput"
							placeholder="Username, phone or email" />
					</div>
					<div>
						<input
							class="w-full p-4 mb-2 outline-none border-0 bg-input outline-custom"
							name="pass" type="password" id="floatingPassword" id="password"
							placeholder="Password" />
					</div>
					<div>
						<button
							class="w-full text-base p-4 mb-2 button-input bg-black submit"
							type="submit">Log in</button>
					</div>
				</form>
				<div class="text-center">
					<a class="text-sm link-color" href="#">Forgot Password?</a> <br>
					<br>
					<p class="line">
						<span>or</span>
					</p>
					<div  class=" flex w-full p-5 mt-8 button-input continue ">
					 <img class="w-12 mr-4" src="Instagram_icon.png" />
					<button class="mx-6 font-bold text-black " href="https://www.instagram.com/accounts/login/">Continue with Instagram</button>
						<span class="mt-2 ml-7 text-2xl font-thin arrow">></span>
						</div>
						<footer class="text-center "> <a class="text-xs link-color" href="#"> � 2023 </a>
			<a class="text-xs link-color px-1" href="#"> Threads Terms </a>
			<a class="text-xs link-color px-1" href="#"> Privacy Policy </a>
			<a class="text-xs link-color px-1" href="#"> Cookies Policy </a>
			<a class="text-xs link-color px-1" href="#">Report a problem</a> 
			</footer>
				</div>
				 
				
			</div>
			
			<button class="qrbutton"  style="background-image: url('qr.png');"></button>
		</div>
</body>
</html>