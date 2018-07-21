### 用户数据报协议UDP

|UDP的主要特点|
|------|
|UDP是无连接的|
|UDP使用最大努力交付，即不保证可靠交付|
|UDP是面向报文的，发送方的UDP对应用程序交下来的报文，在添加首部后就向下交付IP层，UDP对应用层交下来的报文，既不合并，也不拆分，而是保留这些报文的边界，也就是说，应用层交给UDP多长的报文，UDP就照样发送，即一次发送一个报文|
|UDP没有阻塞控制，因此网络出现的阻塞不会使源主机的发送速率降低，这对某些实时应用是很重要的|
|UDP支持一对一，一对多，多对一，多对多的交互通信|
|UDP的首部开销小，只有8个字节，比TCP的20个字节的首部要短|

![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-110.jpg)   pic-110.jpg
### UDP的首部格式
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-111.jpg)   pic-111.jpg
