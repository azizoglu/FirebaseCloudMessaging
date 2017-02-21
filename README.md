# Firebase Push Notification
This is Firebase+PHP demo app for push notification all tokens registered devices.
http://www.gokhanazizoglu.com/firebase-push-notification/

# Usage
You need to change some of the information and put yourself in place of the following.

* Database informations in `db_config.php`
* Table name in `registerToken.php`
* Server key  `'Authorization:key=your server key'`. You can find server key in firebase console
* Change `google.json` file with yours
* "NOTIF_URL" in [MainActivity.class](https://github.com/azizoglu/FirebasePushNotification/blob/master/app/src/main/java/azizoglu/firebasepushnotification/MainActivity.java)
* "REGISTER_URL" in [MyFirebaseInstanceIDService.class](https://github.com/azizoglu/FirebasePushNotification/blob/master/app/src/main/java/azizoglu/firebasepushnotification/MyFirebaseInstanceIDService.java)

# Screens

![FCM1](https://github.com/azizoglu/FirebaseCloudMessaging/blob/master/Screen/fcm1.png) ![FCM2](https://github.com/azizoglu/FirebaseCloudMessaging/blob/master/Screen/fcm2.png) 
