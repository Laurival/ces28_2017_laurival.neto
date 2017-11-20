package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class readFileToXY {
	private File _file;
	private FileReader input;
    private BufferedReader bufRead;
    private StringTokenizer xy;
	
	public void buildDataPoints(File file, Vector<Double> x, Vector<Double> y ) {
        if(file == null)
           return;
        else _file = file;

        try {
            input = new FileReader(_file);
		    /* Filter FileReader through a Buffered read to read a line at a time */
            bufRead = new BufferedReader(input);
            // Read first line
            String line = bufRead.readLine();
            // Read through file one line at time.
            while (line != null){
                xy = new StringTokenizer(line, "\t ");
                while(xy.hasMoreTokens()) {
                    x.addElement(Double.parseDouble(xy.nextToken()));
                    y.addElement(Double.parseDouble(xy.nextToken()));
                }
                line = bufRead.readLine();
            }
            bufRead.close();
        } catch (IOException e) { // If another exception is generated, print a stack trace
            e.printStackTrace();
        }
    
	}//buildDataPoints
}
