<?php

include ('db_conn.php');
$email=$_GET['email'];
$pass=$_GET['password'];
$q=mysql_query("SELECT email  FROM users WHERE email='$email' and password='$pass' ");
$resrow = mysql_fetch_assoc($q);
$json=json_encode($resrow['email']);
if($json=="null")

{
echo $output[]="non trovato";

} 
else
{
echo $output[]="trovato";


} 

mysql_close();


?>
