package sparseArray;


public class SparseArray {
	public static void main(String[] args) {

		System.out.println("=================ｔｏＳｐａｒｓｅＡｒｒａｙ　　　　ＳＴＡＲＴ=====================");
		// 创建一个原始的二位数组11*11
		// 	０表示没有棋子，１表示黑子，２表示蓝子
		int[][] chessArray = new int[11][11];
		chessArray[1][2] = 1;
		chessArray[2][3] = 2;
		chessArray[3][5] = 2;
		// 原始的二维数组
		printArray(chessArray);
		System.out.println("======================================");
		toSparseArray(chessArray);
		System.out.println("=================ｔｏＳｐａｒｓｅＡｒｒａｙ　　　　ＯＶＥＲ=====================");
		System.out.println("=================ｔｏＡｒｒａｙ　　　　Ｓｔａｒｔ=====================");
		// 	创建一个稀疏数组　
		int[][] sparse = new int[5][3];
		sparse[0][0] = 12;
		sparse[0][1] = 12;
		sparse[0][2] = 4;

		sparse[1][0] = 5;
		sparse[1][1] = 4;
		sparse[1][2] = 7;

		sparse[2][0] = 6;
		sparse[2][1] = 8;
		sparse[2][2] = 9;

		sparse[3][0] = 7;
		sparse[3][1] = 9;
		sparse[3][2] = 8;

		sparse[4][0] = 2;
		sparse[4][1] = 1;
		sparse[4][2] = 2;
		toArray(sparse);
		System.out.println("=================ｔｏＡｒｒａｙ　　　　ＯＶＥＲ=====================");
	}

	/**
	 * 将原始二维数组转化为稀疏数组
	 *
	 * @param chessArray
	 */
	public static void toSparseArray(int[][] chessArray) {
		// 　将二维数组转化为稀疏数组
		// 	１、先遍历二维数组　得到　非零数据的个数
		int sum = 0;
		for (int[] ints : chessArray) {
			for (int anInt : ints) {
				if (anInt != 0) {
					sum++;
				}
			}
		}
		System.out.println(sum);
		System.out.println("======================================");
		// 	创建稀疏数组
		int[][] sparseArray = new int[sum + 1][3];
		// 	给稀疏数组赋值
		sparseArray[0][0] = chessArray.length;
		sparseArray[0][1] = chessArray[0].length;
		sparseArray[0][2] = sum;
		// 	遍历二维数组，将非０的值存放到稀疏数组中
		// 	count 用于记录是第几个非0数据
		int count = 0;
		for (int i = 0; i < chessArray.length; i++) {
			for (int j = 0; j < chessArray[i].length; j++) {
				if (chessArray[i][j] != 0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = chessArray[i][j];

				}
			}
		}
		printArray(sparseArray);
	}

	/**
	 * 将稀疏数组转化为原始的二维数组
	 *
	 * @param sparseArray
	 */
	public static void toArray(int[][] sparseArray) {
		// 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
		int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];
		// 再读取稀疏数组后几行的数据，并且赋值给原始的二维数组
		for (int i = 1; i < sparseArray.length; i++) {
			array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		printArray(array);
	}

	/**
	 * 对二维数组进行打印
	 *
	 * @param array
	 */
	public static void printArray(int[][] array) {

		for (int[] row : array) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}
}
