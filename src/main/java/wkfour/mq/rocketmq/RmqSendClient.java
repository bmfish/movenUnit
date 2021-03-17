/*
 * FileName: RmqSendClient.java
 * Author:   bm
 * Date:     2020-08-03 22:22:05
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <2020-08-03 22:22:05> <version> <desc> <source>
 *
 */

package wkfour.mq.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
		import org.apache.rocketmq.client.producer.SendResult;
		import org.apache.rocketmq.common.message.Message;


public class RmqSendClient {

	public static void main(String[] args) throws Exception {
		// 1.创建消息生产者producer，并制定生产者组名
		DefaultMQProducer producer = new DefaultMQProducer("business-test-group");
		// 2.指定NameServer地址
	//	producer.setNamesrvAddr("ecs-uat-rocket-nameservice.baozun.com:9876");
	//	producer.setNamesrvAddr("10.88.26.79:9876");
		producer.setNamesrvAddr("127.0.0.1:9876");
		// 3.启动producer
		producer.start();

		for (int i = 0; i < 100; i++) {
			// 4.创建消息对象，指定主题Topic、Tag和消息体
            /*
            参数1：消息主题Topic
            参数2：消息Tag
            参数3：消息内容
             */
            String content="hello world"+i;
            //Message msg = new Message("MQ_hub2pacs_createJdPreOrder_uat","test",content.getBytes());
			Message msg = new Message("bm2cm_so_test","test",content.getBytes());

			// 5.发送消息结果包含  发送状态  消息id 消息接收队列id等
			SendResult result = producer.send(msg);
			System.out.println("发送结果"+result);

			// 线程睡眠1秒
		//	TimeUnit.SECONDS.sleep(1);
		}
		// 6关闭生产者producer
		producer.shutdown();
	}
}