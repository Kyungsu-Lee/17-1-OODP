<?php  
 
$p1 = $_POST['name'];
$p2 = $_POST['location'];
$p3 = $_POST['num'];
$p4 = $_POST['price'];
$p5 = "032";

$log_txt = $p1."\t".$p2."\t".$p3."\t".$p4."\t".$p5;  
$log_dir = "/var/www/html/applet/data";   
$log_file = fopen($log_dir."/hotel", "a");  
fwrite($log_file, $log_txt."\n");  
fclose($log_file);  

?> 
