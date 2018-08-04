### [使用UDP通信](https://github.com/ningbaoqi/ComputerNetWork/commit/cafc64721772c1febaa89ddbebebf4c02d07350a)

image1

#### DatagramSocket

|DatagramSocket函数|说明|
|------|------|
|DatagramSocket()|创建一个数据包套接字|
|DatagramSocket(int port)|创建一个数据包套接字，并绑定到指定端口上|
|receive()|接受UDP包|
|send()|发送UDP数据包|
|close()|关闭数据包套接字|

#### DatagramPacket

|DatagramPacket|说明|
|------|------|
|DatagramPacket(byte[] buf , int length)|创建一个字节数组以接收UDP包|
|DatagramPacket(byte[] buf , int offset , int length , InetAddress address , int port)|建立要发送的UDP数据包|
