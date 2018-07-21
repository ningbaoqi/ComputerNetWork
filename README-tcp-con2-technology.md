### TCP的流量控制
#### 利用滑动窗口实现流量控制
+ `流量控制就是让发送方的发送速率不要太快，要让接收方来得及接收`；`发送方的发送窗口不能超过接收方给出的接收窗口的数值`，`TCP的窗口单位是字节，不是报文段`；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-100.jpg)   pic-100.jpg
