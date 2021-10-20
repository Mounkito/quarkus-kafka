package org.acme;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

public class PriceConverter {
    public static final double CONVERSION_RATE = 0.14;

    @Incoming("prices")
    @Outgoing("my-internal-stream")
    @Broadcast
    @Acknowledgment(Acknowledgment.Strategy.PRE_PROCESSING)
    public double process(int incomingPrice) {
        return incomingPrice * CONVERSION_RATE;
    }
}
