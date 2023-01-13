/*
 *  Order
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.exception;

import java.time.LocalDateTime;

/**
 * The exception details.
 */
public class ExceptionDetails {
    /** The timestamp. **/
    private final LocalDateTime timestamp;
    /** The message. **/
    private final String message;
    /** The details. **/
    private final String details;

    /**
     * Instantiates a new Exception Details.
     *
     * @param timestamp the timestamp
     * @param message the message
     * @param details the details
     */
    public ExceptionDetails(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    /**
     * Gets getTimestamp.
     *
     * @return the getTimestamp
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public String getDetails() {
        return details;
    }
}
