package com.aspose.tex.LoadLicenseFromFile;

import com.aspose.tex.License;

public class LoadLicenseFromFile
{
	public static void main(String[] args) throws Exception
	{
		// ExStart:LoadLicenseFromFile
        // Initialize license object.
        License license = new License();
        // Set license.
        license.setLicense("D:\\Aspose.Total.Java.lic");
        System.out.println("License set successfully.");
        // ExEnd:LoadLicenseFromFile
	}
}