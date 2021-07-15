package com.jachs.commons.math;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Skewness;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;
import org.junit.Test;

/**
 * 支持java5到java8 支持以二维数组的形式存储密集数据 支持大量密集数据的块存储 支持DOK形式的稀疏数据存储（键值对字典）
 * 支持double、BigDecimal、String、Object、Complex Numbers等数据类型 支持二维矩阵
 * 支持常用的矩阵操作、如矩阵转置、矩阵求逆、加减乘除 支持LU和QR分解等
 * 
 * @author zhanchaohan
 * 
 */
public class Demo {
    @Test
    public void test1 () {
        double[] values = new double[] { 0.33, 1.33, 0.27333, 0.3, 0.501, 0.444, 0.44, 0.34496, 0.33, 0.3, 0.292,
                0.667 };

        Min min = new Min ();
        Max max = new Max ();
        Mean mean = new Mean (); // 算术平均值 
        Product product = new Product ();//乘积 
        Sum sum = new Sum ();
        Variance variance = new Variance ();//方差 

        System.out.println ( "min: " + min.evaluate ( values ) );
        System.out.println ( "max: " + max.evaluate ( values ) );
        System.out.println ( "mean: " + mean.evaluate ( values ) );
        System.out.println ( "product:" + product.evaluate ( values ) );
        System.out.println ( "sum: " + sum.evaluate ( values ) );
        System.out.println ( "variance:" + variance.evaluate ( values ) );

        Percentile percentile = new Percentile (); // 百分位数 
        GeometricMean geoMean = new GeometricMean (); // 几何平均数,n个正数的连乘积的n次算术根叫做这n个数的几何平均数 
        Skewness skewness = new Skewness (); //Skewness(); 
        Kurtosis kurtosis = new Kurtosis (); //Kurtosis,峰度 
        SumOfSquares sumOfSquares = new SumOfSquares (); // 平方和 
        StandardDeviation StandardDeviation = new StandardDeviation ();//标准差 

        System.out.println ( "80 percentilevalue: " + percentile.evaluate ( values, 80.0 ) );

        System.out.println ( "geometricmean: " + geoMean.evaluate ( values ) );
        System.out.println ( "skewness:" + skewness.evaluate ( values ) );
        System.out.println ( "kurtosis:" + kurtosis.evaluate ( values ) );
        System.out.println ( "sumOfSquares:" + sumOfSquares.evaluate ( values ) );
        System.out.println ( "StandardDeviation: " + StandardDeviation.evaluate ( values ) );
        System.out.println ( "-------------------------------------" );

        // Create a real matrix with two rowsand three columns 

        double[][] matrixData = { { 1d, 2d, 3d }, { 2d, 5d, 3d } };
        RealMatrix m = new Array2DRowRealMatrix ( matrixData );

        System.out.println ( m );

        // One more with three rows, twocolumns 

        double[][] matrixData2 = { { 1d, 2d }, { 2d, 5d }, { 1d, 7d } };
        RealMatrix n = new Array2DRowRealMatrix ( matrixData2 );

        // Note: The constructor copies  the input double[][] array.          

        // Now multiply m by n 

        RealMatrix p = m.multiply ( n );

        System.out.println ( "p:" + p );
        System.out.println ( p.getRowDimension () ); // 2 
        System.out.println ( p.getColumnDimension () ); // 2          

        // Invert p, using LUdecomposition 

        RealMatrix pInverse = new LUDecomposition ( p ).getSolver ().getInverse ();

        System.out.println ( pInverse );
    }

    @Test
    public void test2 () {
        double[] values = new double[] { 0.33, 1.33, 0.27333, 0.3, 0.501, 0.444, 0.44, 0.34496, 0.33, 0.3, 0.292,
                0.667 };
        double[] values2 = new double[] { 0.89, 1.51, 0.37999, 0.4, 0.701, 0.484, 0.54, 0.56496, 0.43, 0.3, 0.392,
                0.567 };

        //计数
        System.out.println ( "计算样本个数为：" + values.length );
        //mean--算数平均数
        System.out.println ( "平均数：" + StatUtils.mean ( values ) );
        //sum--和
        System.out.println ( "所有数据相加结果为：" + StatUtils.sum ( values ) );
        //max--最小值
        System.out.println ( "最小值：" + StatUtils.min ( values ) );
        //max--最大值
        System.out.println ( "最大值：" + StatUtils.max ( values ) );
        //范围
        System.out.println ( "范围是：" + ( StatUtils.max ( values ) - StatUtils.min ( values ) ) );
        //标准差  
        StandardDeviation standardDeviation = new StandardDeviation ();
        System.out.println ( "一组数据的标准差为：" + standardDeviation.evaluate ( values ) );
        //variance--方差
        System.out.println ( "一组数据的方差为：" + StatUtils.variance ( values ) );
        //median--中位数
        Median median = new Median ();
        System.out.println ( "中位数：" + median.evaluate ( values ) );
        //mode--众数
        double[] res = StatUtils.mode ( values );
        System.out.println ( "众数：" + res[0] + "," + res[1] );
        for ( int i = 0 ; i < res.length ; i++ ) {
            System.out.println ( "第" + ( i + 1 ) + "个众数为：" + res[i] );
        }
        //geometricMean--几何平均数
        System.out.println ( "几何平均数为：" + StatUtils.geometricMean ( values ) );
        //meanDifference-- 平均差，平均概率偏差
        System.out.println ( "平均差为：" + StatUtils.meanDifference ( values, values2 ) );
        //normalize--标准化
        double[] norm = StatUtils.normalize ( values2 );
        for ( int i = 0 ; i < res.length ; i++ ) {
            System.out.println ( "第" + ( i + 1 ) + "个数据标准化结果为：" + norm[i] );
        }
        //percentile--百分位数
        System.out.println ( "从小到大排序后位于80%位置的数：" + StatUtils.percentile ( values, 70.0 ) );
        //populationVariance--总体方差 
        System.out.println ( "总体方差为：" + StatUtils.populationVariance ( values ) );
        //product--乘积  
        System.out.println ( "所有数据相乘结果为：" + StatUtils.product ( values ) );
        //sumDifference--和差
        System.out.println ( "两样本数据的和差为：" + StatUtils.sumDifference ( values, values2 ) );
        //sumLog--对数求和
        System.out.println ( "一组数据的对数求和为：" + StatUtils.sumLog ( values ) );
        //sumSq--计算一组数值的平方和
        System.out.println ( "一组数据的平方和：" + StatUtils.sumSq ( values ) );
        //varianceDifference --方差差异性。
        System.out.println ( "一组数据的方差差异性为："
                + StatUtils.varianceDifference ( values, values2, StatUtils.meanDifference ( values, values2 ) ) );
    }

}
