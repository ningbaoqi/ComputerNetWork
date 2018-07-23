### TCP可靠传输的实现
#### 以字节为单位的滑动窗口
+ TCP的滑动窗口是以`字节`为单位的；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-104.jpg)  

|窗口边沿|变化情况|
|------|------|
|发送窗口后沿|有两种可能；一、不动(没有收到新的确认)；二、前移(收到了新的确认)|
|发送窗口前沿|有三种可能；一、向前移动，没有收到新的确认，对方通知的窗口大小也不变；二、不动，收到了新的确认但对方通知的窗口缩小了，使得发送窗口前沿正好不动；三、向后收缩，在对方通知的窗口缩小了，但TCP的标准强烈不赞成这样做|

![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-105.jpg)  
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-106.jpg)  
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-107.jpg)
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-108.jpg)  
### 超时重传时间的选择
+ TCP采用了一种自适应算法，它记录了`一个报文段发出的时间`，以及`收到相应的确认的时间`，这两个时间之差就是`报文段的往返时间RTT`，TCP保留了RTT的一个`加权平均往返时间RTTs(又称为平滑的往返时间)`；`超时计时器`设置的`超时重传时间RTO`应该略大于上面得出的`加权平均往返时间RTTs`；
