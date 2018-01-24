package mapred.ws;


import mapred.wc.WordCountMapper;
import mapred.wc.WordCountReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordCountTest {

    MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;
    ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;
    MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;

    @Before
    public void setUp() {
        WordCountMapper mapper = new WordCountMapper();
        WordCountReducer reducer = new WordCountReducer();
        mapDriver = MapDriver.newMapDriver(mapper);
        reduceDriver = ReduceDriver.newReduceDriver(reducer);
        mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);
    }

    @Test
    public void testMapper() {
        mapDriver.withInput(new LongWritable(), new Text("Hadoop Map Reduce Map"));
        mapDriver.withOutput(new Text("Hadoop"), new IntWritable(1));
        mapDriver.withOutput(new Text("Map"), new IntWritable(1));
        mapDriver.withOutput(new Text("Reduce"), new IntWritable(1));
        mapDriver.withOutput(new Text("Map"), new IntWritable(1));
        mapDriver.runTest();
    }

    @Test
    public void testReducer() {
        List<IntWritable> values = new ArrayList<IntWritable>();
        values.add(new IntWritable(1));
        values.add(new IntWritable(1));
        reduceDriver.withInput(new Text("Map"), values);
        reduceDriver.withOutput(new Text("Map"), new IntWritable(2));
        reduceDriver.runTest();
    }

    @Test
    public void testMapReduce() {
        mapReduceDriver.withInput(new LongWritable(), new Text(
                "Hadoop Map Reduce Map"));
        mapReduceDriver.withOutput(new Text("Hadoop"), new IntWritable(1));
        mapReduceDriver.withOutput(new Text("Map"), new IntWritable(2));
        mapReduceDriver.withOutput(new Text("Reduce"), new IntWritable(1));
        mapReduceDriver.runTest();
    }
}
