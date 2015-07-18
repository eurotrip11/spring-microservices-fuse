package it.youbnb.microservices.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateAdapter {

    private static final Logger logger = LoggerFactory.getLogger(DateAdapter.class);

    public static Date unmarshal(String xmlGregorianCalendar) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(xmlGregorianCalendar);
        } catch (DateTimeParseException ex) {
            logger.error("Could not parse date" + xmlGregorianCalendar, ex);
            return null;
        } catch (ParseException ex) {
            logger.error("Could not parse date" + xmlGregorianCalendar, ex);
            return null;
        }
    }

    public static String marshal(Date dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dateTime);
    }
}