# WebSocket
> WebSocket是一种在单个TCP连接上进行全双工通信的协议。

为什么要用websocket协议？
因为https协议有一个缺陷：通信只能由客户端发起。

# BUG
> 问题描述：websocket在传输JAVA对象的时候将对象转换成websocket可传输的形式，所以在服务器端需要配置编码器和解码器
1. session.getBasicRemote().sendObject("already connect"); 会出现异常 javax.websocket.EncodeException: 没有为类 [class java.lang.String] 
2. session.getBasicRemote().sendBinary(ByteBuffer.wrap("already connect".getBytes()));与session.getBasicRemote().sendText("already connect");正常
> 解决办法：
1. 分别实现编码器和解码器，例：
```
    public class MessageVOEncoder implements Encoder.Text<Object>{}
    public class MessageVODecoder implements Decoder.Text<Object>{}
```
2. 在服务端指定编码器和解码器，例：
```
    @ServerEndpoint(value = "/chart/{useId}",encoders = {MessageVOEncoder.class},decoders = {MessageVODecoder.class})
    public class ChartWebSocket {}
```


