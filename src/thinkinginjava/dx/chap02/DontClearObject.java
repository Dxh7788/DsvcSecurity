package thinkinginjava.dx.chap02;
/**
 * ���Բ�Ҫ�������
 * �ڴ�������������,�����ġ�����ʱ��(LifeTime)��һֱ�ǳ���Ա��Ҫ���ؿ��ǵ����⡣����Ӧ�����೤���¼������Ҫ�����,��ô��ʱ���У�
 * */
public class DontClearObject {

	/**
	 * ��������{}������,���ڵĿ������������,��������޷��������ڵ�
	 * ����staticֻ��ʵ��������ܵ���
	 * ���ܳ������µĴ���
	 * {
	 * 		int x =12;
	 * 		{
	 * 			int x=96;//illegal
	 * 		}
	 * }
	 * */
	static {//����ʵ�������ܵ���
		int x =12;//ֻ��x��Ч
		{
			int q=96;//x��q����Ч
			System.out.println(q);
		}
		/**
		 * ֻ��x��Ч,q��Ч
		 * */
		System.out.println(x);
	}
	{//ʵ��������
		int x =12;//ֻ��x��Ч
		{
			int q=96;//x��q����Ч
			System.out.println(q);
		}
		/**
		 * ֻ��x��Ч,q��Ч
		 * */
		System.out.println(x);
	}
	public static void main(String[] args) {
		new DontClearObject();
	}
}
