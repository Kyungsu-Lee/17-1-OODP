<?php  
 
$p1 = $_POST['from'];
$p2 = $_POST['to'];
$p3 = $_POST['message'];

$log_txt = $p1."::::".$p2."::::".$p3;  
$log_dir = "/var/www/html/applet/data";   
$log_file = fopen($log_dir."/message", "a");  
fwrite($log_file, $log_txt."\n");  
fclose($log_file);  

echo $log_txt;

?> 
