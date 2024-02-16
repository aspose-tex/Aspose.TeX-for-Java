package com.aspose.tex.RequiredInputDirectory;

import java.util.HashMap;
import java.util.Map;

import com.aspose.tex.IFileCollector;
import com.aspose.tex.IInputWorkingDirectory;
import com.aspose.tex.TeXInputStream;

// ExStart:Conversion-RequiredInputDirectory
// This is an implementation of IInputWorkingDirectory that is suitable for the TeX job's RequiredInputDirectory option
// in case required input contains fonts provided by external packages.
// The class additionally implements IFileCollector, which provides access to file collections by extension.
// This is necessary to load external font maps, which are files (outside TeX syntax) that map TeX's
public class RequiredInputDirectory implements IInputWorkingDirectory, IFileCollector
{
    private Map<String, Map<String, String>> _fileNames = new HashMap<String, Map<String, String>>();

    public RequiredInputDirectory()
    { 
    }

    // This method should preliminarily be called for each file entry that is supposed to be located inside
    // the required input directory. Inside is an example of how the dictionary of file names could be organized
    // for easy collection of file names by extension.
    // Here fileName is a full file name. This can be a file path on a file system, a URL, or whatever else (theoretically).
    public void storeFileName(String fileName)
    {
        String extension = getExtension(fileName);
        String name = getFileNameWithoutExtension(fileName);

        Map<String, String> files = _fileNames.get(extension);
        if (files == null)
            _fileNames.put(extension, files = new HashMap<String, String>());

        files.put(name, fileName);
    }

    // The IInputWorkingDirectory implementation.
    public TeXInputStream getFile(String fileName, boolean searchSubdirectories)
    {
        return new TeXInputStream(null, fileName); // Here we actually return a stream for the file requested by its name.
    }
    
    // Here is how we gather file collections by extension.
    public String[] getFileNamesByExtension(String extension)
    {
    	return getFileNamesByExtension(extension, null);
    }

    // Here is how we gather file collections by extension.
    public String[] getFileNamesByExtension(String extension, String path)
    {
        Map<String, String> files = _fileNames.get(extension);
        if (files == null)
            return new String[0];
        
        return files.values().toArray(new String[0]);
    }
    
    private String getExtension(String fileName)
    {
    	int pos = fileName.indexOf('.');
    	if (pos < 0)
    		return "";
    	
    	return fileName.substring(pos);
    }
    
    private String getFileNameWithoutExtension(String fileName)
    {
    	int pos = fileName.lastIndexOf('/');
    	if (pos >= 0)
    		fileName = fileName.substring(pos + 1);
    	
    	pos = fileName.indexOf('.');
    	if (pos < 0)
    		return fileName;
    	
    	return fileName.substring(0, pos);
    }

    public void close()
    {
    	_fileNames.clear();
    }
}
// ExEnd:Conversion-RequiredInputDirectory