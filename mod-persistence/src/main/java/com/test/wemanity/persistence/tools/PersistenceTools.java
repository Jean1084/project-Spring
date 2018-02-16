package com.test.wemanity.persistence.tools;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * Created by JeanDodo on 15/02/2018.
 */
public class PersistenceTools {

    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);


    public static String capitalize(String word) {
        if (!isNullOrWithSpace(word)) {
            return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
        } else {
            return null;
        }
    }


    public static Date asDate(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }


    public static LocalDate asLocalDate(Date date) {
        Instant instant = date.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate parse(String dateString) {
        try {
            return LocalDate.parse(dateString, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static boolean validDate(String dateString) {
        return parse(dateString) != null;
    }


    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }


    public static int calculAge(Date ddn) {
        LocalDate naissance = asLocalDate(ddn);
        LocalDate maintenant = LocalDate.now();
        Period period = Period.between(naissance, maintenant);
        return period.getYears();
    }


    public static int calculAge(LocalDate ddn) {
        LocalDate maintenant = LocalDate.now();
        Period period = Period.between(ddn, maintenant);
        return period.getYears();
    }

    public static String hashGuava(String mdp) {
        return Hashing.sha512().hashString(mdp.trim(), StandardCharsets.UTF_8).toString();
    }

    public static boolean isNullOrWithSpace(String mot) {
        return mot == null || mot.trim().length() == 0;
    }
}