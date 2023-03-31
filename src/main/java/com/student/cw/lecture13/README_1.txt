Certificate

First we need to make certificate, this is done by using keytool that is part of J2SE SDK (program will ask for certificate owner information and password, enter 123456 as password, or you can enter your password, but notice that you have to change it in other commands listen in this tutorial):

keytool -genkey -keystore mySrvKeystore -keyalg RSA

After this command you will have certificate file in working directory of issuing keytool command. 

Running server and client using SSL

First copy certificate file that you created before into working directory and run server with these parameters (notice that you have to change keyStore name and/or trustStrorePassword if you specified different options creating certificate:

java -Djavax.net.ssl.keyStore=mySrvKeystore -Djavax.net.ssl.keyStorePassword=123456 EchoServer

And now again copy certificate file that you created before into working directory and run client with these parameters (notice that you have to change keyStore name and/or trustStrorePassword if you specified different options creating certificate:

java -Djavax.net.ssl.trustStore=mySrvKeystore -Djavax.net.ssl.trustStorePassword=123456 EchoClient
