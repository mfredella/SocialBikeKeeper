<?php
include ('db_conn.php');
$email=$_GET['email'];
$lat=$_GET['latitudine'];
$lgt=$_GET['longitudine'];
$q=mysql_query("SELECT email  FROM positions WHERE email='$email' ");
$resrow = mysql_fetch_assoc($q);
$json=json_encode($resrow['email']);
if($json=="null")
{
$resutl=mysql_query("INSERT INTO my_socialbikeeper.positions VALUES ('$email', '$lat', '$lgt')");
} 
else
{
$resutl=mysql_query("UPDATE my_socialbikeeper.positions SET latitudine='$lat',longitudine='$lgt' WHERE email='$email'");
} 

mysql_close();


?>