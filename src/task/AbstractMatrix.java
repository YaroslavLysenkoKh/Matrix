package task;

public abstract class AbstractMatrix {

	public abstract double reverseMatrix();

	public abstract double getElement(int x, int y);

	public abstract void setElement(int x, int y, double element);

	public abstract int getSize();

	public abstract AbstractMatrix instance(double[][] matrix);

	public abstract AbstractMatrix instance(int i);

	public abstract AbstractMatrix instance(int i, int y);

	public abstract double[] getRow(int index);

	public double determinant() {
		double result = 0;
		if (getSize() == 1) {
			return getElement(0, 0);
		} else if (getSize() == 2) {
			return getElement(0, 0) * getElement(1, 1) - getElement(0, 1) * getElement(1, 0);
		} else {
			for (int j = 0; j < getSize(); j++) {
				if ((j & 1) == 0)
					result += getElement(0, j) * trimmedMaxtrix(this, 0, j).determinant();
				else
					result -= getElement(0, j) * trimmedMaxtrix(this, 0, j).determinant();
			}
		}
		return result;
	}

	private AbstractMatrix trimmedMaxtrix(AbstractMatrix matrix, int row, int col) {
		double[][] tmp = new double[matrix.getSize() - 1][matrix.getSize() - 1];
		int r = 0;
		for (int i = 0; i < matrix.getSize(); i++) {
			if (i == row) {
				continue;
			}
			int c = 0;
			for (int j = 0; j < matrix.getSize(); j++) {
				if (j == col) {
					continue;
				}
				tmp[r][c] = matrix.getElement(i, j);
				++c;
			}
			r++;
		}
		return instance(tmp);
	}

	public AbstractMatrix invertibleMatrix() {
		double d = determinant();
		if (determinant() == 0) {
			return null;
		}
		int num = 1;
		AbstractMatrix reversed = instance(getSize());
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				if ((num & 1) == 0) {
					reversed.setElement(j, i, (trimmedMaxtrix(this, i, j).determinant() * -1 / d));
				} else {
					reversed.setElement(j, i, trimmedMaxtrix(this, i, j).determinant() / d);
				}
				num++;
			}
		}
		for (int i = 0; i < getSize(); i++) {
			for (int j = i + 1; j < getSize(); j++) {
				double tmp = reversed.getElement(i, j);
				reversed.setElement(i, j, reversed.getElement(j, i));
				reversed.setElement(j, i, tmp);
			}
		}
		return reversed;

	}

	public AbstractMatrix multiply(AbstractMatrix matrix) {
		if (getSize() != matrix.getSize()) {
			return null;
		}
		double[][] result = new double[getSize()][getSize()];
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				for (int k = 0; k < getSize(); k++) {
					result[i][j] += getElement(i, k) * matrix.getElement(k, j);
				}
			}
		}
		return instance(result);
	}
}
