package com.sharefullcode.blogspot.trywithresource;

import com.sharefullcode.blogspot.CurrencyUnitAndMonetaryAmount;
import java.lang.AutoCloseable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

public class DemoTryWithResource {
	void DemoOne() {
		List<MonetaryAmount> amounts = new ArrayList<MonetaryAmount>();
		amounts.add(Money.of(2, "EUR"));
		amounts.add(Money.of(42, "USD"));
		amounts.add(Money.of(7, "USD"));
		amounts.add(Money.of(13.37, "JPY"));
		amounts.add(Money.of(18, "USD"));
		
		Stream<MonetaryAmount> ss =amounts.stream();
		// try with auto close resource
		try(ss) {
			ss.forEach(s->System.out.println(s.getNumber()));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		DemoTryWithResource sss = new DemoTryWithResource();
		sss.DemoOne();
	}
}
