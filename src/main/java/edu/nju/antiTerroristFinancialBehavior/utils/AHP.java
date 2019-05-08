package edu.nju.antiTerroristFinancialBehavior.utils;

import org.springframework.stereotype.Component;

@Component
public class AHP {

    public static double[] ri = {0, 0, 0, 0.58, 0.90, 1.12, 1.24, 1.32, 1.41, 1.45, 1.49, 1.51};

    public double cr = 0.0;//一致性检验指标

    public Double[] w = null;

    public static void main(String[] args) {
        double[][] matrix1 = {
                {1,2,5},
                {1.0/2,1,2},
                {1.0/5,1.0/2,1}
        };
        double[][] matrix2 = {
                {1,1.0/3,1.0/8},
                {3,1,1.0/3},
                {8,3,1}
        };
        double[][] avg = new double[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                avg[i][j] = (matrix1[i][j] + matrix2[i][j]) / 2;
            }
        }
        AHP ahp1 = new AHP();
        System.out.println(ahp1.isConsistency(matrix1));
        double[] weight1 = ahp1.getWeight();
        for(int i = 0; i < weight1.length; i++){
            System.out.print(weight1[i]+" ");
        }
        System.out.println();

        AHP ahp2 = new AHP();
        System.out.println(ahp2.isConsistency(matrix2));
        double[] weight2 = ahp2.getWeight();
        for(int i = 0; i < weight2.length; i++){
            System.out.print(weight2[i]+" ");
        }
        System.out.println();

        AHP ahp3 = new AHP();
        System.out.println(ahp3.isConsistency(avg));
        double[] weight3 = ahp3.getWeight();
        for(int i = 0; i < weight3.length; i++){
            System.out.print(weight3[i]+" ");
        }
        System.out.println();

    }

    /*
    * 计算权重,要在一致性检验之后
    * */
    public double[] getWeight(){
        double[] weight = new double[w.length];
        if(w.length != 0){
            for(int i = 0; i < w.length; i++){
                weight[i] = w[i].doubleValue();
            }
        }
        return weight;
    }

    /*
    * 一致性检验 先检验
    * */
    public boolean isConsistency(double[][] matrix){
        w = computeWeight(matrix);
        if(cr >= 0.1){
            return false;
        }
        return true;
    }

    public Double[] computeWeight(double[][] matrix){
        int n = matrix.length;

        Double[] column = new Double[n];
        for(int j = 0; j < n; j++){
            for(int i = 0; i < n ; i++){
                if(column[j] != null){
                    column[j] = column[j]+matrix[i][j];
                }else{
                    column[j] = matrix[i][j];
                }
            }

        }

        //矩阵归一化
        Double[][] matrixColumn = new Double[n][n];
        for(int j = 0;j < n; j++){
            for(int i = 0; i < n; i++){
                matrixColumn[i][j] = matrix[i][j]/column[j];
            }

        }

        //获得行数组
        Double[] line = new Double[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(line[i] != null){
                    line[i] = line[i] + matrixColumn[i][j];
                }else{
                    line[i] = matrixColumn[i][j];
                }
            }
        }

        //行归一化获得特征向量
        Double[] w = new Double[n];
        Double sum = 0.0;
        for(int i = 0; i < n; i++){
            sum = sum + line[i];
        }
        for(int i = 0; i < n; i++){
            w[i] = line[i] / sum;                    //特征向量
        }

        Double[] bw = new Double[n];
        for(int i = 0; i < n; i++){
                for(int j = 0;j < n; j++){
                    if(bw[i] != null){
                        bw[i] = bw[i] + matrix[i][j] * w[j];
                    }else{
                        bw[i] = matrix[i][j] * w[j];
                    }
                }
            }

            Double sumR = 0.0;                        //最大特征跟R
            for(int i = 0; i < n; i++){
                sumR=sumR + bw[i] / (n * w[i]);
        }

        Double ci = (sumR - n) / (n - 1);                //矩阵一致性指标

        this.cr = ci / ri[n];

        return w;
    }
}