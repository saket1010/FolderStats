package Folderstats;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FolderTest {

    @Test
    public void getFolderstats()
    {
        Folder f=new Folder();
        String directory="C:\\Users\\saket\\Desktop\\Testing";
        Long l=f.calculateStatus(directory).size;
        Assert.assertEquals("29",l.toString());
        Assert.assertEquals(true,compareByType(f.calculateStatus(directory).countByType));

    }
    public boolean compareByType(Map<String,Long> h)
    {
        Folder f=new Folder();
        Map<String,Long> hm=new HashMap<String,Long>();
        hm.put("txt", 22L);
        hm.put("png",7L);
        if(hm.equals(h))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}