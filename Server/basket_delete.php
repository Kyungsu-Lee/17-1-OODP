<?php  

$p1 = $_POST['id'];
$p2 = $_POST['hotel_name'];
$p3 = $_POST['date'];
$p4 = $_POST['number'];

$fp = fopen("http://119.202.36.218/applet/data/basket","r"); 
$fr = fread($fp, filesize("../data/basket")); 
fclose($fp); 

$log_txt = $p1."\t".$p2."\t".$p3."\t".$p4;
echo $log_txt;
$fr = Str_replace($log_txt."\n", "", $fr);
$log_dir = "/var/www/html/applet/data";   
$log_file = fopen($log_dir."/basket", "w");  
fwrite($log_file, $fr);  
fclose($log_file);  

?> 

<html>
<head></head>

<body>

	</form>

        </fieldset>

        <fieldset>

            <legend>

                POST

            </legend>

            <form action="./basket_delete.php" method="POST">//'./':URL 전체 주소의 현재 폴더까지(상대경로)/example2.php

                <p>

                    닉네임 :

                    <input type="text" name="id" />
                    <input type="text" name="hotel_name" />
                    <input type="text" name="date" />
                    <input type="text" name="number" />

                    <br />

                </p>


                <input type="submit" value="전송"/>

            </form>
</body>
</html>
