<!DOCTYPE html>
<html lang="ru"> <!-- Указание языка страницы -->
<head>
    <title>Welcome to the MVC Application</title>
    <meta charset="UTF-8"> <!-- Убедитесь, что это указано -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        .button-container {
            margin-top: 20px;
        }
        .button {
            background-color: #4CAF50; /* Зеленый цвет */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #45a049; /* Темно-зеленый цвет при наведении */
        }
    </style>
</head>
<body>
<div>
    <h1>Welcome MVC Application</h1>
</div>
<div class="button-container">
    <form action="TodoServlet" method="get">
        <input type="submit" class="button" value="come to list">
    </form>
    <form action="MathServlet2" method="get">
        <input type="submit" class="button" value="come to math">
    </form>
    <h1>Enter two number:</h1>
    <form method="GET" action="MathServlet3">
        number 1: <input type="text" name="number1"><br>
        number 2: <input type="text" name="number2"><br>
        <input type="submit" value="+">
    </form>
</div>
</body>
</html>