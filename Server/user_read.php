<?php
	$fp = fopen("http://119.202.36.218/applet/data/data","r"); 
	$fr = fread($fp, filesize("../data/data")); 
	fclose($fp); 
	echo $fr;
?>
