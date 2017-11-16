<?php

include ('db_conn.php');

$sfidante=$_GET['sfidante'];
$sfidato=$_GET['sfidato'];

mysql_query("DELETE FROM challenge_result WHERE sfidante='$sfidante' AND sfidato='$sfidato'");

mysql_close();


?>