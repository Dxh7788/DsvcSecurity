package thinkinginjava.dx.chap02;
/**
 * 绝对不要清除对象
 * 在大多数程序设计中,变量的“存在时间(LifeTime)”一直是程序员需要着重考虑的问题。变量应持续多长的事件？如果要清除它,那么何时进行？
 * */
public class DontClearObject {

	/**
	 * 作用域以{}来区分,最内的可以引用最外的,而最外的无法引用最内的
	 * 不带static只有实例化后才能调用
	 * 不能出现以下的代码
	 * {
	 * 		int x =12;
	 * 		{
	 * 			int x=96;//illegal
	 * 		}
	 * }
	 * */
	static {//不用实例化就能调用
		int x =12;//只有x有效
		{
			int q=96;//x和q都有效
			System.out.println(q);
		}
		/**
		 * 只有x有效,q无效
		 * */
		System.out.println(x);
	}
	{//实例化调用
		int x =12;//只有x有效
		{
			int q=96;//x和q都有效
			System.out.println(q);
		}
		/**
		 * 只有x有效,q无效
		 * */
		System.out.println(x);
	}
	public static void main(String[] args) {
		new DontClearObject();
	}
}
