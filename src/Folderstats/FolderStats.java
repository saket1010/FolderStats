package Folderstats;
import java.io.File;
import java.util.Map;

public class FolderStats {
    public long size;
    public Map<String,Long> countByType;
    FolderStats(long size,Map<String,Long> countByType)
    {
        this.size=size;
        this.countByType=countByType;
    }

}
