package github.oineh;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //TODO : 주제가 브로커에게 작성 되도록 함 , 이미 있는 경우 필요하지 않음
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name("topic1")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @KafkaListener(id ="myId", topics ="topic1")
    public void listen(String in){
        // System::println
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String,String> template){
        return (ignore) -> template.send("topic1","test");
    }
}