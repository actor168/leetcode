import java.util.Scanner;

/**
 * 枚举问题系列之
 * 
 * 熄灯问题
 * 
 */
class CloseLightBulb {
    public static void main(String[] args) {
        int m = 5;
        int n = 6;
        int[][] puzzle = initLightPanel(m, n); //初始化灯面板
        int[][] press = enumerate(puzzle); //枚举
        //打印press矩阵
        printMatrix(press);
    }

    static int[][] enumerate(int[][] puzzle) {
        //初始化press
        int[][] press = new int[puzzle.length][puzzle[0].length];
        while(guess(puzzle, press) == false) {
            press[1][1]++;
            int c = 1;
            while (press[1][c] > 1) {
                press[1][c] = 0;
                c++;
                press[1][c]++;
            }
        }
        return press;
    }

    static boolean guess(int[][] puzzle, int[][] press) {
        int c, r;
        int finalRow = puzzle.length-1;
        for (r = 1; r < finalRow; r++) {
            for (c = 1; c < puzzle[0].length -1; c++) {
                press[r+1][c] = (press[r-1][c] + press[r][c-1] + press[r][c+1] + puzzle[r][c] + press[r][c]) % 2;
            }
        }

        for (c = 1; c < puzzle[0].length -1; c++) {
            if ((press[finalRow][c-1] + press[finalRow][c] + press[finalRow][c+1] + press[finalRow-1][c] + puzzle[finalRow][c]) % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    static int[][] initLightPanel(int m, int n) {
        Scanner scanner = new Scanner(System.in);
        int[][] puzzle = new int[m+1][n+2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                puzzle[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        
        printMatrix(puzzle);
        
        return puzzle;
    }

    static void printMatrix(int[][] matrix) {
        System.out.println("Matrix Started:");
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length-1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
} 