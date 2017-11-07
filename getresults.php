<?php

include ('db_conn.php');

$email=$_GET['email'];

$q=mysql_query("SELECT data,calorie,km,tempo FROM results WHERE email='$email'");

while($resrow = mysql_fetch_array($q)){
	$data=$resrow[0];
    $calorie=$resrow[1];
    $km= $resrow[2];
    $tempo= $resrow[3];
    $result=$data."*".$calorie."*".$km."*".$tempo."_";
    
    echo	$output[]= $result;
}

mysql_close();


?>