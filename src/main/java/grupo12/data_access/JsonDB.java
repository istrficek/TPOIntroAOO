package grupo12.data_access;

import grupo12.utils.JsonUtils;

import java.io.*;

public class JsonDB<T> {
    final String dbFile;
    final Class<T> typeParameterClass;

    public <C> JsonDB(String dbFile, Class<T> typeParameterClass){
        this.dbFile = dbFile;
        this.typeParameterClass = typeParameterClass;
    }

    public T SelectAll(){
        try {
            File f = new File(dbFile);
            if(!f.exists())
                return null;

            BufferedReader lector = new BufferedReader(new FileReader(dbFile));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = lector.readLine()) != null) {
                sb.append(line);
            }

            lector.close();
            
            String dbContent = sb.toString();
            return JsonUtils.parse(dbContent, typeParameterClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean Insert(T object){
        try {
            File f = new File(dbFile);
            String jsonObject = JsonUtils.toJson(object);
            if(f.exists())
                f.delete();

            FileWriter myWriter = new FileWriter(dbFile);
            myWriter.write(jsonObject);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
