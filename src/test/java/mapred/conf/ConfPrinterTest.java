package mapred.conf;

import org.apache.hadoop.util.ToolRunner;
import org.junit.Test;

public class ConfPrinterTest {
    @Test
    public void testConfPrinting() throws Exception {
        int code = ToolRunner.run(new ConfigurationPrinter(), null);
        System.out.println(code);
    }
}
