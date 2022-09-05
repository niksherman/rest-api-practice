package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.math.*;
import com.example.models.ChangeListPrice;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	// base price + taxes + fees
	//product id maps to price
	//apply discount
	// Request { product_id }
	// Response { list_price : "" }

	HashMap<String, BigDecimal> listPriceMap = new HashMap<String, BigDecimal>() {{
		put("1000", BigDecimal.valueOf(20.00));
		put("2000", BigDecimal.valueOf(40.00));
	}};

	@GetMapping("/get-list-price/{product_id}")
	public BigDecimal returnListPrice(@PathVariable String product_id) {
		return listPriceMap.get(product_id);
	}

	// Request { user : "ein", product_id : "", change_list price : "" }
	// Response { new_list_price : "" }
	// Status 200
	@PostMapping("/post-change-list-price")
	public BigDecimal returnChangedListPrice(ChangeListPrice changeListPrice) {
		listPriceMap.put(changeListPrice.getProductId(), changeListPrice.getChangeListPrice());
		return listPriceMap.get(changeListPrice.getProductId());
	}
}
