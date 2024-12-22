package com.cwsoft.eventrouter.global;

import com.cwsoft.eventrouter.Event;
import com.cwsoft.eventrouter.NamedEvent;
import com.cwsoft.eventrouter.global.util.TopicNameHelper;
import com.cwsoft.messaging.kafka.AbstractKafkaChunkingConsumer;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@SuppressWarnings("unused") // library class for use as implementation for cws-event-router
@Slf4j
public class EventConsumer extends AbstractKafkaChunkingConsumer<NamedEvent> {

    public EventConsumer(Properties properties, String serviceId) {
        this(null, properties, serviceId);
    }

    public EventConsumer(String eventsForServiceRootTopicName, Properties properties, String serviceId) {
        super(properties, TopicNameHelper.generateTopicName(eventsForServiceRootTopicName, serviceId));
    }

    @Override
    protected NamedEvent decode(String encodedEvent) {
        return Event.decode(encodedEvent);
    }
}
