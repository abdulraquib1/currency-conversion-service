package com.raq.springcloud;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {


	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		// CurrencyConversionBean currencyConversionBean
		// = new CurrencyConversionBean(10L, from, to, new BigDecimal(75), quantity);

		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);

		CurrencyConversionBean currencyConversionResp = response.getBody();
		
		CurrencyConversionBean finalResponse 
		= new CurrencyConversionBean(currencyConversionResp.getId(),from,to,currencyConversionResp.getConversionMultiple(),quantity); 

		finalResponse.setTotalCalculatedAmount(quantity.multiply(currencyConversionResp.getConversionMultiple()));
		finalResponse.setPort(currencyConversionResp.getPort());
		
		return finalResponse;

	}

}
