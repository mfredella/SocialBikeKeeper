<?php

include ('db_conn.php');

$sfidante=$_GET['sfidante'];
$sfidato=$_GET['sfidato'];

$q=mysql_query("SELECT km_sfidante, km_sfidato FROM challenge_result WHERE sfidante='$sfidante' AND sfidato='$sfidato'");
$p=mysql_fetch_assoc($q);
$json=json_encode($p['km_sfidante']);
if($json=="null"){
 echo "vuoto";
}else{
$a=mysql_query("SELECT km_sfidante, km_sfidato FROM challenge_result WHERE sfidante='$sfidante' AND sfidato='$sfidato'");
while($resrow = mysql_fetch_array($a)){
	$km_sfidante=$resrow[0];
    $km_sfidato=$resrow[1];
    $result=$km_sfidante."*".$km_sfidato."_";
    
    echo	$output[]= $result;
}
}
mysql_close();


?>