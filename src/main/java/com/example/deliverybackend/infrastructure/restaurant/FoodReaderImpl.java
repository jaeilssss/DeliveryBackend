package com.example.deliverybackend.infrastructure.restaurant;

import com.example.deliverybackend.domain.restaurant.dao.FoodReader;
import com.example.deliverybackend.domain.restaurant.entity.Food;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class FoodReaderImpl implements FoodReader {
    private final FoodRepository foodRepository;
    @Override
    public Food findById(Long id) {
        return null;
    }

    @Override
    public List<Food> findAll() {
        return null;
    }

    @Override
    public List<Food> findByIdList(List<Long> idList) {
        return foodRepository.findByIdList(idList);
    }
}
