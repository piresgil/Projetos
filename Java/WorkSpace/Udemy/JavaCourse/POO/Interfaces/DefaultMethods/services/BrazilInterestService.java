/*
 *  @ Daniel Gil
 */

 package services;

public class BrazilInterestService implements InterestService {

	private double interestRate;

	public BrazilInterestService(double interestRate) {
		this.interestRate = interestRate;
	}

	//contracto da Interface
	@Override
	public double getInterestRate() {
		return interestRate;
	}
}
