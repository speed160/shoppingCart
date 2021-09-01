package org.springmvcshoppingcart.dao;

import org.spingmvcshoppingcart.entity.Product;
import org.spingmvcshoppingcart.model.PaginationResult;
import org.spingmvcshoppingcart.model.ProductInfo;

public interface ProductDAO {

	public Product findProduct(String Code);

	public ProductInfo findProductInfo(String code);

	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage);

	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName);

	public void save(ProductInfo productInfo);

}
