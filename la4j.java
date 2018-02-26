package matrixbenchmark;
		import com.jmatio.io.MatFileReader;
		import com.jmatio.types.MLArray;
		import com.jmatio.types.MLDouble;
		import smile.classification.SVM;
		import smile.math.kernel.LinearKernel;
		import smile.math.kernel.GaussianKernel;
		import smile.classification.RandomForest;
		import smile.plot.Heatmap;
		import smile.plot.PlotCanvas;

		import java.io.FileNotFoundException;
		import java.io.IOException;
		import java.util.Map;

import org.la4j.Matrix;
import org.la4j.matrix.MatrixFactory;
import org.la4j.matrix.SparseMatrix;
import org.la4j.matrix.dense.Basic2DMatrix;


		
public class la4j {


		    public static void main(String[] args) throws FileNotFoundException, IOException {
		        // Reading training data
		        MatFileReader mfr = new MatFileReader("matrix2.mat");
		        Map<String, MLArray> content = mfr.getContent();
		        double[][] X = ((MLDouble) content.get("matrix1")).getArray();

		        Basic2DMatrix sx1=new Basic2DMatrix(X);
		       
		        //Matrix sx1=null;
		        SparseMatrix sx=sx1.toSparseMatrix();
		        
		        
		        long starttime=System.nanoTime();
		        
		        sx1.multiply(sx1);
		  
		        long endtime=System.nanoTime();

		        System.out.println(endtime-starttime);

	}

}
