<?php
include ('db_conn.php');

$result=mysql_query("SELECT MAX(id) FROM challenges"); 
$row=mysql_fetch_array($result);
$id=$row[0]+1;

$sfidante=$_GET['sfidante'];
$sfidato=$_GET['sfidato'];
$durata=$_GET['durata'];
$stato=$_GET['stato'];

mysql_query("INSERT INTO my_socialbikeeper.challenges VALUES ('$id','$sfidante', '$sfidato','$durata','$stato')");
echo $id;

mysql_close();

?>