
通过localhost:18991/sayhello可以进行消息发送，
参数：
msg=要发送的消息
sender=发送消息给谁，（1:Queue1，2:Queue2，3:广播）
exchange=使用exchange模式吗？该模式下sender参数无效。该参数可缺省，默认false（true:使用，false:不使用）
routing=exchange模式下的路由，可缺省，但消息将会丢失。（Queue1：发送给Queue1，Queue2：发送给Queue2，test.*：发送给Queue1）注：*可以匹配任何字符串
