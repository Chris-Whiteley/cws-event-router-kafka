package com.cwsoft.eventrouter.global.register;

import com.cwsoft.eventrouter.global.register.data.EventsHandledByService;
import com.cwsoft.eventrouter.global.register.data.EventsHandledByServiceSerde;
import com.cwsoft.eventrouter.global.util.TopicNameHelper;
import com.cwsoft.messaging.kafka.AbstractKafkaProducer;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.util.Properties;

@SuppressWarnings("unused") // library class for use as implementation for cws-event-router
@Slf4j
@Singleton
public class EventsHandledByServiceProducer extends AbstractKafkaProducer<EventsHandledByService> {
    private final String topicName;

    public EventsHandledByServiceProducer(String eventsHandledByServiceTopicName, Properties kafkaProperties) {
        super(kafkaProperties);

        this.topicName = TopicNameHelper.provideDefaultTopicName(
                eventsHandledByServiceTopicName,
                TopicNameHelper.DEFAULT_EVENTS_HANDLED_BY_SERVICE_TOPIC
        );
    }

    @Override
    public String getDestination(EventsHandledByService eventsHandledByService) {
        return topicName;
    }

    @Override
    public String getMessageName(EventsHandledByService eventsHandledByService) {
        return TopicNameHelper.DEFAULT_EVENTS_HANDLED_BY_SERVICE_TOPIC;
    }

    @Override
    public String encode(EventsHandledByService eventsHandledByService) {
        if (eventsHandledByService == null) {
            log.error("Cannot encode a null EventsHandledByService object");
            throw new IllegalArgumentException("EventsHandledByService cannot be null");
        }

        // Serialize the message using the Serde
        String serializedMessage = EventsHandledByServiceSerde.serialize(eventsHandledByService);
        log.debug("Encoded message for topic [{}]: {}", topicName, serializedMessage);
        return serializedMessage;
    }
}
