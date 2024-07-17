package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-17 17:03
 * @description:
 **/
@RestController
@RequestMapping("/user/shoppingCart")
@Api(tags = "c端-用户购物车")
@Slf4j
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService shoppingCartService;

	@PostMapping("/add")
	@ApiOperation("添加购物车")
	public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
		log.info("添加购物车，数据为：{}", shoppingCartDTO);
		shoppingCartService.addShoppingCart(shoppingCartDTO);
		return Result.success();
	}

	/**
	 * 减少购物车商品数量
	 * @param shoppingCartDTO
	 * @return
	 */
	@PostMapping("/sub")
	@ApiOperation("减少购物车商品数量")
	public Result sub(@RequestBody ShoppingCartDTO shoppingCartDTO) {
		log.info("减少购物车商品数量，数据为：{}", shoppingCartDTO);
		shoppingCartService.subShoppingCart(shoppingCartDTO);
		return Result.success();
	}


	/**
	 * 查看购物车
	 * @return
	 */
	@GetMapping("/list")
	@ApiOperation("查看购物车")
	public Result<List<ShoppingCart>> list() {
		List<ShoppingCart> list = shoppingCartService.showShoppingCart();
		return Result.success(list);
	}
}
