<?php
include ('db_conn.php');
$sfidante=$_GET['sfidante'];
$sfidato=$_GET['sfidato'];
$km=$_GET['km'];
$flag=$_GET['flag'];
$q=mysql_query("SELECT * FROM challenge_result WHERE sfidante='$sfidante' AND sfidato='$sfidato' ");
$resrow = mysql_fetch_assoc($q);
$json=json_encode($resrow['sfidante']);
$json1=json_encode($resrow['sfidato']);
if($json=="null" && $json1=="null" ){
	mysql_query("INSERT INTO my_socialbikeeper.challenge_result VALUES (DEFAULT,'$sfidante','$sfidato', '', '')");
}
if($flag==0){
  mysql_query("UPDATE my_socialbikeeper.challenge_result SET km_sfidante='$km' WHERE sfidante='$sfidante' AND sfidato='$sfidato'");
}
else {	
  mysql_query("UPDATE my_socialbikeeper.challenge_result SET km_sfidato='$km' WHERE sfidante='$sfidante' AND sfidato='$sfidato'");
}


mysql_close();

?>
