package com.bprojects.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bprojects.order.dto.OrderDTO;
import com.bprojects.order.entity.Order;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOToOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO(Order order);

}