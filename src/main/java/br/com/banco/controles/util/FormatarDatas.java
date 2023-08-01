package br.com.banco.controles.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

public class FormatarDatas {
	
	public static OffsetDateTime formatarDataInicio(LocalDate dataInicio) {
		return Optional.ofNullable(dataInicio)
        .map(date -> date.atStartOfDay().atOffset(ZoneOffset.UTC))
        .orElse(null);
	}
	
	public static OffsetDateTime formatarDataFim(LocalDate dataFim) {
		return Optional.ofNullable(dataFim)
				.map(date -> date.atTime(LocalTime.MAX).atOffset(ZoneOffset.UTC))
                .orElse(null);	
	}
}
