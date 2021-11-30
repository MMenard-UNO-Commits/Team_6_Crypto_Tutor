
<html>
<body>
<style>
</style>
<h2>Submit Question</h2>
<form action="/server/api">
    <fieldset>
        <legend>Enter your Question:</legend>
        <label for="studName">Student Name:</label><br>
        <input type="text" id="studName" name="studName"><br>
        <label for="studID">Student ID:</label><br>
        <input type="text" id="studID" name="studID"><br>
        <label for="question">Question:</label><br>
        <textarea name="question" rows="10" cols="30"></textarea><br>
        <label for="code">Description:</label><br>
        <textarea name="code" rows="20" cols="30" id="code"></textarea><br>
        <input type="submit" value="Submit">
    </fieldset>
</form>
</body>
</html>
