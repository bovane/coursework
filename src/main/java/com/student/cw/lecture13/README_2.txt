
SERVER SIDE:

 keytool -genkey -keystore serverkeys -keyalg rsa -alias markw

enter details and select pwd_1


 keytool -export -keystore serverkeys -alias markw -file server.cert

enter pwd_1


 cp server.cert to client location


run server

 java -Djavax.net.ssl.keyStore=serverkeys -Djavax.net.ssl.keyStorePassword=#pwd_1 EchoServer


CLIENT SIDE:

 keytool -import -keystore trustedcerts -alias markw -file server.cert

enter pwd_2 (diff to pwd_1)


run client

 java -Djavax.net.ssl.trustStore=trustedcerts -Djavax.net.ssl.trustStorePassword=#pwd_2 EchoClient

