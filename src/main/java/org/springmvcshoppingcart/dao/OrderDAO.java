package org.springmvcshoppingcart.dao;

import java.util.List;

import org.spingmvcshoppingcart.model.CartInfo;
import org.spingmvcshoppingcart.model.OrderDetailInfo;
import org.spingmvcshoppingcart.model.OrderInfo;
import org.spingmvcshoppingcart.model.PaginationResult;

public interface OrderDAO {

	public void saveOrder(CartInfo cartInfo);

	public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage);

	public OrderInfo getOrderInfo(String orderId);

	public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
}
