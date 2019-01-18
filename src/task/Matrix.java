package task;

import java.util.Arrays;

public class Matrix extends AbstractMatrix {
	private double[][] array;

	public Matrix(int n) {
		array = new double[n][n];
	}

	public Matrix(double[][] array) {
		super();
		this.array = array;
	}

	public Matrix(int n, int m) {
		array = new double[n][m];
	}

	@Override
	public double reverseMatrix() {
		return 0;
	}

	@Override
	public double getElement(int x, int y) {
		return array[x][y];
	}

	@Override
	public void setElement(int x, int y, double element) {
		array[x][y] = element;
	}

	@Override
	public int getSize() {
		return array.length;
	}

	@Override
	public AbstractMatrix instance(double[][] matrix) {
		return new Matrix(matrix);
	}

	public AbstractMatrix instance(int i) {
		return new Matrix(i);
	}

	@Override
	public String toString() {
		return Arrays.deepToString(array);
	}

	@Override
	public double[] getRow(int index) {
		return array[index];
	}

	@Override
	public AbstractMatrix instance(int i, int y) {
		return new Matrix(i, y);
	}

}
