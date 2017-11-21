<?php
include ('db_conn.php');
$nome=$_GET['nome'];
$cognome=$_GET['cognome'];
$email=$_GET['email'];
$password=$_GET['password'];
$q=mysql_query("SELECT email  FROM users WHERE email='$email' ");
$resrow = mysql_fetch_assoc($q);
$json=json_encode($resrow['email']);
if($json=="null")
{
echo $output[]="Registrazione avvenuta";
$resutl=mysql_query("INSERT INTO my_socialbikeeper.users VALUES ('$email', '$nome', '$cognome', '$password')");
} 
else
{
echo $output[]="Utente esistente";
} 

mysql_close();


?>