package task;

public class Demo {

	public static void main(String[] args) {
		double[][] matrix = { { -9, 1, 0 }, { 4, 1, 1 }, { -2, 2, -1 } };
//		double[][] matrix1 = { { -9, 1, 0 }, { 4, 1, 1 }, { -2, 2, -1 } };

		System.out.println(new Matrix(matrix).determinant());
		AbstractMatrix inverse = new Matrix(matrix).invertibleMatrix();
		System.out.println(inverse);
//		AbstractMatrix result = new Matrix(matrix).multiply(new Matrix(matrix1));
//		System.out.println(result);
	}

}
