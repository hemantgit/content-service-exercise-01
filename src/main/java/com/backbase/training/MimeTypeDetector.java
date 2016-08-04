package com.backbase.training;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.component.file.GenericFile;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Detects files mime type using Apache Tica library.
 */
@Service
public class MimeTypeDetector implements AggregationStrategy {

    private static final Logger logger = LoggerFactory.getLogger(MimeTypeDetector.class);

    @Handler
    public String detect(GenericFile<File> body) throws Exception {
        String mimeType = new Tika().detect(body.getFile());
        logger.debug("@detect Mime Type for file: '" + body.getFileName() + "' resolved to :" + mimeType);
        return mimeType;
    }

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        logger.debug("@aggregate");
        oldExchange.getIn().setHeader("mimeType", newExchange.getIn().getBody(String.class));
        return oldExchange;
    }
}
