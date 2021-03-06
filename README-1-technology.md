### 可靠传输的工作原理
#### 停止等待协议
+ `停止等待`就是每发送完一个分组就停止发送，等待对方的确认，在收到确认后再发送下一个分组；
#### 无差错情况
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-80.jpg) 
#### 出现差错
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-81.jpg) 
+ A发送完一个分组后，`必须暂时保留已发送的分组的副本`(为发生超时重传时使用)，只有在收到相应的确认后才能清除暂时保留的分组副本；
#### 确认丢失和确认迟到
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-82.jpg) 
+ 使用上述的确认和重传机制，我们就可以`在不可靠的传输网络上实现可靠的通信`；停止等待协议的优点是简单，但缺点是`信道利用率太低`；
### 连续ARQ协议
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-83.jpg) 
+ `发送窗口`的意义是：位于`发送窗口`内的`5个分组`都可连续发送出去，而不需要等待对方的确认，`连续ARQ协议`规定，发送放每收到一个确认，就把`发送窗口`向前滑动一个分组的位置，接收方一般都是采用`累积确认`的方式，就是说，接收方不必对收到的分组逐个发送确认，而是在收到几个分组后，`对按序到达的最后一个分组发送确认`，这就表示，到这个分组为止的所有分组都已正确收到了；
