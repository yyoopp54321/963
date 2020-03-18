package com.example.zt.interceptor;

        import com.example.zt.controller.BookController;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

//    @Autowired
//    private InitInterceptor initInterceptor;

    //
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())//添加拦截器
                .addPathPatterns("/CollectionController/**","/CommentController/**","/SecondCommentController/**", "/BookController/**",
                        "/UserController/alter/userInfo"
                ) //拦截所有请求
                .excludePathPatterns("/UserController/user/register", "/UserController/user/login");//对应的不拦截的请求
    }
}