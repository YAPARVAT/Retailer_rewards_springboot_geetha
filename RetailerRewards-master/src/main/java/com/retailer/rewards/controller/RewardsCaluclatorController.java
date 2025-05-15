/** Controller class for customer transactions and reward points calculation */
package com.retailer.rewards.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.rewards.dto.CustomerRewardsDTO;
import com.retailer.rewards.model.Rewards;
import com.retailer.rewards.service.RewardsService;

@RestController
public class RewardsCaluclatorController {
	@Autowired
	private RewardsService rewardsService;

	/*
	 * Api to create data of customer transactions and calculate reward points
	 */
	@GetMapping("/createDataSet")
	public void createDateSet() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// 1 st customer data
		Rewards r1ForCustomer1 = new Rewards();
		r1ForCustomer1.setCustomerName("customer1");
		r1ForCustomer1.setPurchaseAmount(50);
		r1ForCustomer1.setCreatedDate(sdf.parse("01/03/2025"));

		Rewards r2ForCustomer1 = new Rewards();
		r2ForCustomer1.setCustomerName("customer1");
		r2ForCustomer1.setPurchaseAmount(80);
		r2ForCustomer1.setCreatedDate(sdf.parse("05/04/2025"));

		Rewards r3ForCustomer1 = new Rewards();
		r3ForCustomer1.setCustomerName("customer1");
		r3ForCustomer1.setPurchaseAmount(100);
		r3ForCustomer1.setCreatedDate(sdf.parse("19/05/2025"));

		Rewards r4ForCustomer1 = new Rewards();
		r4ForCustomer1.setCustomerName("customer1");
		r4ForCustomer1.setPurchaseAmount(40);
		r4ForCustomer1.setCreatedDate(sdf.parse("27/05/2025"));

		// 2nd Customer data
		Rewards r1ForCustomer2 = new Rewards();
		r1ForCustomer2.setCustomerName("customer2");
		r1ForCustomer2.setPurchaseAmount(120);
		r1ForCustomer2.setCreatedDate(sdf.parse("13/04/2025"));

		Rewards r2ForCustomer2 = new Rewards();
		r2ForCustomer2.setCustomerName("customer2");
		r2ForCustomer2.setPurchaseAmount(130);
		r2ForCustomer2.setCreatedDate(sdf.parse("06/05/2025"));

		List<Rewards> rewardListForCustomers = new ArrayList<>();
		rewardListForCustomers.add(r1ForCustomer1);
		rewardListForCustomers.add(r2ForCustomer1);
		rewardListForCustomers.add(r3ForCustomer1);
		rewardListForCustomers.add(r4ForCustomer1);
		rewardListForCustomers.add(r1ForCustomer2);
		rewardListForCustomers.add(r2ForCustomer2);

		// Calculating reward points for customers
		rewardsService.caluclateRewardPoints(rewardListForCustomers);

	}

	/*
	 * Api to return total reward points and monthly wise reward points of customer
	 */
	@GetMapping("/getCustomerRewardPoints")
	public CustomerRewardsDTO getCustomerRewardPoints(String customerName) throws ParseException {
		return rewardsService.getCustomerRewardPoints(customerName);

	}
}
