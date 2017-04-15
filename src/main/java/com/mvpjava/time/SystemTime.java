/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvpjava.time;

import com.mvpjava.time.TimeSource;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.Objects;

/**
 *
 * @author aluis
 */
public class SystemTime {

   private TimeSource defaultSource = () -> LocalTime.now();
//    private TimeSource defaultSource = new TimeSource() {
//        @Override
//        public LocalTime getCurrentTime() {
//            return LocalTime.now();
//        }
//    };

    private TimeSource source;

    public SystemTime() {
    }

    //perfect for mocking during testing
    public TimeSource setSystemTime(TimeSource timeSource) {
        this.source = timeSource;
        return source; //fluent
    }

    public LocalTime asLocalTime() {
        return getTimeSource().getCurrentTime();
    }

    /*from unix epoch */
    public long asCurrentTimeMillis() {
        LocalDateTime localDateTime = convertToLocalDateTime(getTimeSource().getCurrentTime());
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.UTC);
        return offsetDateTime.toInstant().toEpochMilli();
    }

    private LocalDateTime convertToLocalDateTime(LocalTime localTime) {
        YearMonth now = YearMonth.now();

        return LocalDateTime.of(now.getYear(),
                now.getMonthValue(),
                MonthDay.now().getDayOfMonth(),
                localTime.getHour(),
                localTime.getMinute(),
                localTime.getSecond());
    }

    private TimeSource getTimeSource() {
        return (Objects.nonNull(source) ? source : defaultSource);
    }

}
