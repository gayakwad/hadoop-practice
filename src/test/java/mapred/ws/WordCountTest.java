package mapred.ws;


import mapred.wc.WordCountMapper;
import mapred.wc.WordCountReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mrunit.MapDriver;

public class WordCountTest {
    public void testWC(){
        WordCountMapper mapper = new WordCountMapper();
        WordCountReducer reducer = new WordCountReducer();
        MapDriver<LongWritable, Text, Text, IntWritable> mapDriver = new MapDriver<LongWritable, Text, Text, IntWritable>();
        mapDriver.setMapper((Mapper<LongWritable,Text,Text,IntWritable>) mapper);

    }
}
