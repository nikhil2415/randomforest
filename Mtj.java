package matrixbenchmark;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.jmatio.io.MatFileReader;
import com.jmatio.types.MLArray;
import com.jmatio.types.MLDouble;
import com.jmatio.types.MLInt32;

import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.Matrix;
import no.uib.cipr.matrix.sparse.CompRowMatrix;
import no.uib.cipr.matrix.sparse.LinkedSparseMatrix;

public class Mtj {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		 // Reading training data
        MatFileReader mfr = new MatFileReader("matrix2.mat");
        Map<String, MLArray> content = mfr.getContent();
        MLArray xarray=content.get("matrix1");
        
        
        double[][] X =  ((MLDouble) content.get("matrix1")).getArray();
        
        //CompRowMatrix sm= new CompRowMatrix(5000,5000,X);
        
        Matrix A = new DenseMatrix(X);
        //DenseMatrix sm=new DenseMatrix(A);
        Matrix A1=A;
        LinkedSparseMatrix sm=new LinkedSparseMatrix(A) ;
        
        //LinkedSparseMatrix output=new LinkedSparseMatrix(5000,5000) ;
        
        long starttime=System.nanoTime(); 
	      
        sm.mult(sm, sm);
        
        long endtime=System.nanoTime();

        System.out.println(endtime-starttime);
        
	}

}
