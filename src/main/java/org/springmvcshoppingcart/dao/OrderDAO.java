package org.springmvcshoppingcart.dao;

import java.util.List;

import org.springmvcshoppingcart.model.CartInfo;
import org.springmvcshoppingcart.model.OrderDetailInfo;
import org.springmvcshoppingcart.model.OrderInfo;
import org.springmvcshoppingcart.model.PaginationResult;

public interface OrderDAO {

	public void saveOrder(CartInfo cartInfo);

	public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage);

	public OrderInfo getOrderInfo(String orderId);

	public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
}
