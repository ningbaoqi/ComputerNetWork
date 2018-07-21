### 信道复用技术
#### 频分复用、时分复用和统计时分复用
+ `频分复用`：用户在分配到一定的频带后，在通信过程中始终都占用这个频带，可见频分复用的所有用户在相同的时间占用不同的带宽资源；`时分复用`：是将时间划分为一段段等长的`时分复用帧(TDM帧)`，时分复用的所有用户是在不同的时间占用同样的频带宽度；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-2.jpg)   pic-2.jpg
+ `统计时分复用STDM`：是一种改进的时分复用，它能明显的提高信道的利用率；`集中器`常使用这种统计时分复用；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-3.jpg)   pic-3.jpg
+ `统计时分复用`又称为`异步时分复用`，而普通的时分复用称为`同步时分复用`；`TDM帧`和`STDM帧`都是在物理层传送的比特流中所划分的帧，这种帧和数据链路层的`帧`是不同的概念；

#### 波分复用
+ `波分复用WDM`就是`光的频分复用`；
#### 码分复用
+ `码分复用CDM`是另一个共享信道的方法，也称为`码分多址CDMA`每一个用户可以在同样的时间使用同样的频带进行通信，由于各用户使用经过特殊挑选的不同码型，因此各用户之间不会造成干扰；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-4.jpg)   pic-4.jpg
