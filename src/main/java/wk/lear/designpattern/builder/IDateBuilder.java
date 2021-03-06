/*
 * cf
 * FileName: IDateBuilder.java
 * Author:   BM
 * Date:     2019-03-11 17:01:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:48> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.builder;
//抽象生成器
public interface IDateBuilder {
	IDateBuilder buildDate(int y, int m, int d);
	String date();
}
