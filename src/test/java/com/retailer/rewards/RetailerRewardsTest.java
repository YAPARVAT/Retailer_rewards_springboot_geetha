package com.retailer.rewards;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retailer.rewards.dto.CustomerRewardsDTO;
import com.retailer.rewards.dto.RewardsDTO;
import com.retailer.rewards.model.Rewards;
import com.retailer.rewards.service.RewardsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetailerRewardsTest {

	@Autowired
	private RewardsService rewardsService;

	@Test
	public void getRewardPointsForCutomer1() throws ParseException {
		customer1();
		CustomerRewardsDTO customerDetails = rewardsService.getCustomerRewardPoints("customer1");
		assertTrue(customerDetails.getTotalPoints() == 80);
		assertTrue(customerDetails.getRewards().size() == 3);
		List<RewardsDTO> rewards = customerDetails.getRewards();
		assertTrue(rewards.get(0).getMonth() == 3);
		assertTrue(rewards.get(0).getMonthPoints() == 0);
	}

	private void customer1() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Rewards r1ForCustomer1 = new Rewards();
		r1ForCustomer1.setCustomerName("customer1");
		r1ForCustomer1.setPurchaseAmount(50);
		r1ForCustomer1.setCreatedDate(sdf.parse("01/03/2025"));

		Rewards r2ForCustomer2 = new Rewards();
		r2ForCustomer2.setCustomerName("customer1");
		r2ForCustomer2.setPurchaseAmount(80);
		r2ForCustomer2.setCreatedDate(sdf.parse("05/04/2025"));

		Rewards r3ForCustomer3 = new Rewards();
		r3ForCustomer3.setCustomerName("customer1");
		r3ForCustomer3.setPurchaseAmount(100);
		r3ForCustomer3.setCreatedDate(sdf.parse("19/05/2025"));

		Rewards r4ForCustomer4 = new Rewards();
		r4ForCustomer4.setCustomerName("customer1");
		r4ForCustomer4.setPurchaseAmount(40);
		r4ForCustomer4.setCreatedDate(sdf.parse("27/05/2025"));

		List<Rewards> rewardListForCustomer1 = new ArrayList<>();
		rewardListForCustomer1.add(r1ForCustomer1);
		rewardListForCustomer1.add(r2ForCustomer2);
		rewardListForCustomer1.add(r3ForCustomer3);
		rewardListForCustomer1.add(r4ForCustomer4);
		rewardsService.calculateRewardPoints(rewardListForCustomer1);
	}

	@Test
	public void getRewardPointsForCutomer2() throws ParseException {
		customer2();
		CustomerRewardsDTO customerDetails = rewardsService.getCustomerRewardPoints("customer2");
		assertTrue(customerDetails.getTotalPoints() == 200);
		assertTrue(customerDetails.getRewards().size() == 2);
		List<RewardsDTO> rewards = customerDetails.getRewards();
		assertTrue(rewards.get(0).getMonth() == 4);
		assertTrue(rewards.get(0).getMonthPoints() == 90);
	}

	private void customer2() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Rewards r1ForCustomer2 = new Rewards();
		r1ForCustomer2.setCustomerName("customer2");
		r1ForCustomer2.setPurchaseAmount(120);
		r1ForCustomer2.setCreatedDate(sdf.parse("13/04/2025"));

		Rewards r2ForCustomer2 = new Rewards();
		r2ForCustomer2.setCustomerName("customer2");
		r2ForCustomer2.setPurchaseAmount(130);
		r2ForCustomer2.setCreatedDate(sdf.parse("06/05/2025"));

		List<Rewards> rewardListForCustomer2 = new ArrayList<>();
		rewardListForCustomer2.add(r1ForCustomer2);
		rewardListForCustomer2.add(r2ForCustomer2);

		rewardsService.calculateRewardPoints(rewardListForCustomer2);
	}
}
