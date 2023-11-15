package com.valtech.training.firstspringboot.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.firstspringboot.models.OrderModel;
import com.valtech.training.firstspringboot.services.OrderService;

@Controller
@RequestMapping(path = "/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping(path = "/edit")
	public String editOrder(@RequestParam("id") long id, Model model) {
		model.addAttribute("order", new OrderModel(orderService.getOrder(id)));
		return "order/edit";
	}
	
//	@GetMapping(path = "/delete")
//	public String deleteOrder(@RequestParam("id") long id,Model model) {
//		model.addAttribute("orders",
//				orderService.getAllOrders().stream().map(order -> new OrderModel(order)).collect(Collectors.toList()));
//		return "order/list";
//	}

	@PostMapping(path = "/save", params = "cancel")
	public String cancelOrder(Model model) {
		model.addAttribute("orders",
				orderService.getAllOrders().stream().map(order -> new OrderModel(order)).collect(Collectors.toList()));
		return "order/list";
	}

	@PostMapping(path = "/save", params = "submit")
	public String saveOrder(@ModelAttribute OrderModel orderModel, Model model) {
		orderService.createOrder(orderModel.getOrder());
		model.addAttribute("orders",
				orderService.getAllOrders().stream().map(order -> new OrderModel(order)).collect(Collectors.toList()));
		return "order/list";
	}

	@GetMapping("/new")
	public String newOrder(Model model) {
		model.addAttribute("order", new OrderModel());
		return "order/edit";
	}

	@GetMapping("/list")
	public String listOrders(Model model) {
		model.addAttribute("orders",
				orderService.getAllOrders().stream().map(order -> new OrderModel(order)).collect(Collectors.toList()));
		return "order/list";

	}

}