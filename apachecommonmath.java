package matrixbenchmark;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.OpenMapRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SparseRealMatrix;


import com.jmatio.io.MatFileReader;
import com.jmatio.types.MLArray;
import com.jmatio.types.MLDouble;



public class apachecommonmath {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		  MatFileReader mfr = new MatFileReader("matrix2.mat");
	      Map<String, MLArray> content = mfr.getContent();
	      double[][] X = ((MLDouble) content.get("matrix1")).getArray();
        
	      RealMatrix sm1= MatrixUtils.createRealMatrix(X);
	      
	      OpenMapRealMatrix sm2=new OpenMapRealMatrix(5000,5000); 
	      
	      OpenMapRealMatrix sm= (OpenMapRealMatrix) sm2.add(sm1);
	      

	      long starttime=System.nanoTime(); 
	      
	        sm.multiply(sm);
	        
	      long endtime=System.nanoTime();

	        System.out.println(endtime-starttime);

	}

}
