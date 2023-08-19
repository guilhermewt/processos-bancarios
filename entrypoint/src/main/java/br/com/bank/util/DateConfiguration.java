package br.com.bank.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;


public class DateConfiguration {
	
	public static OffsetDateTime formatStartDate(LocalDate dataInicio) {
		return Optional.ofNullable(dataInicio)
        .map(date -> date.atStartOfDay().atOffset(ZoneOffset.UTC))
        .orElse(null);
	}
	
	public static OffsetDateTime formatEndDate(LocalDate dataFim) {
		return Optional.ofNullable(dataFim)
				.map(date -> date.atTime(LocalTime.MAX).atOffset(ZoneOffset.UTC))
                .orElse(null);	
	}
}
