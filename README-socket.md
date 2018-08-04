### Socket基础
+ `Socket`是应用层与`TCP/IP`协议族通信的中间软件抽象层，它是一组接口，`Socket`用于描述`IP地址`和`端口`，是一个通信链路的句柄，应用程序通常通过套接字向网络发出请求或应答网络请求；`Socket`的基本操作包括：`连接远程机器`、`发送数据`、`接收数据`、`关闭连接`、`绑定端口`、`监听到达数据`、`在绑定的端口上接受来自远程机器的连接`；

#### 客户端 Socket

|Socket的重要方法|说明|
|------|------|
|`Socket()`|创建一个新的未连接的Socket|
|`Socket(Proxy proxy)`|使用指定的代理类型创建一个新的未连接的Socket；proxy为代理服务器地址|
|`Socket(String dstName , int dstPort)`|使用指定的目标服务器的主机名和目标服务器的端口号，创建一个新的Socket|
|`Socket(String dstName , int dstPort , InetAddress localAddress , int localPort)`|使用指定的目标主机、目标端口、本地地址和本地端口创建一个新的Socket|
|`Socket(InetAddress dstAddress , int dstPort)`|使用指定的本地地址和本地端口创建一个新的Socket|
|`Socket(InetAddress dstAddress , int dstPort , InetAddress localAddress , int localPort)`|使用指定的目标主机、目标端口、本地地址和本地端口，创建一个新的Socket|
|`public InputStream getInputStream()`|读出该Socket中的数据|
|`public OutputStream getOutputStream()`|向该Socket中写入数据|
|`public synchronized void close()`|关闭该Socket|
|`setSoTimeout(int timeout)`|设置超时时长，单位ms；为Socket对象指定了超时时长之后，如果使用Socket进行读写操作完成以前已经超出了该时间范围，那么这个方法将会抛出SocketTimeoutException异常，程序可以对该异常进行捕捉，并进行适当的处理|

