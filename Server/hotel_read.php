<?php
	$fp = fopen("http://119.202.36.218/applet/data/hotel","r"); 
	$fr = fread($fp, filesize("../data/hotel")); 
	fclose($fp); 
	echo $fr;
?>
