package com.bruno.vendasapi.schedulingtask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledScoreTask {

	
	private static final Logger log = LoggerFactory.getLogger(ScheduledScoreTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 60000)
	public void reportCurrentTime() {
		log.info("Hora de agora {}", dateFormat.format(new Date()));
	}
//	SELECT  PRODUTO_ID,SUM( AV.NOTA)  FROM AVALIACAO_PRODUTO AV
//	GROUP BY PRODUTO_ID
 //DEPOIS QUE FAZER OS CALCULOS ATUALZAR OS SCORES DOS PRODUTOS
//	
//	X = Média de avaliação do produto nos últimos 12 meses
//			Y = Quantidade de vendas/dias que o produto existe
//			Z = Quantidade de notícias da categoria do produto no dia corrente
//			Score = X + Y + Z
}
