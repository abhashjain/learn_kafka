import jdk.nashorn.internal.codegen.CompilerConstants;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * Created by shantanus on 12/11/2017.
 */
public class DemoProducerCallback implements Callback{
        //@override
        public void onCompletion(RecordMetadata rm, Exception e){
            if (e != null) {
                e.printStackTrace();
            }else{
                System.out.println("AsyncProducer Push");
            }
        }
    }
