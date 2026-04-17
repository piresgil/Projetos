/*
 *  @ Daniel Gil
 */

 package services;

import java.security.InvalidParameterException;

public interface InterestService {

	double getInterestRate();

	//Method default
	default double payment(double amount, int months) {
		if (months < 1) {
			throw new InvalidParameterException("Months must be greater than zero");
		}
		// Payment = 200 * 1.02 * 1.02 * 1.02 = 200 * 1.023 = 212.2416
		// Payment = amount * (1 + interestRate / 100)N
		return amount * Math.pow(1.0 + getInterestRate() / 100.0, months);
	}
}
