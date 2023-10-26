<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Number System Converter</title>
<style>
   
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
    }
    
    .convert-bg {
        background-color: #f2f2f2;
    }
    .convert-container {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }
    .title {
        text-align: center;
        color: #333;
    }
    
    .title1 {
        text-align: center;
        color: red;
    }
    
    .form-group {
        margin-bottom: 15px;
    }
    .label {
        display: block;
        font-weight: bold;
        color: #333;
    }
    .form-control {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }
  
    .btn {
        display: block;
        width: 100%;
        padding: 10px;
        background-color: Red;
        color: #fff;
        border: none;
        border-radius: 3px;
        cursor: pointer;
    }
    .btn:hover {
        background-color: Yellow;
        color: black;
    }
</style>
</head>
<body class="convert-bg">
    <div class="container convert-container">
        <h1 class="title">Number System Converter</h1>
        <p class="title1">Select Number System and Enter two numbers to add</p>
        <form action="NumberSystemConverterServlet" method="post">
            <div class="form-group">
                <label for="system" class="label">Number System:</label>
                <select id="system" name="system" class="form-control">
                    <option value="dec">Decimal</option>
                    <option value="hex">Hexadecimal</option>
                    <option value="bin">Binary</option>
                    <option value="oct">Octal</option>
                    <option value="pow2">hecto</option>
                    <option value="pow6">mega</option>
                    <option value="pow9">giga</option>
                    <option value="pow12">tera</option>
                    <option value="pow-6">micro</option>
                    <option value="pow-9">nano</option>
                </select>
            </div>
            <div class="form-group">
                <label for="input1" class="label">Input 1:</label>
                <input type="text" id="input1" name="input1" class="form-control"><br>
            </div>
            <div class="form-group">
                <label for="input2" class="label">Input 2:</label>
                <input type="text" id="input2" name="input2" class="form-control"><br>
            </div>
            <button type="submit" class="btn btn-primary">Convert</button>
        </form>
    </div>
</body>
</html>