<?php
	$fp = fopen("http://119.202.36.218/applet/data/message","r"); 
	$fr = fread($fp, filesize("../data/message")); 
	fclose($fp); 
	echo $fr;
?>
