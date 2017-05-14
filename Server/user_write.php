<?php  
 
$p1 = $_POST['id'];
$p2 = $_POST['pwd'];
$p3 = $_POST['name'];
$p4 = $_POST['age'];

$log_txt = $p1."\t".$p2."\t".$p3."\t".$p4;  
$log_dir = "/var/www/html/applet/data";   
$log_file = fopen($log_dir."/data", "a");  
fwrite($log_file, $log_txt."\n");  
fclose($log_file);  

?> 
