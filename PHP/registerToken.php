<?php

$response = array();

if (isset($_POST['token'])) {
    
    $token = $_POST['token'];
    require_once __DIR__ . '/db_connect.php';
    $db = new DB_CONNECT();
    $result = mysql_query("INSERT INTO users_token(token) VALUES('$token')");

    if ($result) {
        $response["success"] = 1;
        $response["message"] = "Token successfully inserted.";

        echo json_encode($response);
    } else {
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";
        
        echo json_encode($response);
    }
} else {
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    echo json_encode($response);
}
?>