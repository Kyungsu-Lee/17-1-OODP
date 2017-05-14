<?php
	$fp = fopen("http://119.202.36.218/applet/data/basket","r"); 
	$fr = fread($fp, filesize("../data/basket")); 
	fclose($fp); 
	echo $fr;
?>
