<?php  
 
$name = $_POST['name'];
$location = $_POST['location'];
$price = $_POST['price'];
$number = $_POST['number'];
$url = $_POST['url'];

$log_txt = $name."\t".$location."\t".$number."\t".$price."\t".$url;  
$log_dir = "/var/www/html/applet/data";   
$log_file = fopen($log_dir."hotel", "a");  
fwrite($log_file, $log_txt."\n");  
fclose($log_file);  

?> 
