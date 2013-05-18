package mapred.conf;


import org.apache.hadoop.conf.Configuration;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConfTest {

    @Test
    public void testSimpleConf(){
        Configuration conf = new Configuration();
        conf.addResource("configuration-1.xml");
        conf.addResource("configuration-2.xml");
        System.setProperty("color","white");   // not working
        assertThat(conf.get("color"),is("red"));
    }

}
