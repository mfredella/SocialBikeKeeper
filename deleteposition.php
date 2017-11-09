<?php

include ('db_conn.php');

$email=$_GET['email'];

mysql_query("DELETE FROM positions WHERE email='$email'");

mysql_close();


?>