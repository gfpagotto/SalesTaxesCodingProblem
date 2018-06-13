package com.problem.taxes.model;

import java.math.BigDecimal;

public interface ITax {

	BigDecimal evaluateTax(BigDecimal value);

	BigDecimal taxValue(BigDecimal value);

}
