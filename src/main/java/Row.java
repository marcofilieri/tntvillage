import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;

public class Row {
    CSVReader csvReader;

    public ArrayList rows(){
        ArrayList rows = new ArrayList();
        try{
            csvReader = new CSVReader(new InputStreamReader(getClass().getResourceAsStream("dump_release.csv")));
            String[] line = null;
            csvReader.skip(1);
            String id = null, title = null, link = null;
            while ((line = csvReader.readNext()) != null){
                id = line[2];
                title = line[5];
                link = "https://web.archive.org/web/http://forum.tntvillage.scambioetico.org/index.php?showtopic="+id;
                rows.add(new Object[]{title,link});
            }
            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows;
    }
}
