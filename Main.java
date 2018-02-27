package com.company;

import com.jmatio.io.MatFileReader;
import com.jmatio.types.MLArray;
import com.jmatio.types.MLDouble;

import java.io.IOException;
import java.util.Map;
import smile.math.matrix.*;
import org.apache.commons.math3.linear.*;


public class Main {

    public static void smiletest(double[][] x){
        System.out.println("Testing smile");
        SparseMatrix X = new SparseMatrix(x);
        long timebefore = System.nanoTime();
        SparseMatrix Z = X.abmm(X);
        double timeinms = (System.nanoTime() - timebefore)/1e6;
        System.out.println("Rows: " + X.nrows() + " Cols: " + X.ncols());
        System.out.println("Time in ms for X*X: " + timeinms);
    }
    public static void apachetest(double[][] x){
        System.out.println("Testing Apache");
//        RealMatrix X = MatrixUtils.createRealMatrix(x);
        OpenMapRealMatrix X = new OpenMapRealMatrix(x);
        long timebefore = System.nanoTime();
        OpenMapRealMatrix Z = X.multiply(X);
        double timeinms = (System.nanoTime() - timebefore)/1e6;
        System.out.println("Rows: " + X.getRowDimension() + " Cols: " + X.getColumnDimension());
        System.out.println("Time in ms for X*X: " + timeinms);
    }
    public static void main(String[] args) throws IOException{
        System.out.println("Running");
        MatFileReader mfr1 = new MatFileReader("vars2.mat");
//        MatFileReader mfr2 = new MatFileReader("matrix2.mat");
        Map<String, MLArray> content1 = mfr1.getContent();
//        Map<String, MLArray> content2 = mfr2.getContent();
        double[][] x = ((MLDouble) content1.get("x")).getArray();
//        double[][] y = ((MLDouble) content2.get("matrix2")).getArray();

        smiletest(x);
        apachetest(x);
    }
}
