package com.fstack.phong_tro_fstack.leo.landlord.controller;

import com.fstack.phong_tro_fstack.leo.landlord.base.dto.LoginRequest;
import com.fstack.phong_tro_fstack.leo.landlord.base.entity.UserEntityLandLord;
import com.fstack.phong_tro_fstack.leo.landlord.repository.UserRepositoryLandLord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
@AllArgsConstructor
public class LoginControllerLandLord {
    private final UserRepositoryLandLord userRepository;

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("LoginRequest") LoginRequest loginRequest) {
        // Xử lý dữ liệu từ frontend ở đây, ví dụ lưu vào CSDL hoặc kiểm tra đăng nhập
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        UserEntityLandLord userEntity = userRepository.login(email, password);

        if (userEntity == null) {
            // Điều hướng đến trang đăng nhập với thông báo lỗi
            ModelAndView modelAndView = new ModelAndView("/leo/sign-in");
            modelAndView.addObject("error", "Email hoặc mật khẩu không đúng");
            return modelAndView;
        } else {
            // Điều hướng đến trang chính nếu đăng nhập thành công
            return new ModelAndView("redirect:/leo/landlord/home");
        }
    }
}

