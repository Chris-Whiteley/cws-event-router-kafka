package com.cwsoft.eventrouter.global.register;

import com.cwsoft.eventrouter.global.register.data.EventsHandledByService;
import com.cwsoft.eventrouter.global.register.data.EventsHandledByServiceKafkaSerde;
import com.cwsoft.eventrouter.global.util.TopicNameHelper;
import com.cwsoft.messaging.kafka.KafkaStream;
import lombok.NonNull;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

import java.util.Properties;

@SuppressWarnings("unused") // library class for use as implementation for cws-event-router
public class EventsHandledByServiceStream extends KafkaStream<String, EventsHandledByService> {

    private static final Class<String> KEY_CLASS = String.class;
    private static final Class<EventsHandledByService> VALUE_CLASS = EventsHandledByService.class;
    private static final Serde<String> KEY_SERDE = Serdes.String();
    private static final Serde<EventsHandledByService> VALUE_SERDE = new EventsHandledByServiceKafkaSerde();

    public EventsHandledByServiceStream( @NonNull Properties config) {
        this (null, config);
    }

    public EventsHandledByServiceStream(String eventsHandledByServiceTopicName, @NonNull Properties config) {
        super(TopicNameHelper.provideDefaultTopicName(
                eventsHandledByServiceTopicName,
                TopicNameHelper.DEFAULT_EVENTS_HANDLED_BY_SERVICE_TOPIC), config, KEY_CLASS, VALUE_CLASS, KEY_SERDE, VALUE_SERDE);
    }
}
