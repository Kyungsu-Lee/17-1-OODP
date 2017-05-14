<?php
	$fp = fopen("http://119.202.36.218/applet/hotel","r"); 
	$fr = fread($fp, filesize("../hotel")); 
	fclose($fp); 
	echo $fr;
?>
