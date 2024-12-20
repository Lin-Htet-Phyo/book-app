package com.example.myapp.controller;

import com.example.myapp.ds.Book;
import com.example.myapp.ds.BookDto;
import com.example.myapp.service.BookService;
import com.example.myapp.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    private final CartService cartService;
    private final BookService bookService;

    public CartController(CartService cartService, BookService bookService) {
        this.cartService = cartService;
        this.bookService = bookService;
    }

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable int id, Model model) {
        cartService.addToCart(bookService.findBookById(id));
        return "redirect:/shop/books/details?id=" + id;
    }

    @GetMapping("/cart/view")
    public String viewCard(Model model) {
        model.addAttribute("cartItems", cartService.listCart());
        model.addAttribute("cartSize", cartService.cartSize());
        model.addAttribute("bookDto", new BookDto());
        return "cart-view";
    }

    /// cart/delete/'+${item.id}
    @GetMapping("/cart/delete/{id}")
    public String removeFromCart(@PathVariable("id") int id, Model model) {
        model.addAttribute("cartSize", cartService.cartSize());

        Book book = bookService.findBookById(id);
        cartService.remove(cartService.toDto(book));
        return "redirect:/cart/view";
    }

    @GetMapping("/cart/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart/view";
    }


}
