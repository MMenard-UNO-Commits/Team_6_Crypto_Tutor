<?php
$host = "104.131.172.9"; 
$user = "cpack"; 
$password = "ctutoR123!"; 
$dbname = "ctutordb"; 
#$dbhandle = mysqli_connect($host, $user, $password)  
//$id = '';

echo "<script>console.log('Debug: " . $user . "');</script>";

$conn = mysqli_connect($host, $user, $password, $dbname);

#$method = $_SERVER['REQUEST_METHOD'];
#$request = explode('/', trim($_SERVER['PATH_INFO'],'/'));

if(!$conn) {
    die("Connection failed: " . mysqli_connect_error());
} 
$result = mysqli_query($conn, "SELECT requestId  FROM Requests");
while ($row = $result->fetch_assoc()) {
    // to print all columns automatically:
    foreach ($row as $value) {
        echo "<td>$value</td>\r\n";
        // OR to print each column separately:
        //echo "<td>",$row['Field'],"</td><td>",$row['Type'],"</td>\n";
    }
}
   
   mysqli_close($conn);

?>