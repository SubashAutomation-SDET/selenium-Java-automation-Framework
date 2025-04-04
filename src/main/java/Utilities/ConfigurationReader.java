package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader
{
    private Properties properties;

    public Properties IntiProperties() throws IOException
    {
        properties=new Properties();
        try
        {
            FileInputStream fileInputStream=new FileInputStream("./src/test/resources/Configuations/Configuration.properties");
            properties.load(fileInputStream);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return properties;
    }

}
