<?php

$messageData = $_POST['messageData'];
require_once __DIR__ . '/db_connect.php';
$db = new DB_CONNECT();
$result = mysql_query("SELECT *FROM users_token") or die(mysql_error());

if (mysql_num_rows($result) > 0) {
     $tokens = array();
    while ($row = mysql_fetch_array($result)) {
        $tokens[] = $row["token"];
    }
	$message['message'] =$messageData;
	$message_status = sendNotification($tokens, $message);
	echo $message_status;
} else {
   echo "Token Not Found";
}

function sendNotification($tokens, $message){
 $url = 'https://fcm.googleapis.com/fcm/send';
 $fields = array(
 'registration_ids' =>$tokens,
 'data' => $message
 );
 $headers = array(
 'Authorization:key=your server key',
 'Content-Type: application/json'
 );
 $ch = curl_init();
 curl_setopt($ch, CURLOPT_URL, $url);
 curl_setopt($ch, CURLOPT_POST, true);
 curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
 curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
 curl_setopt ($ch, CURLOPT_SSL_VERIFYHOST, 0); 
 curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
 curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));
 $result = curl_exec($ch); 
 if ($result === FALSE) {
 die('Curl Failed: ' . curl_error($ch));
 }
 curl_close($ch);
 return $result;
 }
?>
