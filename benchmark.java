package matrixbenchmark;
		import com.jmatio.io.MatFileReader;
		import com.jmatio.types.MLArray;
		import com.jmatio.types.MLDouble;
		import smile.classification.SVM;
		import smile.math.kernel.LinearKernel;
import smile.math.matrix.SparseMatrix;
import smile.math.kernel.GaussianKernel;
		import smile.classification.RandomForest;
		import smile.plot.Heatmap;
		import smile.plot.PlotCanvas;

		import java.io.FileNotFoundException;
		import java.io.IOException;
		import java.util.Map;
		
public class benchmark {


		    public static void main(String[] args) throws FileNotFoundException, IOException {
		        // Reading training data
		        MatFileReader mfr = new MatFileReader("matrix1.mat");
		        Map<String, MLArray> content = mfr.getContent();
		        double[][] X = ((MLDouble) content.get("matrix1")).getArray();

		        SparseMatrix sx=new SparseMatrix(X);
		        
		        long starttime=System.nanoTime();
		        //Multiplication Operation
		        sx.abmm(sx);
		        
		        long endtime=System.nanoTime();

	}

}
