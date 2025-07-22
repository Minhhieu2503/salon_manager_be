package com.example.salonmanager.service.coupons;

import com.example.salonmanager.entity.Coupons;
import com.example.salonmanager.repository.CouponsRepo;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CouponServiceImpl implements CouponService{
    private CouponsRepo couponsRepo;

    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    public void updateExpiredCoupons() {
        List<Coupons> coupons = couponsRepo.findCouponsByExpiryAndIsBlocked();

        for (Coupons c : coupons){
            c.setIsBlocked(true);
            couponsRepo.save(c);
        }
    }
}