<?php

include ('db_conn.php');

$sfidante=$_GET['sfidante'];
$sfidato=$_GET['sfidato'];
$q=mysql_query("SELECT durata  FROM challenges WHERE sfidante='$sfidante' and sfidato='$sfidato' ");
$resrow = mysql_fetch_array($q);
echo $output = $resrow[0];


mysql_close();


?>