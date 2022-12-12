package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CartService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemo3.business.dtos.response.cart.AddCartResponse;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.Cart;
import com.etiya.ecommercedemo3.repository.abstracts.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartManager implements CartService {
    private CartRepository cartRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<AddCartResponse> addCart(AddCartRequest addCartRequest) {
//        Cart cart = new Cart();
//        cart.setTotalPrice(addCartRequest.getTotalPrice());

        Cart cart=modelMapperService.getMapperRequest().map(addCartRequest,Cart.class);
        Cart savedCart = cartRepository.save(cart);
        AddCartResponse response= modelMapperService.getMapperResponse().map(savedCart,AddCartResponse.class);
//        AddCartResponse response = new AddCartResponse(savedCart.getId(), savedCart.getTotalPrice());
        return new SuccessDataResult<AddCartResponse>(response, Messages.Cart.cartAddSuccessMessage);
    }
}
