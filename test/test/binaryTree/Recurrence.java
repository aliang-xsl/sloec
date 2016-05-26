package test.binaryTree;

/**
 * 
 * 递归测试
 * 
 * @author aliang
 * @version 1.0
 * @created 2014年11月8日 上午11:08:48
 */
public class Recurrence {

	public static void main(String[] args) {

	}

	/**
	 * 
	 * 
	 * @return
	 */
	public static int add() {

		return 0;
	}

	/**
	 * 阶乘
	 * 
	 * @return
	 */
	public static Double recursive(Double num) {
		if (num == 1) {
			return (1d);
		}
		return num * recursive(num - 1);
	}

}
