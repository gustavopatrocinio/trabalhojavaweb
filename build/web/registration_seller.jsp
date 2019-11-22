
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Seller</title>
    </head>
    <body>
        <form action="execute_registration_seller.jsp" method="post">
            <label>Name:</label><br>
            <input type="text" name="name_seller"/><br>
            <label>Email:</label><br>
            <input type="text" name="email_seller"/><br>
            <label>Password:</label><br>
            <input type="password" name="password_seller"/><br><br>
            <label>BirthDate:</label><br>
            <input type="datetime" name="birthdate_seller"/><br><br>
            <label>Base Salary:</label><br>
            <input type="number" name="basesalary_seller"/><br><br>

            <label>Department:</label>
            <select name="department_seller">
                <option>Books</option>
                <option>Computers</option>
                <option>Eletronics</option>
                <option>Fashion</option>
                <option>Musics</option>
                <option>Toys</option>
            </select>
            <br/><br/>

            <button type="submit">Register</button>



        </form>
    </body>
</html>