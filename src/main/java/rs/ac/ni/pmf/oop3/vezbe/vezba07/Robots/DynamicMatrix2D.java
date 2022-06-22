package rs.ac.ni.pmf.oop3.vezbe.vezba07.Robots;

public class DynamicMatrix2D {
    private final char[][] matrix;
    private final int n;
    private final int m;

    public DynamicMatrix2D(int n, int m) {
        matrix = new char[n][];
        for(int i = 0; i < m; i++) {
            matrix[i] = new char[m];
        }
        this.n = n;
        this.m = m;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = 'O';
            }
        }
    }

    public void set(int x, int y, char value) {
        if (x >= n) {
            System.err.println("Unavailable field");
            return;
        }

        if (y >= m) {
            System.err.println("Unavailable field");
            return;
        }

        matrix[x][y] = value;
    }

    public char get(int x, int y) {
        return x >= n || y >= m ? 'z' : matrix[x][y];
    }

    public boolean isValidField(int x, int y) {
        return x < n || x >= 0 || y < m || y >= 0;
    }
}