package com.retailer.rewards.service;

import java.util.List;

import com.retailer.rewards.dto.CustomerRewardsDTO;
import com.retailer.rewards.model.Rewards;

public interface RewardsService {

	CustomerRewardsDTO getCustomerRewardPoints(String customerName);

	void calculateRewardPoints(List<Rewards> rewardsList);
}
