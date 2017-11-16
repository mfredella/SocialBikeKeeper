<?php

include ('db_conn.php');

$email= $_GET['email'];
$q=mysql_query("SELECT * FROM challenges WHERE sfidante='$email' OR sfidato='$email'");

$resrow=mysql_fetch_array($q);
$id=$resrow[0];  
$sfidante= $resrow[1];
$sfidato= $resrow[2];
$durata= $resrow[3];
$stato= $resrow[4];    
$challenge=$id."*".$sfidante."*".$sfidato."*".$durata."*".$stato;
/*echo $output[]= $challenge; */	

if($challenge=="****")
	echo "inesistente";
else
	echo $challenge;
mysql_close();

?>
