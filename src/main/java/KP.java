/**
 * Created by shantanus on 12/11/2017.
 */
import java.util.*;
import org.apache.kafka.clients.producer.*;
import org.apache.avro.*;
import customerManagement.avro.Customer;
public class KP {


    public static void main(String[] args) throws Exception{

        String topicName = "SimpleProducerTopic";
        String key = "Key1";
        String value = "Value-1";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093");
        props.put("key.serializer","io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("schema.registry.url", "http://localhost:8081");
        Producer<String, Customer> producer = new KafkaProducer <String, Customer>(props);

        Customer c = new Customer(1,"Shantanu","120102");
        ProducerRecord<String, Customer> record = new ProducerRecord<String, Customer>(topicName,c.getId().toString(), c);
        //ProducerRecord<String, String> r1 = new ProducerRecord<String, String>("CustomerCountry", "Precision Products",	  "France");

        try {
            RecordMetadata m = producer.send(record).get();
            System.out.println(m.topic().toString());
            //producer.send(r1, new DemoProducerCallback());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        producer.close();

        System.out.println("SimpleProducer Completed.");
    }
}

