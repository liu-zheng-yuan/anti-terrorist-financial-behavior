package edu.nju.antiTerroristFinancialBehavior.utils;

import javax.servlet.http.HttpServletRequest;

/**
 *工具算法类
 * @author gaoxiang
 */
public class Algorithm {

    /**
     * 从request拿到数据生成矩阵
     * @param request
     * @return
     */
    public static String[][] generateMatrix(HttpServletRequest request){
        int n = Integer.valueOf(request.getParameter("length"));
        String[][] matrix = new String[n][n];
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                matrix[i][j] = request.getParameter(""+i+"+"+j);
            }
        }
        return matrix;
    }
    /**
     * 将字符串二维数组转为double二维数组
     * @param matrix
     * @return
     */

    public static double[][] str2double(String[][] matrix){
        int n = matrix.length;
        double[][] m = new double[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j].length() == 1){
                    m[i][j] = Double.valueOf(matrix[i][j]);
                }
                if(matrix[i][j].length() == 3){
                    m[i][j] = 1.0 / Double.valueOf(matrix[i][j].split("/")[1]);
                }

            }
        }
        return m;
    }

    /**
     *将二维数组转化为字符串
     * @param matrix
     * @return
     */
    public static String matrix2str(String[][] matrix){
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if(j == matrix[i].length-1){
                    strBuilder.append(matrix[i][j]);
                }else {
                    strBuilder.append(matrix[i][j] + ",");
                }
            }
            if(i != matrix.length - 1) {
                strBuilder.append(";");
            }
        }
        String str = strBuilder.toString();
        return str;
    }

    /**
     * 将字符串解码为二维数组
     * @param str
     * @return
     */
    public static String[][] str2matrix(String str) {
        int rows = str.split(";").length;
        int cols = str.split(";")[0].split(",").length;
        String[][] matrix = new String[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] = str.split(";")[i].split(",")[j];
            }
        }
        return matrix;
    }

    /**
     * 补全矩阵
     * @param matrix
     */
    public static void completeMatrix(String[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(i == j) {
                    matrix[i][j] = "1";
                }else if(i > j){
                    if (matrix[j][i].length() == 1)
                        matrix[i][j] = "1" + "/" + matrix[j][i];
                    else if(matrix[j][i].length() == 3)
                        matrix[i][j] = matrix[j][i].substring(2);
                }else{
                    continue;
                }
            }
        }
    }




    /**
     * 测试方法正确性
     * @param args
     */
    public static void main(String[] args) {


        String[][] matrix = {
                {"","1/3","1/2","1/2"},
                {"","","2","2"},
                {"","","","2"},
                {"","","",""}
        };
        completeMatrix(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(matrix2str(matrix));
        String[][] m = str2matrix(matrix2str(matrix));
        for(int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        double[][] mm = str2double(m);
        for(int i = 0; i < mm.length; i++) {
            for (int j = 0; j < mm[i].length; j++) {
                System.out.print(mm[i][j] + " ");
            }
            System.out.println();
        }
        AHP ahp = new AHP();
        System.out.println(ahp.isConsistency(mm));
        if(ahp.isConsistency(mm)){
            for(int i = 0; i < 4; i++){
                System.out.println(ahp.getWeight()[i]);
            }
        }
    }
}
