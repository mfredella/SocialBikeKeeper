<?php
include ('db_conn.php');

$data=date('Y-m-d H:i:s');
$email=$_GET['email'];
$calorie=$_GET['calorie'];
$km=$_GET['km'];
$tempo=$_GET['tempo'];
mysql_query("INSERT INTO my_socialbikeeper.results VALUES (DEFAULT,'$data','$email', '$calorie', '$km', '$tempo')"); 

mysql_close();


?>