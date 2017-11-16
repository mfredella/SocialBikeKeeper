<?php
include ('db_conn.php');
$sfidante=$_GET['sfidante'];
$sfidato=$_GET['sfidato'];
$stato=$_GET['stato'];
$resutl=mysql_query("UPDATE my_socialbikeeper.challenges SET stato='$stato' WHERE sfidante='$sfidante' AND sfidato='$sfidato'");

mysql_close();
?>