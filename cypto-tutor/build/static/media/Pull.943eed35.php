<?php
$host = "104.131.172.9"; 
$user = "cpack"; 
$password = "ctutoR123!"; 
$dbname = "ctutordb"; 
$id = '';

echo "<script>console.log('Debug: " . $user . "');</script>";

$con = mysqli_connect($host, $user, $password, $dbname);

$method = $_SERVER['REQUEST_METHOD'];
$request = explode('/', trim($_SERVER['PATH_INFO'],'/'));

if(!$con) {
    die("Connection failed: " . mysqli_connect_error());
} else {
    echo "we got em!";
}

?>