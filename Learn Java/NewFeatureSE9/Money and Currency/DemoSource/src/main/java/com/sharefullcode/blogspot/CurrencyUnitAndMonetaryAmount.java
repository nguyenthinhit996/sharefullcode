package com.sharefullcode.blogspot;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Consumer;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryOperator;
import javax.money.RoundingQuery;
import javax.money.RoundingQueryBuilder;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.GroupMonetarySummaryStatistics;
import org.javamoney.moneta.function.MonetaryFunctions;
import org.javamoney.moneta.function.MonetarySummaryStatistics;

public class CurrencyUnitAndMonetaryAmount {


	/**
	 * Create MonetaryAmount and CurrencyUnit
	 */
	void createCurrencyUnitAndMonetaryAmount() {
		// create by currency code
		CurrencyUnit vnd = Monetary.getCurrency("VND");
		CurrencyUnit usDollar = Monetary.getCurrency("USD");

		// create by currency locale
		CurrencyUnit yen = Monetary.getCurrency(Locale.JAPAN);

		// create MonetaryAmount from CurrencyUnit
		MonetaryAmount fiveYen = Money.of(5, yen);

		// create MonetaryAmount from currency code
		MonetaryAmount fiveUSD = Money.of(5, "USD");
		MonetaryAmount fiveUSDFromFastMonney = FastMoney.of(5, "USD");

	}

	/**
	 * features: add, substract, multipty, divide, round
	 */
	void calculatorBasicMonetary() {

		// ------------------------ create by currency code
		CurrencyUnit Vnd = Monetary.getCurrency("VND");
		MonetaryAmount oneMonetary = Money.of(1, Vnd);
		System.out.println(oneMonetary);

		// --------------------------------- add
		MonetaryAmount twoMonetary = oneMonetary.add(oneMonetary);
		System.out.println("add " + twoMonetary);
		// substract
		MonetaryAmount subStract = twoMonetary.subtract(oneMonetary);
		System.out.println("subtract " + subStract);
		// multiply, divide

		// -------------------------------- round monetary
		MonetaryAmount newNumber = Money.of(1234.12345544, Vnd);
		System.out.println("newNumber " + newNumber.getNumber());
		MonetaryOperator roundVND = Monetary.getRounding(Vnd);

		RoundingQueryBuilder newQueryBuilder = RoundingQueryBuilder.of();
		newQueryBuilder.setScale(4);
		newQueryBuilder.set(RoundingMode.CEILING);
		RoundingQuery newQuery = newQueryBuilder.build();

		// round cutomize
		MonetaryOperator customeRoundVND = Monetary.getRounding(newQuery);
		// round default of VND
		MonetaryOperator RoundVND = Monetary.getRounding(Vnd);
		MonetaryAmount numberAfterRound = newNumber.with(customeRoundVND);
		System.out.println("numberAfterRound" + numberAfterRound.getNumber());

	}

	/**
	 * Working with stream Check non null, Sorted, Filter, Group by CurrencyUnit
	 */
	void calculatorAdvanced() {

		List<MonetaryAmount> amounts = new ArrayList<MonetaryAmount>();
		amounts.add(Money.of(2, "EUR"));
		amounts.add(Money.of(42, "USD"));
		amounts.add(Money.of(7, "USD"));
		amounts.add(Money.of(13.37, "JPY"));
		amounts.add(Money.of(18, "USD"));
		

		System.out.println("-------------- Sorted-----------------");
		// Sorted
		amounts.stream().filter(Objects::nonNull).sorted(MonetaryFunctions.sortNumber())
				.forEach(this::printMonetaryAmountNumberAndLocale);
		
		System.out.println("-------------- Filter Only USD-----------------");
		// Sorted
		amounts.stream().filter(MonetaryFunctions.isCurrency(Monetary.getCurrency(Locale.US)))
				.forEach(this::printMonetaryAmountNumberAndLocale);
		
		System.out.println("-------------- Group by into multiMap<CurrencyUnit,List<MonetaryAmount>> by MonetaryUnit-----------------");
		// Group by into multi List<List>
		Map<CurrencyUnit,List<MonetaryAmount>> mapList=amounts.stream().collect(MonetaryFunctions.groupByCurrencyUnit());
		mapList.forEach(this::printWithMapContainList);
		
		System.out.println("-------------- MonetarySummaryStatistics calculator max, min,... by MonetaryUnit-----------------");
		// Group by into multi List<List>
		MonetarySummaryStatistics monetaryStatistics=amounts.stream().collect(MonetaryFunctions.summarizingMonetary(Monetary.getCurrency(Locale.US)));
		System.out.println("get Max of USD: "+monetaryStatistics.getMax().getNumber());
				
	}

	/**
	 *  Convert Currencies
	 */
	void exchangeRates() {
		
		MonetaryAmount oneDollar= Monetary.getDefaultAmountFactory().setNumber(1).setCurrency("USD").create();
		CurrencyConversion convertToVND = MonetaryConversions.getConversion(Monetary.getCurrency(Locale.JAPAN));
		
		MonetaryAmount numberUSDToVND = oneDollar.with(convertToVND);
		System.out.println("1 USD To YEN: "+numberUSDToVND.getNumber());
	}
	
	
	public static void main(String[] args) {
		CurrencyUnitAndMonetaryAmount s = new CurrencyUnitAndMonetaryAmount();
		s.exchangeRates();
	}
	
	void printMonetaryAmountOnlyNumber(MonetaryAmount a) {
		System.out.println(a.getNumber());
	}
	
	void printMonetaryAmountNumberAndLocale(MonetaryAmount a) {
		System.out.println(a.getNumber()+" "+a.getCurrency().toString());
	}
	
	void printWithMapContainList(CurrencyUnit firstParameter,List<MonetaryAmount> secondParamater) {
		 System.out.println("\n"+firstParameter.toString());
		 StringJoiner strPrint= new StringJoiner(",","[","]");
		 secondParamater.forEach(s->strPrint.add(s.getNumber().toString()));
		 System.out.println(strPrint.toString());
	}
}