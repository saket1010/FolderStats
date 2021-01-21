package Folderstats;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Folder {
  private Map<String,Long> hm =new HashMap<String,Long>();

    public FolderStats calculateStatus(String s)
    {
        File f=new File(s);
        Map<String,Long> ByType=calculateTotalSize(f);
        long total_size = 0;

        //Adding total size.
        for(Map.Entry<String,Long> t:ByType.entrySet())
        {
            total_size=total_size+(Long)t.getValue();

        }
        hm.clear();
        return new FolderStats(total_size,ByType);
    }

    private Map<String,Long>calculateTotalSize(File f){

        File[] files = f.listFiles();
        int count = files.length;
        //Traversing Files and Folder.
        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                String ex = getExtension(files[i].getName());
                if (hm.containsKey(ex)) {
                    long temp = (Long) hm.get(ex) + files[i].length();
                    hm.replace(ex, temp);
                } else {
                    hm.put(ex, files[i].length());
                }
            } else {
                calculateTotalSize(files[i]);
            }
        }
        Map<String,Long> l=new HashMap<String,Long>(hm);

        return l;
    }

    //Getting extension of file.
    private String getExtension(String s)
    {
        String extension=s.substring(s.lastIndexOf('.')+1);
        return extension;
    }

}
