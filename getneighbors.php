<?php
include ('db_conn.php');
$q=mysql_query("SELECT email, latitudine, longitudine FROM positions");

while($resrow = mysql_fetch_array($q)){
	$a=$resrow[0];
    $b= $resrow[1];
    $c= $resrow[2];
    $completo=$a."*".$b."*".$c."_";
   	echo	$completo;
} 

mysql_close();


?>