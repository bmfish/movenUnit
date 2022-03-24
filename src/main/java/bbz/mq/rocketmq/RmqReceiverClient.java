/*
 * FileName: RmqReceiverClient.java
 * Author:   bm
 * Date:     2020-08-03 22:22:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <2020-08-03 22:22:13> <version> <desc> <source>
 *
 */

package bbz.mq.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

public class RmqReceiverClient {

	public static void main(String[] args) throws Exception {
		// 1.创建消费者Consumer，制定消费者组名
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("business-test-group");
		// 2.指定Nameserver地址
		//consumer.setNamesrvAddr("ecs-uat-rocket-nameservice.baozun.com:9876");
		consumer.setNamesrvAddr("127.0.0.1:9876");
		// 3.订阅主题Topic和Tag
		consumer.subscribe("bm2cm_so_test","test");
		// 消费模式：默认是负载均衡模式，还有一种是广播模式
		consumer.setMessageModel(MessageModel.BROADCASTING);
		// 4.设置回调函数，处理消息
		consumer.registerMessageListener(new MessageListenerConcurrently() {
			//接收消息内容
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
				for (MessageExt messageExt : list) {
					System.out.println(new String(messageExt.getBody()));
				}
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		// 5.启动消费者consumer
		consumer.start();

	}
}