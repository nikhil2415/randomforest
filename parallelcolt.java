package matrixbenchmark;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.jmatio.io.MatFileReader;
import com.jmatio.types.MLArray;
import com.jmatio.types.MLDouble;

import cern.colt.matrix.tdouble.DoubleMatrix2D;
import cern.colt.matrix.tdouble.impl.SparseDoubleMatrix2D;

public class parallelcolt {
    
	public static void main(String[] args) throws FileNotFoundException, IOException {
        // Reading training data
        MatFileReader mfr = new MatFileReader("matrix1.mat");
        Map<String, MLArray> content = mfr.getContent();
        double[][] X = ((MLDouble) content.get("matrix1")).getArray();

        SparseDoubleMatrix2D sx =new SparseDoubleMatrix2D(X);
        DoubleMatrix2D sx2 = null;
        
        long starttime=System.nanoTime();
        
        sx.zMult(sx,sx2);
  
        long endtime=System.nanoTime();

        System.out.println(endtime-starttime);

}

}
