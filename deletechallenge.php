<?php

include ('db_conn.php');

$id=$_GET['id'];

mysql_query("DELETE FROM challenges WHERE id='$id'");

mysql_close();


?>