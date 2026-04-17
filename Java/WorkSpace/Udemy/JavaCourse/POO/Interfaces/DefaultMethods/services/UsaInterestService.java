/*
 *  @ Daniel Gil
 */

 package services;

public class UsaInterestService implements InterestService {

	private double interestRate;

	public UsaInterestService(double interestRate) {
		this.interestRate = interestRate;
	}

	//contracto da interface
	@Override
	public double getInterestRate() {
		return interestRate;
	}
}
