package thinkinginjava.dx.chap02;

/**
 * 保存在什么地方
 * */
public class WhereToSave {
	/***
	 * 主要类型
	 * :有一系列类需需特别对待;可将它们想象成"基本"、"主要"或者"主"(Primitive)类型,进行程序设计时要频繁用到它们。之所以要特别对待,是由与
	 * 用new创建对象(特别是小的、简单的变量)并不是非常有效的,因为new将对象置于堆中.对于这些类型,Java采纳了与C和++相同的方法.也就是说,不是
	 * 用new创建对象,而是创建一个非句柄的自动变量.这个变量容纳了具体的值，并置于堆栈中,能够更高效的存取.
	 */
	Integer i = new Integer(0);
	int b=7;
	/**
	 * Java数组,几乎所有程序设计语言都支持数组。在C和C++里使用数组是非常危险的,因为那些数组只是内存块.若程序访问自己内存块以外的数组,或者在初
	 * 始化之前使用内存(属于常规编程错误),会产生不可预测的后果.
	 * Java的一项主要设计目标就是安全性.所以在C和C++里困扰程序员的许多问题都未在Java里重复。一个Java可以保证被初始化,而且不可在它的范围之外访问.
	 * 由于系统自动进行范围检查,所以必然要付出一些代价;针对每个数组,以及在运行期间对索引的校验,都会造成少量的内存开销.但由此换回的是更高的安全性,以及
	 * 更高的工作效率,为此付出少量代价是值得的。
	 * 1.创建对象数组时,实际创建的是一个句柄数组。而且每个句柄都会自动初始化成一个特殊值,并带有自己的关键字:null(空).一旦Java看到null,就知道该
	 * 句柄并未指向一个对象.正式使用之前,必须为每个句柄都分配一个对象,若试图使用依然为null的句柄,就会在运行期报告问题.
	 * 2.int[]是对象,而int不是.只有对象才能被设置成null
	 * 3.对象使用之前必须初始化
	 * 4.基本类型会被默认初始化int为0,无论是int、long、double还是char、short等,编译器能够保证对它的初始化
	 * */
	public static void main(String[] args) {
		Integer[] a=null;
		Integer a2 = null;
		int [] b = null;
		int [] c = {};
//		System.out.println(a.toString());
		System.out.println(a);//之所以会输出null是因为Integer数组的toString会使用String.valueOf()
		System.out.println(a2);
		System.out.println();
		System.out.println(c);
	}
}
