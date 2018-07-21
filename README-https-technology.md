### https
+ 当用信用卡进行网上支付而键入信用卡密码时，就需要使用安全的浏览器，这时`HTTP`就调用`SSL/TLS`对整个网页进行`加密`，这时网页上会提示用户，在网址栏原来显示`http`的地方，现在显示`https`，`s表示security`，表明现在使用的是`提供安全服务的HTTP协议`；
#### https协议
+ `https协议并不是一个单独的协议，而是对工作在加密连接(SSL/TLS)上的常规HTTP协议，通过在TCP和HTTP之间加入TLS来加密`；`在TCP层与http层之间加入了SSL/TLS来为上层的安全保驾护航，主要用到的是对称加密，非对称加密，证书，等技术进行客户端与服务器端的数据加密传输，最终达到保证整个通信的安全性`；
#### SSL/TLS协议
+ `SSL协议是一种安全传输协议，TLS是SSL 3.0v的升级版`；

![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-220.jpg)   pic-220.jpg
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-221.jpg)   pic-221.jpg

#### https传输速度
+ `通信慢`；`SSL必须进行加密处理`；
#### TLS/SSL握手
#### 密码学原理
+ `对称加密`：`加密数据用的密钥，跟解密数据用的密钥是一样的，加密解密效率高，数据的发送方和数据的接收方都需要协商共享同一把密钥，并且密钥不能泄漏给其他人`；`不对称加密`：`私有密钥：一方保管；共有密钥：双方共有`；
#### 数字证书
+ `数字证书就是互联网通信中标志通讯各方身份信息的一串数字，同时就是一个文件`；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-222.jpg)   pic-222.jpg
