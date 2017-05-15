<?php
$url = 'http://119.202.36.218/applet/Server/basket_delete.php'; //호출 URL 지정
$post_data["id"] = "param1값";
$post_data["hotel_name"] = "param2값";
$post_data["date"] = "param2값";
$post_data["number"] = "param2값";
 
$curlsession = curl_init ();
curl_setopt ($curlsession, CURLOPT_URL, $url);
curl_setopt ($curlsession, CURLOPT_POST, 1);
curl_setopt ($curlsession, CURLOPT_POSTFIELDS, $post_data);
curl_setopt ($curlsession, CURLOPT_POSTFIELDSIZE, 0);
curl_setopt ($curlsession, CURLOPT_RETURNTRANSFER, 1);
$res = curl_exec ($curlsession);
  
var_dump($res); //결과값 출력
print_r(curl_getinfo($curlsession)); //모든정보 출력
echo curl_errno($curlsession); //에러정보 출력
echo curl_error($curlsession); //에러정보 출력
 
curl_close($curlsession);
?>
