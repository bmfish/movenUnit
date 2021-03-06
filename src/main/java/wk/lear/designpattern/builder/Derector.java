/*
 * cf
 * FileName: Derector.java
 * Author:   BM
 * Date:     2019-03-11 17:01:46
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:46> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.builder;
//指挥者
public class Derector {
	private IDateBuilder builder;
	public Derector(IDateBuilder builder){
		this.builder = builder;
	}
	public String getDate(int y,int m,int d){
		builder.buildDate(y, m, d);
		return builder.date();
	}
}
