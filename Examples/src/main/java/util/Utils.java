package util;

import java.io.File;

import com.aspose.tex.License;

public class Utils {
	public static String getInputDirectory() {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "input");
        System.out.println("Using input directory: " + dir.toString());
        return dir.toString() + File.separator;
    }
	
	public static String getOutputDirectory() {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "output");
        System.out.println("Using output directory: " + dir.toString());
        return dir.toString() + File.separator;
    }
	
	public static void setLicense()	{
		try	{
			// Instantiate an instance of license and set the license file through its path
	        new License().setLicense(System.getProperty("user.dir") + File.separator + "License\\Aspose.TeX.Java.lic");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}